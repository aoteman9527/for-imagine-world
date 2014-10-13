package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.imagine.world.common.AvatarType;
import com.imagine.world.common.DaoUtils;
import com.imagine.world.common.UserType;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.UserProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by tuan on 10/9/14.
 *
 */
@Component
public class NormalUserService implements UserServiceI {

    @Resource
    Session session;

    @Override
    public void authorize(ServiceState serviceState, String email, String password) throws MyException {

        //TODO : ......
        serviceState.changeToReviewerUser();
    }

    @Override
    public void logOut() throws MyException {

    }

    @Override
    public void issueArticle() throws AuthorizationException {
        throw new AuthorizationException("Current user is not allow to use this function");
    }

    @Override
    public void register(String username, String email, String password,
                         Date birthday, Integer userType, BigDecimal timezone, Integer rank,
                         String avatar, String avatarType, Integer avatarWidth, Integer avatarHeight,
                         String userSig, String userFrom) throws MyException {

        //        ValidationUtils.rejectIfEmptyOrWhitespace();
        Preconditions.checkArgument(USERNAME_PATTERN_C.matcher(username).matches(),"Invalid username "+username);
        Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(email).matches(),"Invalid email");
        Preconditions.checkArgument(PASSWORD_PATTERN_C.matcher(password).matches(),"Invalid password");
        // validate timezone http://stackoverflow.com/questions/13092865/timezone-validation-in-java

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setUserEmail(email);
        userProfile.setPassword(password);

        if(null!=userType)
            userProfile.setUserType(userType);
        else
            userProfile.setUserType(UserType.NORMAL_USER.getValue());

        if(null!=birthday){
            userProfile.setBirthday(birthdayFormat.format(birthday));
        }

        if(null!=timezone){
            Preconditions.checkArgument(isValidTimezone(timezone),"Invalid Timezone");
            userProfile.setTimezone(timezone);
        } else {
            userProfile.setTimezone(new BigDecimal(0.00));
        }

        if(null!=rank && rank>=0){
            userProfile.setUserRank(rank);
        }

        //avatarType is not null
        if(!Strings.isNullOrEmpty(avatarType) && !Strings.isNullOrEmpty(avatar)){
            if(avatarType == AvatarType.UPLOADED.getValue()){
                String tempPath = session.getTempAvatarPath();
                File tempFile = new File(tempPath);
                String newPath = "/tmp/local_avtar."+tempFile.getName();
                avatar = newPath;
                try {
                    Files.move(tempFile,new File(newPath));
                } catch (IOException e) {
                    throw new InprocessException("ERROR moving temp avatar to fixed local "+e.getMessage());
                }
            }

            userProfile.setUserAvatar(avatar);
            userProfile.setAvatarType(avatarType);
            userProfile.setAvatarWidth(avatarWidth);
            userProfile.setAvatarHeight(avatarHeight);
        }

        if(!Strings.isNullOrEmpty(userSig))
            userProfile.setUserSig(userSig);
        if(!Strings.isNullOrEmpty(userFrom))
            userProfile.setUserFrom(userFrom);

        //To DAO and save
        DaoUtils.getUsersDao().insert(userProfile.toUserDao());
    }

    @Override
    public void uploadTempAvatar(MultipartFile multipartFile) throws MyException {
        if(!multipartFile.isEmpty())
            try {
                String fileName = multipartFile.getOriginalFilename();
                String path = "/tmp/"+simpleDateFormat.format(new Date())+"."+fileName;
                multipartFile.transferTo(new File(path));
                session.setTempAvatarPath(path);
            } catch (IOException e) {
                throw new InprocessException("Error of multipartFile transfer fail "+e.getMessage());
            }
        else
            throw new InprocessException("MultipartFile is empty !!!");

    }

    @Override
    public void userInfo() throws MyException {

    }

    @Override
    public void modifyUser() throws MyException {

    }

    ///////// ValidateUtils /////////////////////////
    public boolean isValidTimezone(BigDecimal timezone){
        return 0 <= timezone.doubleValue() && timezone.doubleValue() <=23;
//        String[] availableIDs = TimeZone.getAvailableIDs();
//        for (String tzId : availableIDs) {
//            if(tzId.equals(timezone))
//                return true;
//        }
//        return false;
    }
}
