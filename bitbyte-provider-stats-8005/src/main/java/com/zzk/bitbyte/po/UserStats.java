package com.zzk.bitbyte.po;

import lombok.Data;

/**
 * @Author: zzk
 * @Date: 2020-02-03 22:28
 */
@Data
public class UserStats extends Stats {
    private String regTime;
    private String birthday;
    private String sex;
}
