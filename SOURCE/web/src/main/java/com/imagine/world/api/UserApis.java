package com.imagine.world.api;

import com.google.common.collect.Maps;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.SearchableList;
import com.imagine.world.models.UserProfile;
import com.imagine.world.service.UserServiceI;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by tuan on 10/10/14.
 */
@Service
@RequestMapping
public class UserApis extends BaseApi {

    @RequestMapping(value = "authorize",method = RequestMethod.POST)
    @ResponseBody
    public void authorize(
            HttpServletResponse response,
            @RequestParam String email,
            @RequestParam String password
    ) throws MyException {
        serviceState.getService().authorize(response,email,password);
    }

    @RequestMapping(value = "logOut",method = RequestMethod.GET)
    @ResponseBody
    public void logOut() throws MyException {
        serviceState.getService().logOut();
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public void register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String birthday,
            @RequestParam(required = false) Integer userType,
            @RequestParam(required = false) BigDecimal timezone,
            @RequestParam(required = false) Integer rank,
            @RequestParam(required = false) String avatar,
            @RequestParam(required = false) String avatarType,
            @RequestParam(required = false) Short avatarWidth,
            @RequestParam(required = false) Short avatarHeight,
            @RequestParam(required = false) String userSig,
            @RequestParam(required = false) String userFrom
    ) throws MyException, ParseException {
        serviceState.getService().register(
                username,
                email,
                password,
                UserServiceI.birthdayFormat.parse(birthday),
                userType,
                timezone,
                rank,
                avatar,
                avatarType,
                avatarWidth,
                avatarHeight,
                userSig,
                userFrom
        );
    }

    @RequestMapping(value = "uploadTempAvatar",method = RequestMethod.POST)
    public void uploadTeampAvatar( @RequestParam("tempFile") MultipartFile multipartFile) throws MyException {
        serviceState.getService().uploadTempAvatar(multipartFile);
    }

    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    @ResponseBody
    public UserProfile userInfo( HttpServletResponse httpServletResponse) throws MyException {
        return serviceState.getService().userInfo(httpServletResponse);
    }

    @RequestMapping(value = "modifyUser", method = RequestMethod.POST)
    public void modifyUser(
            HttpServletResponse httpServletResponse,
            @RequestParam Integer userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String currentEmail,
            @RequestParam(required = false) String newEmail,
            @RequestParam(required = false) String newPass,
            @RequestParam(required = false) String currentPass,
            @RequestParam(required = false) String userBirthday,
            @RequestParam(required = false) Integer userType,
            @RequestParam(required = false) String userAvatar,
            @RequestParam(required = false) String userAvatarType,
            @RequestParam(required = false) Short userAvatarWidth,
            @RequestParam(required = false) Short userAvatarHeight,
            @RequestParam(required = false) String userSig,
            @RequestParam(required = false) String userFrom
    ) throws MyException {
        serviceState.getService().modifyUser(
                httpServletResponse,
                userId,
                username,
                currentEmail,
                newEmail,
                newPass,
                currentPass,
                userBirthday,
                userType,
                userAvatar,
                userAvatarType,
                userAvatarWidth,
                userAvatarHeight,
                userSig,
                userFrom
                );
    }

    @RequestMapping(value = "postNew",method = RequestMethod.POST)
    @ResponseBody
    public void postNew(
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

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public void reply(
            HttpServletResponse httpServletResponse,
            @RequestParam Integer forumId,
            @RequestParam Integer topicId,
            @RequestParam String subject,
            @RequestParam String text
    ) throws MyException {
        serviceState.getService().reply(
                httpServletResponse,
                forumId,
                topicId,
                subject,
                text
        );
    }

    @RequestMapping(value = "getTopics",method = RequestMethod.POST)
    @ResponseBody
    public Map getTopics(
            HttpServletResponse response,
            @RequestParam int forumId,
            @RequestParam int page,
            @RequestParam int num,
            @RequestParam String sortType
    ) throws MyException {
        return serviceState.getService().getTopics(
                response,
                forumId,
                page,
                num,
                sortType
        );
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

    @RequestMapping(value = "testLogin", method = RequestMethod.GET)
    @ResponseBody
    public void testLogin( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws MyException {
        serviceState.getService().authorize(
//                serviceState, request,
                httpServletResponse, "letuan@gmail.com", "123456");

    }
}
