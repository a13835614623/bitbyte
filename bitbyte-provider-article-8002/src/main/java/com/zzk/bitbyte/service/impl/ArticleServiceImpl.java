package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.*;
import com.zzk.bitbyte.po.*;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import com.zzk.bitbyte.service.ArticleService;
import com.zzk.bitbyte.util.ArticleState;
import com.zzk.bitbyte.util.RecommendUtil;
import com.zzk.bitbyte.util.RedisUtil;
import com.zzk.bitbyte.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    public static final String KEY_ARTICLE_PRE = "bitbyte:article:";

    public static final String ARTICLE_READ = "articleRead";
    public static final String ARTICLE_LIKE_NUM = "articleLikeNum";
    public static final String ARTICLE_ID = "articleId";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleExtendMapper articleExtendMapper;

    @Autowired
    private ArticleLikeMapper articleLikeMapper;

    @Autowired
    private ReadHistoryMapper readHistoryMapper;

    @Autowired
    private ReadHistoryExtendMapper readHistoryExtendMapper;

    /**
     * 每1分钟同步一次文章阅读量
     */
    @Scheduled(cron = "0 */1 * * * ? ")
    public void syncArticleRead() {
        log.info("======================开始 同步文章阅读量======================");
        Set<String> set = redisUtil.keys(KEY_ARTICLE_PRE + "*");
        if (set.size() == 0) {
            log.info("======================结束 文章阅读量同步结束======================");
            return;
        }
        Long startTime = System.nanoTime();
        List<Article> articleList = new ArrayList<>(set.size());
        int keyPreLength = KEY_ARTICLE_PRE.length();
        Article article;
        try {
            for (String key : set) {
                article = new Article();
                article.setArticleId(key.substring(keyPreLength));
                Object read = redisUtil.hget(key, ARTICLE_READ);
                if (read == null) continue;
                article.setArticleRead(Long.parseLong((String) read));
                articleList.add(article);
            }
            //更新到数据库中
            articleExtendMapper.updateArticleRead(articleList);
            Long endTime = System.nanoTime();
            log.info("本次文章访问量同步成功, 总耗时: {}", (endTime - startTime) / 1000000 + "ms");
        } catch (Exception e) {
            log.error("本次文章阅读量同步失败", e);
        } finally {
            log.info("======================结束 文章阅读量同步结束======================");
        }
    }

    @Override
    public String tempArticle(ArticleWithBLOBs article) throws Exception {
        Date d = new Date();
        article.setUpdateat(d);
        String articleId = article.getArticleId();
        // 如果是之前没有暂存过，则生成ID之后插入数据
        if (Util.isEmpty(articleId)) {
            articleId = UUID.randomUUID().toString();
            article.setArticleId(articleId);
            article.setCreateat(d);
            article.setArticleRead(0L);
            article.setArticleState(ArticleState.CREATED.getValueId());
            articleMapper.insert(article);
        } else {// 否则更新
            articleMapper.updateByPrimaryKeySelective(article);
            // 删除缓存
            redisUtil.del(KEY_ARTICLE_PRE + articleId);
        }
        return articleId;
    }

    @Override
    public void publishArticle(String articleId) throws Exception {
        if (Util.isEmpty(articleId)) {
            throw new Exception("文章标题不能为空");
        }
        ArticleWithBLOBs article = new ArticleWithBLOBs();
        article.setArticleId(articleId);
        article.setUpdateat(new Date());
        article.setArticlePublishTime(new Date());
        article.setArticleState(ArticleState.PUBLISHED.getValueId());
        articleMapper.updateByPrimaryKeySelective(article);
        // 删除缓存
        redisUtil.del(KEY_ARTICLE_PRE + articleId);
    }

    @Override
    public void updateArticleState(String articleId, ArticleState articleState) throws Exception {
        ArticleWithBLOBs article = new ArticleWithBLOBs();
        article.setArticleId(articleId);
        article.setUpdateat(new Date());
        article.setArticleState(articleState.getValueId());
        articleMapper.updateByPrimaryKeySelective(article);
        // 删除缓存
        redisUtil.del(KEY_ARTICLE_PRE + articleId);
    }

    @Override
    public ArticleExtend findArticleAndContentById(String articleId) throws Exception {
        if (Util.isEmpty(articleId))
            throw new Exception("文章ID不能为空!");
        String key = KEY_ARTICLE_PRE + articleId;
        ArticleExtend articleExtend;
        Map<String, Object> map = redisUtil.hmget(key);
        if (map.size() > 10) {
            articleExtend = map2Article(map);
        } else {
            articleExtend = articleExtendMapper.findArticleExtendById(articleId);
            // 如果未发布就不存入缓存
            if (articleExtend.getArticleState() != ArticleState.PUBLISHED.getValueId()) {
                return articleExtend;
            }
            try {
                Map<String, Object> toRedisMap = article2Map(articleExtend);
                // 移除key
                toRedisMap.remove(ARTICLE_READ);
                // 存入缓存
                redisUtil.hmset(key, toRedisMap, Util.randomExpTime(1));
                // 获取锁
                redisUtil.lock(articleId, 2);
                Object read = map.get(ARTICLE_READ);
                Long redisReadNum = read != null ? Long.parseLong((String) read) : 0L;
                redisReadNum += articleExtend.getArticleRead();
                redisUtil.hset(key, ARTICLE_READ,
                        redisReadNum + "",
                        Util.randomExpTime(1));
            } catch (Exception e) {
                // 异常则删除key
                redisUtil.del(key);
                e.printStackTrace();
            } finally {
                // 释放锁
                redisUtil.unLock(articleId);
            }
        }
        return articleExtend;
    }

    /**
     * 增加阅读量
     *
     * @param articleId
     * @throws Exception
     */
    @Override
    public void addArticleReadCount(String articleId, String userId) throws Exception {
        String key = KEY_ARTICLE_PRE + articleId;
        addReadHistory(articleId, userId);
        // 获取锁
        redisUtil.lock(articleId, 2);
        try {
            // 增加阅读量
            redisUtil.hincr(key, ARTICLE_READ, 1);
        } finally {
            // 释放锁
            redisUtil.unLock(articleId);
        }
    }

    public void addReadHistory(String articleId, String userId) {
        ReadHistory readHistory = new ReadHistory();
        Date now = new Date();
        readHistory.setReadArticle(articleId);
        readHistory.setReadUser(userId);
        readHistory.setCreateat(now);
        readHistory.setReadTime(now);
        readHistory.setUpdateat(now);
        readHistoryMapper.insert(readHistory);
    }

    public static Date long2Date(Object o) {
        return new Date(Long.parseLong((String) o));
    }

    public ArticleExtend map2Article(Map<String, Object> map) {
        ArticleExtend articleExtend = new ArticleExtend();
        articleExtend.setArticleId((String) map.get(ARTICLE_ID));
        articleExtend.setArticleTitle((String) map.get("articleTitle"));
        articleExtend.setArticleUser((String) map.get("articleUser"));
        articleExtend.setArticleContent((String) map.get("articleContent"));
        articleExtend.setArticleMdContent((String) map.get("articleMdContent"));
        // int
        articleExtend.setArticleState(Integer.parseInt((String) map.get("articleState")));
        articleExtend.setArticleRead(Long.parseLong((String) map.get(ARTICLE_READ)));
        articleExtend.setArticlePublishTime(long2Date(map.get("articlePublishTime")));
        articleExtend.setArticleTags((String) map.get("articleTags"));
        articleExtend.setArticlePart(Integer.parseInt((String) map.get("articlePart")));
        articleExtend.setUserName((String) map.get("userName"));
        articleExtend.setUserPic((String) map.get("userPic"));
        return articleExtend;
    }

    public Map<String, Object> article2Map(ArticleExtend articleExtend) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Map<String, Object> map = new HashMap<>();
        final String PRE = "article";
        map.put(PRE + "Id", articleExtend.getArticleId());
        map.put(PRE + "Title", articleExtend.getArticleTitle());
        map.put(PRE + "User", articleExtend.getArticleUser());
        map.put(PRE + "Content", articleExtend.getArticleContent());
        map.put(PRE + "MdContent", articleExtend.getArticleMdContent());
        //int
        map.put(PRE + "State", articleExtend.getArticleState() + "");
        //long
        map.put(PRE + "Read", articleExtend.getArticleRead().toString());
        // date
        map.put(PRE + "PublishTime", articleExtend.getArticlePublishTime().getTime() + "");
        map.put(PRE + "Tags", articleExtend.getArticleTags());
        // int
        map.put(PRE + "Part", articleExtend.getArticlePart().toString());
        map.put("userName", articleExtend.getUserName());
        map.put("userPic", articleExtend.getUserPic());
        return map;
    }

    /**
     * 通过查询条件查询文章数量
     *
     * @param vo 查询条件
     * @throws Exception
     */
    @Override
    public Integer findArticleCountByQueryVo(ArticleQueryVo vo) throws Exception {
        return articleExtendMapper.findArticleCountByQueryVo(vo);
    }

    @Override
    public void likeArticle(String userId, String articleId) throws Exception {
        if (Util.isEmpty(articleId))
            throw new Exception("文章ID不能为空!");
        if (Util.isEmpty(userId))
            throw new Exception("用户ID不能为空!");
        Date d = new Date();
        ArticleLike articleLike = new ArticleLike();
        articleLike.setLikeArticle(articleId);
        articleLike.setLikeUser(userId);
        articleLike.setCreateat(d);
        articleLike.setUpdateat(d);
        articleLike.setLikeTime(d);
        articleLikeMapper.insert(articleLike);
        // 删除点赞缓存
        redisUtil.hdel(KEY_ARTICLE_PRE + articleId, ARTICLE_LIKE_NUM);
    }

    @Override
    public void dislikeArticle(String userId, String articleId) throws Exception {
        if (Util.isEmpty(articleId))
            throw new Exception("文章ID不能为空!");
        if (Util.isEmpty(userId))
            throw new Exception("用户ID不能为空!");
        ArticleLikeKey key = new ArticleLikeKey();
        key.setLikeArticle(articleId);
        key.setLikeUser(userId);
        articleLikeMapper.deleteByPrimaryKey(key);
        // 删除点赞缓存
        redisUtil.hdel(KEY_ARTICLE_PRE + articleId, ARTICLE_LIKE_NUM);
    }

    @Override
    public boolean isLikeArticle(String userId, String articleId) throws Exception {
        if (Util.isEmpty(articleId))
            throw new Exception("文章ID不能为空!");
        if (Util.isEmpty(userId))
            throw new Exception("用户ID不能为空!");
        ArticleLikeKey key = new ArticleLikeKey();
        key.setLikeArticle(articleId);
        key.setLikeUser(userId);
        return articleLikeMapper.selectByPrimaryKey(key) != null;
    }

    /**
     * 点赞数量
     *
     * @param articleId
     * @return
     * @throws Exception
     */
    @Override
    public Long findArticleLikeCount(String articleId) throws Exception {
        if (Util.isEmpty(articleId))
            throw new Exception("文章ID不能为空!");
        ArticleLikeExample example = new ArticleLikeExample();
        example.setDistinct(true);
        ArticleLikeExample.Criteria criteria = example.createCriteria();
        criteria.andLikeArticleEqualTo(articleId);
        String key = KEY_ARTICLE_PRE + articleId;
        Object o = redisUtil.hget(key, ARTICLE_LIKE_NUM);
        long count;
        if (o != null) {
            count = Long.parseLong((String) o);
        } else {
            count = articleLikeMapper.countByExample(example);
        }
        return count;
    }

    /**
     * 通过用户id查找文章列表
     *
     * @param userId
     * @return 文字列表
     * @
     */
    @Override
    public List<Article> findArticlesByUserId(String userId) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleUserEqualTo(userId);
        example.createCriteria().andArticleStateNotEqualTo(ArticleState.DELETED.getValueId());
        return articleMapper.selectByExample(example);
    }

    @Override
    public void deleteArticle(String userId, String articleId) throws Exception {
        ArticleWithBLOBs article =new ArticleWithBLOBs();
        article.setArticleId(articleId);
        article.setArticleState(ArticleState.DELETED.getValueId());
        articleMapper.updateByPrimaryKeySelective(article);
        // 删除文章缓存
        redisUtil.del(KEY_ARTICLE_PRE + articleId);
    }


    @Override
    public List<ArticleExtend> findArticleAndAuthorByQueryVo(ArticleQueryVo articleQueryVo) throws Exception {
        if (articleQueryVo == null) {
            throw new Exception("查询条件不能为空!");
        }
        if (articleQueryVo.getStart() != null) {
            articleQueryVo.setStart(Math.max(0, articleQueryVo.getStart()));
        }
        if (articleQueryVo.getCount() != null) {
            articleQueryVo.setCount(Math.min(100, articleQueryVo.getCount()));
        }
        return articleExtendMapper.findArticleAndAuthorByQueryVo(articleQueryVo);
    }

    @Override
    public List<ArticleExtend> findLatestSubArticleAndAuthorByUserId(String userId) throws Exception {
        if (Util.isEmpty(userId)) {
            throw new Exception("用户ID不能为空!");
        }
        return articleExtendMapper.findLatestSubArticleAndAuthorByUserId(userId);
    }

    /**
     * 获取推荐文章列表
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<ArticleExtend> findRecommendArticleList(String userId) throws Exception {
        if (Util.isEmpty(userId)) return convertIdToArticle(articleExtendMapper.findRandomArticleIdWithAuthor(5));
        // 1. 获取该用户阅读过的所有文章
        List<String> articleIdList = readHistoryExtendMapper.findReadArticleByUserId(userId);
        // 相似用户列表
        List<String> similarUserList = readHistoryExtendMapper.findUserIdListByArticleId(articleIdList);
        // 用户ID与阅读文章集合的映射
        Map<String, Set<String>> userArticleMap = new HashMap<>();
        // 遍历相似用户列表，将文章与uid映射添加到map
        for (String uid : similarUserList) {
            // 排除自身
            if (uid.equals(userId)) continue;
            Set<String> articleIds = new HashSet<>(readHistoryExtendMapper.findReadArticleByUserId(uid));
            userArticleMap.put(uid, articleIds);
        }
        List<String> recommendArticleIdList = RecommendUtil.getRecommendArticleIdList(userArticleMap,
                new HashSet<>(articleIdList), 10);
        Set<String> recommendArticleIdSet = new HashSet<>(recommendArticleIdList);
        int subCount = 10 - recommendArticleIdList.size();
        if (subCount > 0) {
            recommendArticleIdSet.addAll(articleExtendMapper.findRandomArticleIdWithAuthor(subCount));
        }
        return recommendArticleIdList.stream().map(articleExtendMapper::findArticleExtendById).collect(Collectors.toList());
    }

    private List<ArticleExtend> convertIdToArticle(List<String> recommendArticleIdList) {
        return recommendArticleIdList.stream().map(articleExtendMapper::findArticleExtendById).collect(Collectors.toList());
    }
}

