package com.imagine.world.mvc.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by letuan on 6/9/14.
 */

public abstract class BaseController {
    protected static final String BOM_REQUEST_FILE="file";
    protected static final String BOM_REQUEST_CLEAR="clear";
    protected static final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleServiceException(Exception exception, HttpServletResponse response){
        HashMap<String,Object> error = Maps.newLinkedHashMap();
        error.put("errorType",exception.getClass().getSimpleName());
        error.put("errorMessage",exception.getMessage());
        return error;
    }

}
