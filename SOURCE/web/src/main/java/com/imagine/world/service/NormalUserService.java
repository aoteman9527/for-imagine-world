package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.imagine.world.common.AvatarType;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.UserProfile;

import java.util.Date;


/**
 * Created by tuan on 10/9/14.
 *
 */
public class NormalUserService implements UserServiceI {

    @Override
    public void authorize(ServiceState serviceState, String username, String email, String password,
                          Date birthday, Integer userType, String timezone, Integer rank,
                          String avatar, String avatarType, Integer avatarWidth, Integer avatarHeight,
                          String userSig, String userFrom) throws MyException {
        //        ValidationUtils.rejectIfEmptyOrWhitespace();
        Preconditions.checkArgument(USERNAME_PATTERN_C.matcher(username).matches(),"Invalid username");
        Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(email).matches(),"Invalid email");
        Preconditions.checkArgument(STRING_PATTERN_C.matcher(password).matches(),"Invalid password");
        // validate timezone http://stackoverflow.com/questions/13092865/timezone-validation-in-java

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setUserEmail(email);
        userProfile.setBirthday(simpleDateFormat.format(birthday));
        userProfile.setTimezone(timezone);
        userProfile.setUserRank(rank);

        //avatarType is not null
        if(!Strings.isNullOrEmpty(avatarType) && !Strings.isNullOrEmpty(avatar)){
            if(avatarType == AvatarType.UPLOADED.getValue()){
                //TODO : move out temp to folder /avatar
                avatar = "new path to avatar";
            }
            userProfile.setUserType(userType);
            userProfile.setUserAvatar(avatar);
        }

        userProfile.setAvatarType(avatarType);
        userProfile.setAvatarWidth(avatarWidth);
        userProfile.setAvatarHeight(avatarHeight);
        userProfile.setUserSig(userSig);
        userProfile.setUserFrom(userFrom);
    }

    @Override
    public void logOut() throws MyException {

    }

    @Override
    public void issueArticle() throws AuthorizationException {
        throw new AuthorizationException("Current user is not allow to use this function");
    }

    @Override
    public void register() throws MyException {

    }

    @Override
    public void uploadTempAvatar() throws MyException {

    }

    @Override
    public void userInfo() throws MyException {

    }

    @Override
    public void modifyUser() throws MyException {

    }
}
