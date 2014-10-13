package com.imagine.world.api;

import com.imagine.world.exception.MyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tuan on 10/10/14.
 */
@Service
@RequestMapping("/")
public class UserApis extends BaseApi {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public void login() throws MyException {
        serviceState.getService().authorize(serviceState);
    }

    @RequestMapping(value = "uploadTempAvatar",method = RequestMethod.POST)
    public void uploadTeampAvatar( @RequestParam("tempFile") MultipartFile multipartFile){
        if (!multipartFile.isEmpty()) {
        } else {
        }
    }
}
