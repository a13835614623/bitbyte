package com.zzk.bitbyte.exception;

import com.zzk.bitbyte.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class GateWayExceptionHandler extends DefaultErrorWebExceptionHandler {


    public GateWayExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
                                   ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

        /**
         * 获取异常属性
         */
        @Override
        protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
            int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
            Throwable error = super.getError(request);
            if (error instanceof org.springframework.cloud.gateway.support.NotFoundException) {
                code = HttpStatus.NOT_FOUND.value();
            } if(error instanceof AuthenticationException){
                code = HttpStatus.UNAUTHORIZED.value();
            }
            return response(code, this.buildMessage(request, error));
        }

        /**
         * 指定响应处理方法为JSON处理的方法
         * @param errorAttributes
         */
        @Override
        protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
            return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
        }


        /**
         * 根据code获取对应的HttpStatus
         * @param errorAttributes
         */
        @Override
        protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
            int statusCode = (int) errorAttributes.get("status");
            return HttpStatus.valueOf(statusCode);
        }

        /**
         * 构建异常信息
         * @param request
         * @param ex
         * @return
         */
        private String buildMessage(ServerRequest request, Throwable ex) {
            StringBuilder message = new StringBuilder();
            if (ex != null) {
                if(ex instanceof DisabledException){
                    message.append("该用户不可用!");
                }else {
                    message.append(ex.getMessage());
                }
            }
            return message.toString();
        }

        /**
         * 构建返回的JSON数据格式
         * @param status        状态码
         * @param errorMessage  异常信息
         * @return
         */
        public static Map<String, Object> response(int status, String errorMessage) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", status);
            if(Util.isEmpty(errorMessage)){
                errorMessage="服务器异常,请稍后重试!";
            }
            map.put("message", errorMessage);
            map.put("data", null);
            map.put("more", null);
            log.error(map.toString());
            return map;
        }
    }