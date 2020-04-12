package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.cache.UserAuthCacheManager;
import com.zzk.bitbyte.channel.RecordChannel;
import com.zzk.bitbyte.config.PathConfig;
import com.zzk.bitbyte.message.MessageProducer;
import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.extend.UserExtend;
import com.zzk.bitbyte.po.query.UserQueryVo;
import com.zzk.bitbyte.service.AuthorityService;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Roles;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

@RestController
@EnableBinding(RecordChannel.class)
@RequestMapping("/user")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private PathConfig pathConfig;

    @Autowired
    private UserAuthCacheManager userAuthCacheManager;

    @Autowired
    private AuthorityService authorityService;
    /**
     * 添加记录
     *
     * @param recordContent 记录
     * @param recordUser    记录用户id
     */
    public void addRecord(String recordContent, String recordUser) {
        Record record = new Record();
        record.setRecordContent(recordContent);
        record.setRecordUser(recordUser);
        messageProducer.send(record);
    }

    /**
     * 通过id获取用户信息
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/get/{userId}")
    public ResponseState get(@PathVariable String userId) throws Exception {
        User u = userService.findUserById(userId);
        if (u == null) {
            throw new Exception("此用户不存在!");
        }
        return ResponseState.success("查询成功!").setData(u);
    }

    /**
     * 通过查询条件获取用户信息
     *
     * @param queryVo 查询条件
     */
    @RequestMapping(value = "/list")
    public ResponseState list(@RequestBody UserQueryVo queryVo) throws Exception {
        ResponseState state = new ResponseState();
        List<User> list = userService.findUserListByQueryVo(queryVo);
        state.setData(list);
        state.setMore(list.size());
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("查询成功!");
        return state;
    }

    /**
     * 通过查询条件获取用户数量
     *
     * @param queryVo 查询条件
     */
    @RequestMapping(value = "/count")
    public ResponseState count(@RequestBody UserQueryVo queryVo) throws Exception {
        return ResponseState.success("查询成功!").setData(userService.findUsersCountByQueryVo(queryVo));
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId
     */
    @RequestMapping(value = "/delete")
    public ResponseState delete(@RequestParam("userId") String userId) throws Exception {
        userService.deleteByUserId(userId);
        return ResponseState.success("删除成功!");
    }


    /**
     * 用户注册
     *
     * @param user 用户
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseState register(@Validated @RequestBody UserExtend user, BindingResult bindingResult) throws Exception {
        Util.handleBindingError(bindingResult);
        UserQueryVo queryVo = new UserQueryVo();
        UserExtend user1 = new UserExtend();
        user1.setUserMobile(user.getUserMobile());
        user1.setUserEmail(user.getUserEmail());
        queryVo.setUser(user1);
        ResponseState state = new ResponseState();
        // 获取校验错误信息
        Integer result = userService.findUsersCountByQueryVo(queryVo);
        if (result != null && result > 0) {
            state.setStatus(ResponseState.STATUS_WARNING);
            state.setMessage("手机号或邮箱已经被注册!");
            return state;
        } else {
            user.setUserPic("user.png");
            User regUser = userService.addUser(user);
            // 设置角色为USER
            authorityService.addRoleToUser(Roles.USER.getRoleId(), regUser.getUserId());
            state.setStatus(ResponseState.STATUS_SUCCESS);
            state.setMessage("恭喜你,注册成功!");
            // 记录用户
            addRecord("注册", regUser.getUserId());
            return state;
        }
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseState updateInfo(@RequestBody User user) throws Exception {
        ResponseState state = new ResponseState();
        user.setUserPassword(null);
        userService.updateUser(user);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("更新成功");
        // 记录用户
        addRecord("更新基本信息", user.getUserId());
        return state;
    }

    /**
     * 验证密码
     *
     * @param userId   用户id
     * @param password 密码
     * @throws Exception
     */
    @RequestMapping(value = "/password/validate", method = RequestMethod.POST)
    public ResponseState validatePassword(@RequestParam String userId,
                                          @RequestParam String password) throws Exception {
        ResponseState state = new ResponseState();
        UserQueryVo queryVo = new UserQueryVo();
        UserExtend user = new UserExtend();
        user.setUserId(userId);
        user.setUserPassword(password);
        queryVo.setUser(user);
        Integer count = userService.findUsersCountByQueryVo(queryVo);
        if (count > 0) {// 查找成功
            state.setStatus(ResponseState.STATUS_SUCCESS);
            state.setMessage("验证成功!");
        } else {
            state.setStatus(ResponseState.STATUS_WARNING);
            state.setMessage("验证失败!");
        }
        return state;
    }

    /**
     * 改变用户密码
     *
     * @param userId
     * @param password
     */
    @RequestMapping(value = "/password/update", method = RequestMethod.POST)
    public ResponseState updatePassword(@RequestParam String userId,
                                        @RequestParam String password) throws Exception {
        ResponseState state = new ResponseState();
        User user = new User();
        user.setUserId(userId);
        user.setUserPassword(password);
        userService.updateUser(user);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("密码更新成功");
        // 删除认证信息缓存
        userAuthCacheManager.deleteAuthInfoCache(userId);
        // 记录用户
        addRecord("更改密码", user.getUserId());
        return state;
    }

    /**
     * 获取用户头像
     *
     * @param user_pic
     * @param response
     */
    @RequestMapping(value = "/pic/get")
    public void getPic(@RequestParam("name") String user_pic, HttpServletResponse response)
            throws Exception {
        if (user_pic == null || user_pic.equals("undefined") || user_pic.equals("")) {
            throw new Exception("此图片不存在");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathConfig.getPicPath() + user_pic));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte bys[] = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }

    /**
     * 更新用户头像
     *
     * @param userPicFile 用户头像文件
     * @param userId      用户id
     */
    @RequestMapping(value = "/pic/update", method = RequestMethod.POST)
    public ResponseState updatePic(@RequestParam("file") MultipartFile userPicFile,
                                   @RequestParam("userId") String userId) throws Exception {
        ResponseState state = new ResponseState();

        // 原图片名称
        String oldFileName = null;

        if (userPicFile == null || (oldFileName = userPicFile.getOriginalFilename()) == null
                || oldFileName.length() > 3 << 20) {
            throw new Exception("图片上传失败");
        }
        // 新图片名称
        String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));

        File file = new File(newFileName);
        // 将内存中的图片写入磁盘
        userPicFile.transferTo(file);
        // 将新的图片名称写入数据库
        User u = new User();
        u.setUserId(userId);
        u.setUserPic(newFileName);
        userService.updateUser(u);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("头像更新成功!");
        // 记录用户
        addRecord("更新用户头像", userId);
        return state;
    }


    /**
     * 获取用户关注列表
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/subscribe")
    public ResponseState getSubscribers(@RequestParam("userId") String userId,
                                        @RequestParam("start") Integer start,
                                        @RequestParam("count") Integer count) throws Exception {
        ResponseState state = new ResponseState();
        List<User> subscribers = userService.findSubscribersById(userId,start,count);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(subscribers);
        state.setMore(userService.findSubscriberCountByUserId(userId));
        state.setMessage("获取关注列表成功!");
        return state;
    }
    /**
     * 获取用户关注数量
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/subscribe/count")
    public ResponseState getSubscribersCount(@RequestParam("userId") String userId) throws Exception {
        return ResponseState.success("获取关注数量成功").setData(userService.findSubscriberCountByUserId(userId));
    }

    /**
     * 获取粉丝列表
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/fans")
    public ResponseState getFans(@RequestParam("userId") String userId,
                                 @RequestParam("start") Integer start,
                                 @RequestParam("count") Integer count) throws Exception {
        ResponseState state = new ResponseState();
        List<User> fans = userService.findFansByUserId(userId,start,count);
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setData(fans);
        state.setMore(userService.findFansCountByUserId(userId));
        state.setMessage("获取粉丝列表成功!");
        return state;
    }
    /**
     * 获取用户粉丝数量
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/fans/count")
    public ResponseState getFansCount(@RequestParam("userId") String userId) throws Exception {
        return ResponseState.success("获取关注数量成功").setData(userService.findFansCountByUserId(userId));
    }
}
