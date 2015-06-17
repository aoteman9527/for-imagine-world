package com.imagine.world.api;

import com.google.common.collect.Maps;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.service.ServiceState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by tuan on 10/9/14.
 */

public abstract class BaseApi {

    @Resource
    ServiceState serviceState;

    /**
     * using this method just throw any exception. this will transform exception to JSON file.
     * @param exception
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleServiceException(Exception exception, HttpServletResponse response){
        HashMap<String,Object> error = Maps.newLinkedHashMap();
        error.put("errorType",exception.getClass().getSimpleName());
        error.put("errorMessage",exception.getMessage());

        if(exception.getClass().equals(AuthorizationException.class)){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        exception.printStackTrace();
        return error;
    }

}
