package com.imagine.world.api;

import com.google.common.collect.*;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.SearchableList;
import com.imagine.world.models.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by tuan on 10/10/14.
 */
@Service
@RequestMapping("/")
public class UserApis extends BaseApi {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public Object login() throws MyException {
//        serviceState.getService().authorize(serviceState);
        return new Session();
    }

    @RequestMapping(value = "uploadTempAvatar",method = RequestMethod.POST)
    public void uploadTeampAvatar( @RequestParam("tempFile") MultipartFile multipartFile){
        if (!multipartFile.isEmpty()) {
        } else {
        }
    }

    @RequestMapping(value = "testcookie", method = RequestMethod.GET)
    @ResponseBody
    public Object testCookie( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Cookie[] cookies =  httpServletRequest.getCookies();
        SearchableList<Cookie> searchableList = SearchableList.newSearchableList(cookies);
        Map map = Maps.newHashMap();

        Cookie cookieSessionId = new Cookie("sessionId", httpServletRequest.getSession().getId());//set as default. because i has not updated sequences :D
        Cookie cookieUserId = new Cookie("userId", "test");//set as default. because i has not updated sequences :D
        cookieSessionId.setMaxAge(3600);// 1 year
        cookieUserId.setMaxAge(60*60*24*365);// 1 year
        if(cookies!=null && cookies.length>1&& httpServletRequest.getSession().getId() != searchableList.get(searchableList.indexOf(cookieSessionId,new Comparator<Cookie>() {
            @Override
            public int compare(Cookie cookie, Cookie cookie2) {
                return cookie.getName().compareTo(cookie2.getName());
            }
        })).getValue())
            httpServletResponse.addCookie(cookieSessionId);
//            httpServletResponse.addCookie(cookieUserId);


        map.put("new sessionid", httpServletRequest.getSession().getId());
        map.put("old sessionid ", searchableList.get(searchableList.indexOf(cookieSessionId,new Comparator<Cookie>() {
            @Override
            public int compare(Cookie cookie, Cookie cookie2) {
                return cookie.getName().compareTo(cookie2.getName());
            }
        })).getValue());
        return map;

    }
}
