package com.imagine.world.service;

import com.imagine.world.exception.MyException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by tuan on 10/9/14.
 * Service is sigleton but Factorry must is session for seperate state.
 */
public interface UserServiceI {
    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    static final Pattern EMAIL_PATTERN_C = Pattern.compile(EMAIL_PATTERN);
    static final String ID_PATTERN = "[0-9]+";
    static final String STRING_PATTERN = "[a-zA-Z]+";
    static final Pattern STRING_PATTERN_C = Pattern.compile(STRING_PATTERN);
    static final String MOBILE_PATTERN = "[0-9]{10}";
    static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,16}$";
    static final Pattern USERNAME_PATTERN_C = Pattern.compile(USERNAME_PATTERN);

    /**
     *
     * @param serviceState
     * @param username
     * @param email
     * @param password
     * @param birthday
     * @param userType
     * @param timezone
     * @param rank
     * @param avatar URL / filename /
     * @param avatarType
     * @param avatarWidth
     * @param avatarHeight
     * @param userSig
     * @param userFrom
     * @throws MyException
     */
    public void authorize(ServiceState serviceState,String username, String email, String password, Date birthday, Integer userType, String timezone, Integer rank, String avatar, String avatarType, Integer avatarWidth, Integer avatarHeight, String userSig, String userFrom) throws MyException;
    public void logOut() throws MyException;
    public void issueArticle() throws MyException;
    public void register() throws MyException;
    public void uploadTempAvatar() throws MyException;
    public void userInfo() throws MyException;
    public void modifyUser() throws MyException;
}
