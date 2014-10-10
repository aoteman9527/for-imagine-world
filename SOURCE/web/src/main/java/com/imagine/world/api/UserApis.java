package com.imagine.world.api;

import com.imagine.world.exception.MyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tuan on 10/10/14.
 */
@Service
@RequestMapping("/")
public class UserApis extends BaseApi {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public void login() throws MyException {
//        serviceState.getService().authorize(serviceState);
    }
}
