package com.imagine.world.service;

import com.imagine.world.exception.MyException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by tuan on 10/9/14.
 * Service is sigleton but Factorry must is session for seperate state.
 */
public interface UserServiceI {
    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    static final SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    static final Pattern EMAIL_PATTERN_C = Pattern.compile(EMAIL_PATTERN);
    static final String ID_PATTERN = "[0-9]+";
    static final String PASSWORD_PATTERN = "[a-zA-Z0-9]{3,16}";
    static final Pattern PASSWORD_PATTERN_C = Pattern.compile(PASSWORD_PATTERN);
    static final String MOBILE_PATTERN = "[0-9]{10}";
    static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,16}$";
    static final Pattern USERNAME_PATTERN_C = Pattern.compile(USERNAME_PATTERN);
    static final int LOGIN_FAIL_TIMEOUT = 30;//second unit
    static final int MAX_LOGIN_ATTEMPS = 5;//
    static final String COOKIE_KEY_SESSION_ID="sessionId";
    static final String COOKIE_KEY_USER_ID="userId";

    public void authorize(ServiceState serviceState,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String email, String password) throws MyException;
    public void logOut() throws MyException;
    public void issueArticle() throws MyException;
    public void register(String username, String email, String password, Date birthday, Integer userType, BigDecimal timezone, Integer rank, String avatar, String avatarType, Integer avatarWidth, Integer avatarHeight, String userSig, String userFrom) throws MyException;
    public void uploadTempAvatar(MultipartFile multipartFile) throws MyException;
    public void userInfo() throws MyException;
    public void modifyUser() throws MyException;
}
