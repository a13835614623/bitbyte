package com.zzk.bitbyte.po.query;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 抽象查询包装类
 * @Author: zzk
 * @Date: 2020-01-20 20:27
 */
@Setter
@Getter
public abstract class QueryVo {
    @NotNull(message = "查询对象开始索引不能为空!")
    @Min(value = 0,message = "查询开始索引不能小于0!")
    private Integer start;

    @NotNull(message = "查询数量不能为空!")
    @Max(value = 20,message = "查询数量不能超过20!")
    @Min(value = 0,message = "查询数量不能小于0!")
    private Integer count;
}
