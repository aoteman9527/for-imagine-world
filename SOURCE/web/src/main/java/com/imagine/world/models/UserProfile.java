package com.imagine.world.models;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.imagine.world.common.AvatarType;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by tuan on 10/10/14.
 */
public class UserProfile {

    private String username;
    private String userEmail;
    private String password;
    private String birthday;
    private Integer userType;
    private BigDecimal timezone;
    private Integer userRank;
    private String userAvatar;
    private String avatarType;
    private Integer avatarWidth;
    private Integer avatarHeight;
    private String userSig;
    private String userFrom;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getTimezone() {
        return timezone;
    }

    public void setTimezone(BigDecimal timezone) {
        this.timezone = timezone;
    }

    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getAvatarType() {
        return avatarType;
    }

    public void setAvatarType(String avatarType) {
        this.avatarType = avatarType;
    }

    public Integer getAvatarWidth() {
        return avatarWidth;
    }

    public void setAvatarWidth(Integer avatarWidth) {
        this.avatarWidth = avatarWidth;
    }

    public Integer getAvatarHeight() {
        return avatarHeight;
    }

    public void setAvatarHeight(Integer avatarHeight) {
        this.avatarHeight = avatarHeight;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public UsersEntity toUserDao(){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserEmail(this.userEmail);
        usersEntity.setUserPassword(this.password);
        usersEntity.setUserFrom(Objects.firstNonNull(this.userFrom,""));//Strings.isNullOrEmpty(this.userFrom)?"":this.userFrom
        usersEntity.setUserSig(Objects.firstNonNull(this.userSig,""));
        usersEntity.setUserBirthday(this.birthday);
        usersEntity.setUserType(this.userType.byteValue());
        usersEntity.setUserTimezone(this.timezone);
        usersEntity.setUserRank(Objects.firstNonNull(this.userRank,0));
        usersEntity.setUsername(this.username);
        usersEntity.setUsernameClean(this.username.toLowerCase());

        if(!Strings.isNullOrEmpty(this.userAvatar)){
            usersEntity.setUserAvatar(this.userAvatar);
            usersEntity.setUserAvatarType(new Integer(AvatarType.valueOf(this.avatarType.toUpperCase()).getValue2()).byteValue());
            usersEntity.setUserAvatarHeight(new Integer(Objects.firstNonNull(this.avatarHeight,0)).shortValue());
            usersEntity.setUserAvatarWidth(new Integer(Objects.firstNonNull(this.avatarWidth,0)).shortValue());
        } else {
            usersEntity.setUserAvatar("");
        }

        usersEntity.setUserActkey(new Random().nextInt(16)+"");
        usersEntity.setUserAim("");
        usersEntity.setUserColour("");
        usersEntity.setUserDateformat("");
        usersEntity.setUserFormSalt("");
        usersEntity.setUserIcq("");
        usersEntity.setUserInterests("");
        usersEntity.setUserIp("");
        usersEntity.setUserJabber("");
        usersEntity.setUserLang("");
        usersEntity.setUserLastConfirmKey("");
        usersEntity.setUserLastpage("");
        usersEntity.setUserMsnm("");
        usersEntity.setUserNewpasswd("");
        usersEntity.setUserOcc("");
        usersEntity.setUserPermissions("");
        usersEntity.setUserPostSortbyDir("");
        usersEntity.setUserPostSortbyType("");
        usersEntity.setUserSigBbcodeBitfield("");
        usersEntity.setUserSigBbcodeUid("");
        usersEntity.setUserTopicSortbyDir("");
        usersEntity.setUserTopicSortbyType("");
        usersEntity.setUserWebsite("");
        usersEntity.setUserYim("");

        return usersEntity;
    }
}
