package com.zzk.bitbyte.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzk.bitbyte.util.ResponseState;

/**
 * 异常处理器
 *
 * @author zzk
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class MyExceptionResolver {
    @ExceptionHandler(Exception.class)
    public ResponseState exception(Exception e) {
        ResponseState state = new ResponseState();
        state.setMessage(e.getMessage());
        state.setStatus(ResponseState.STATUS_ERROR);
        log.error(e.getMessage(), e);
        return state;
    }
}
