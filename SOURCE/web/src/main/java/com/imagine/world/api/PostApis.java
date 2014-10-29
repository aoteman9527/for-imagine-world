package com.imagine.world.api;

import com.imagine.world.exception.MyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tuan on 10/10/14.
 */
@Service
public class PostApis extends BaseApi {

    @RequestMapping(value = "postNew",method = RequestMethod.POST)
    @ResponseBody
    public void authorize(
            HttpServletResponse response,
            @RequestParam Integer forumId,
            @RequestParam String subject,
            @RequestParam String text
    ) throws MyException {
        serviceState.getService().postNew(
                response,
                forumId,
                subject,
                text
        );     
    }
    

}
