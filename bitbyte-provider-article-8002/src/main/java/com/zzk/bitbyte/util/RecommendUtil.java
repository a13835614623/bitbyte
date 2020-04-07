package com.zzk.bitbyte.util;

import com.zzk.bitbyte.po.extend.ArticleExtend;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 推荐算法工具类
 *
 * @Author: zzk
 * @Date: 2020-04-06 12:17
 */
public class RecommendUtil {
    /**
     * 获取最高相似度的K个用户ID列表
     *
     * @param userArticleMap K-用户ID V-已阅读过的文章ID列表
     * @param articleIdList  目标用户的文章ID列表,用于计算相似度
     * @param K              数量
     * @return
     */
    public static List<String> getKUserList(Map<String, Set<String>> userArticleMap,
                                            List<String> articleIdList,
                                            int K) {
        Set<String> compArticleSet = new HashSet<>(articleIdList);
        Set<Map.Entry<String, Set<String>>> entries = userArticleMap.entrySet();
        TreeSet<MyMap<String, Double>> set = new TreeSet<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int i = 0;
        for (Map.Entry<String, Set<String>> entry : entries) {
            double degree = calculateSimilarityDegree(compArticleSet, entry.getValue());
            String key = entry.getKey();
            if (set.size() <= K) {
                set.add(new MyMap<>(key, degree));
            } else {
                MyMap<String, Double> min = set.last();
                if (degree > min.getValue()) {
                    set.remove(min);
                    set.add(new MyMap<>(key, degree));
                }
            }
        }
        return set.stream().map(MyMap::getKey).collect(Collectors.toList());
    }

    /**
     * 获取用户ID，相似度map
     *
     * @param userArticleMap K-用户ID V-已阅读过的文章ID列表
     * @param articleIdSet  目标用户的文章ID列表,用于计算相似度
     * @return
     */
    public static Map<String, Double> getUserSimilarityMap(Map<String, Set<String>> userArticleMap,
                                                           Set<String> articleIdSet) {
        Set<String> compArticleSet = new HashSet<>(articleIdSet);
        Map<String, Double> resMap = new HashMap<>();
        Set<Map.Entry<String, Set<String>>> entries = userArticleMap.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
            double degree = calculateSimilarityDegree(compArticleSet, entry.getValue());
            resMap.put(entry.getKey(), degree);
        }
        return resMap;
    }

    /**
     * 获取推荐文章ID列表
     *
     * @param userArticleMap    用户文章map
     * @param K                 文章数量
     * @return
     */
    public static List<String> getRecommendArticleIdList(Map<String, Set<String>> userArticleMap,
                                                          Set<String> articleIdSet,
                                                          final int K) {
//        Map<String, List<String>> articleUserMap = new HashMap<>();
        Map<String, Double> userSimilarityMap = getUserSimilarityMap(userArticleMap, articleIdSet);
        // 文章推荐度map
        Map<String, Double> articleSimilarityMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> userArticlesEntry : userArticleMap.entrySet()) {
            String userId = userArticlesEntry.getKey();
            // 用户相似度度
            Double userSimilarity = userSimilarityMap.get(userId);
            // 遍历文章列表
            for (String articleId : userArticlesEntry.getValue()) {
//                List<String> userList = articleUserMap.get(articleId);
                Double similarity = articleSimilarityMap.get(articleId);
                if (similarity == null) {
                    articleSimilarityMap.put(articleId, userSimilarity);
                    ArrayList<String> list = new ArrayList<>();
                    list.add(userId);
//                    articleUserMap.put(articleId, list);
                } else {
//                    userList.add(userId);
                    articleSimilarityMap.put(articleId, similarity + userSimilarity);
                }
            }
        }
        Set<Map.Entry<String, Double>> entrySet = articleSimilarityMap.entrySet();
        TreeSet<MyMap<String, Double>> set = new TreeSet<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<String, Double> entry : entrySet) {
            Double value = entry.getValue();
            String key = entry.getKey();
            if (articleIdSet.contains(key)) continue;
            if (set.size() < K) {
                set.add(new MyMap<>(key, value));
            } else {
                MyMap<String, Double> min = set.last();
                if (value > min.getValue()) {
                    set.remove(min);
                    set.add(new MyMap<>(key, value));
                }
            }
        }
        return set.stream().map(MyMap::getKey).collect(Collectors.toList());
    }


    /**
     * 计算杰卡德相似系数
     */
    public static double calculateSimilarityDegree(Set<String> setA, Set<String> setB) {
        if (setA == null || setB == null || setA.size() == 0 || setB.size() == 0) return 0.0;
        double similarNum, totalNum = setA.size() + setB.size();
        similarNum = (int) setA.stream().filter(setB::contains).count();
        return similarNum / (totalNum - similarNum);
    }

    static class MyMap<K, V> {
        private K key;
        private V value;

        MyMap(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyMap)) return false;
            MyMap myMap = (MyMap) obj;
            return myMap.getValue().equals(key) && myMap.getValue().equals(value);
        }
    }

    public static void main(String[] args) {
        List<ArticleExtend> list = new ArrayList<>();
        // 要计算的用户的文章列表
        List<String> articleIdList = Arrays.asList("文章A", "文章C");
        // 相似用户列表
        List<String> similarUserList = Arrays.asList("用户A", "用户B", "用户C", "用户D", "用户E");
        // 用户ID与阅读文章集合的映射
        Map<String, Set<String>> userArticleMap = new HashMap<>();
        // 遍历相似用户列表，将文章与uid映射添加到map
        userArticleMap.put("用户A", new HashSet<>(Arrays.asList("文章A", "文章B")));
        userArticleMap.put("用户B", new HashSet<>(Arrays.asList("文章C", "文章D", "文章E")));
        userArticleMap.put("用户C", new HashSet<>(Arrays.asList("文章A", "文章C")));
        userArticleMap.put("用户D", new HashSet<>(Arrays.asList("文章B", "文章D", "文章E")));
        userArticleMap.put("用户E", new HashSet<>(Arrays.asList("文章B", "文章C", "文章E")));
        getRecommendArticleIdList(userArticleMap, new HashSet<>(articleIdList), 1)
                .forEach(System.out::println);
    }
}
