package com.imagine.world.api;

import com.google.common.collect.Maps;
import com.imagine.world.service.ServiceState;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by tuan on 10/9/14.
 */
public abstract class BaseApi {

    @Resource(name = "serviceFactory")
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
        return error;
    }


}
