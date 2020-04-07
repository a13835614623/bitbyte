package com.zzk.bitbyte.service.fallback;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.query.UserQueryVo;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.ResponseState;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
	@Override
	public UserService create(Throwable cause) {
		return new UserService() {
			@Override
			public ResponseState get(String userId) {
				return ResponseState.error("用户信息查询失败,请重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState list(UserQueryVo queryVo) {
				return ResponseState.error("用户信息查询失败,请重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState count(UserQueryVo queryVo) {
				return ResponseState.error("数量查询失败,,请重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState register(User user) {
				return ResponseState.error("注册失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState updateInfo(User user) {
				return ResponseState.error("更新失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState authInfo(String mobileOrEmail) {
				return ResponseState.error("用户信息查询失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState login(User user) {
				return ResponseState.error("登录失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState validatePassword(String userId, String password) {
				return ResponseState.error("密码验证失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState updatePassword(String userId, String password) {
				return ResponseState.error("密码更新失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public void getPic(String user_pic, HttpServletResponse response) {
				
			}

			@Override
			public ResponseState updatePic(MultipartFile userPicFile, String userId) {
				return ResponseState.error("头像更新失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState getArticlesByUserId(String userId) {
				return ResponseState.error("文章信息查询失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState getSubscribers(String userId) {
				return ResponseState.error("关注列表查询失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState getFans(String userId) {
				return ResponseState.error("粉丝数查询失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}

			@Override
			public ResponseState getRecords(String userId) {
				return ResponseState.error("记录查询失败,请稍候重试!", Const.SERVICE_PROVIDER_ERROR);
			}
		};
	}
}
