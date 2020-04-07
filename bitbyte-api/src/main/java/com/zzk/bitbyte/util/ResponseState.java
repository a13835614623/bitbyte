package com.zzk.bitbyte.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应状态
 *
 * @author zzk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseState {
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_WARNING = "warning";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_TOKEN_INVALID = "101";// TOKEN无效或不存在
    public static final String STATUS_TOKEN_EXPIRE = "102";//TOKEN过期
    private String status;//状态标识符
    private String message;//消息
    private String token;//令牌
    private Object data;//数据
    private Object more;//额外数据

    public static ResponseState success(String message,Object more){
        return new ResponseState(STATUS_SUCCESS,message,null,null,more);
    }
    public static ResponseState success(String message){
        return new ResponseState(STATUS_SUCCESS,message,null,null,null);
    }
    public static ResponseState error(String message,Object more){
        return new ResponseState(STATUS_ERROR,message,null,null,more);
    }

    public static ResponseState error(String message){
        return new ResponseState(STATUS_ERROR,message,null,null,null);
    }

    public static ResponseState warning(String message,Object more){
        return new ResponseState(STATUS_WARNING,message,null,null,more);
    };

    public static ResponseState warning(String message ){
        return new ResponseState(STATUS_WARNING,message,null,null,null);
    };
}
