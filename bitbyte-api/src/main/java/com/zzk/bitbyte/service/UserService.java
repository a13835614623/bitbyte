package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.query.UserQueryVo;
import com.zzk.bitbyte.service.fallback.UserServiceFallbackFactory;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@FeignClient(value = "BITBYTE-USER",fallbackFactory = UserServiceFallbackFactory.class)
@RequestMapping("user")
public interface UserService {
    /**
     * 通过id获取用户信息
     *
     * @param userId  用户id
     */
    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public ResponseState get(@PathVariable("userId") String userId);

    /**
     * 通过查询条件获取用户信息
     *
     * @param queryVo 查询条件
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseState list(@RequestBody UserQueryVo queryVo);

    /**
     * 通过查询条件获取用户数量
     *
     * @param queryVo 查询条件
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseState count(@RequestBody UserQueryVo queryVo);

    /**
     * 用户注册
     *
     * @param user 用户
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseState register(@RequestBody User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseState updateInfo(@RequestBody User user);


    @RequestMapping("/auth/info")
    public ResponseState authInfo(@RequestParam("username") String mobileOrEmail);

    /**
     * 登录
     *
     * @param user 用户
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseState login(@RequestBody User user);

    /**
     * 验证密码
     *
     * @param userId   用户id
     * @param password 密码
     * @throws Exception
     */
    @RequestMapping(value = "/password/validate", method = RequestMethod.POST)
    public ResponseState validatePassword(@RequestParam("userId") String userId,
                                          @RequestParam("password") String password);

    /**
     * 改变用户密码
     *
     * @param userId
     * @param password
     */
    @RequestMapping(value = "/password/update", method = RequestMethod.POST)
    public ResponseState updatePassword(@RequestParam("userId") String userId,
                                        @RequestParam("password") String password);

    /**
     * 获取用户头像
     *
     * @param user_pic
     * @param response
     */
    @RequestMapping(value = "/pic/get", method = RequestMethod.GET)
    public void getPic(@RequestParam("name") String user_pic, HttpServletResponse response);

    /**
     * 更新用户头像
     *
     * @param userPicFile 用户头像文件
     * @param userId      用户id
     */
    @RequestMapping(value = "/pic/update", method = RequestMethod.POST)
    public ResponseState updatePic(@RequestParam("file") MultipartFile userPicFile,
                                   @RequestParam("userId") String userId);

    /**
     * 获取用户文章列表
     *
     * @param userId
     * @throws Exception
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResponseState getArticlesByUserId(@RequestParam("userId") String userId);

    /**
     * 获取用户关注列表
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public ResponseState getSubscribers(@RequestParam("userId") String userId);

    /**
     * 获取粉丝列表
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/fans", method = RequestMethod.GET)
    public ResponseState getFans(@RequestParam("userId") String userId);

    /**
     * 获取用户操作记录
     *
     * @param userId 用户id
     */
    @RequestMapping(value = "/record", method = RequestMethod.GET)
    public ResponseState getRecords(@RequestParam("userId") String userId);

}
