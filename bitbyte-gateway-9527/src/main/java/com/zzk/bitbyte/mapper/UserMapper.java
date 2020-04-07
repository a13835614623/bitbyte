package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.extend.UserExtend;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzk
 * @Date: 2020-02-25 14:29
 */
@Mapper
public interface UserMapper {

    UserExtend findUserByMobileOrEmail(String mobileOrEmail);
}
