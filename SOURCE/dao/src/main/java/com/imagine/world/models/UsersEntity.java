package com.imagine.world.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@javax.persistence.Table(name = "USERS", schema = "", catalog = "blogs")
public class UsersEntity {
    private int userId;

    @Id
    @javax.persistence.Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private byte userType;

    @Basic
    @javax.persistence.Column(name = "user_type")
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    private int groupId;

    @Basic
    @javax.persistence.Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    private String userPermissions;

    @Basic
    @javax.persistence.Column(name = "user_permissions")
    public String getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(String userPermissions) {
        this.userPermissions = userPermissions;
    }

    private int userPermFrom;

    @Basic
    @javax.persistence.Column(name = "user_perm_from")
    public int getUserPermFrom() {
        return userPermFrom;
    }

    public void setUserPermFrom(int userPermFrom) {
        this.userPermFrom = userPermFrom;
    }

    private String userIp;

    @Basic
    @javax.persistence.Column(name = "user_ip")
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    private int userRegdate;

    @Basic
    @javax.persistence.Column(name = "user_regdate")
    public int getUserRegdate() {
        return userRegdate;
    }

    public void setUserRegdate(int userRegdate) {
        this.userRegdate = userRegdate;
    }

    private String username;

    @Basic
    @javax.persistence.Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String usernameClean;

    @Basic
    @javax.persistence.Column(name = "username_clean")
    public String getUsernameClean() {
        return usernameClean;
    }

    public void setUsernameClean(String usernameClean) {
        this.usernameClean = usernameClean;
    }

    private String userPassword;

    @Basic
    @javax.persistence.Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private int userPasschg;

    @Basic
    @javax.persistence.Column(name = "user_passchg")
    public int getUserPasschg() {
        return userPasschg;
    }

    public void setUserPasschg(int userPasschg) {
        this.userPasschg = userPasschg;
    }

    private byte userPassConvert;

    @Basic
    @javax.persistence.Column(name = "user_pass_convert")
    public byte getUserPassConvert() {
        return userPassConvert;
    }

    public void setUserPassConvert(byte userPassConvert) {
        this.userPassConvert = userPassConvert;
    }

    private String userEmail;

    @Basic
    @javax.persistence.Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private long userEmailHash;

    @Basic
    @javax.persistence.Column(name = "user_email_hash")
    public long getUserEmailHash() {
        return userEmailHash;
    }

    public void setUserEmailHash(long userEmailHash) {
        this.userEmailHash = userEmailHash;
    }

    private String userBirthday;

    @Basic
    @javax.persistence.Column(name = "user_birthday")
    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    private int userLastvisit;

    @Basic
    @javax.persistence.Column(name = "user_lastvisit")
    public int getUserLastvisit() {
        return userLastvisit;
    }

    public void setUserLastvisit(int userLastvisit) {
        this.userLastvisit = userLastvisit;
    }

    private int userLastmark;

    @Basic
    @javax.persistence.Column(name = "user_lastmark")
    public int getUserLastmark() {
        return userLastmark;
    }

    public void setUserLastmark(int userLastmark) {
        this.userLastmark = userLastmark;
    }

    private int userLastpostTime;

    @Basic
    @javax.persistence.Column(name = "user_lastpost_time")
    public int getUserLastpostTime() {
        return userLastpostTime;
    }

    public void setUserLastpostTime(int userLastpostTime) {
        this.userLastpostTime = userLastpostTime;
    }

    private String userLastpage;

    @Basic
    @javax.persistence.Column(name = "user_lastpage")
    public String getUserLastpage() {
        return userLastpage;
    }

    public void setUserLastpage(String userLastpage) {
        this.userLastpage = userLastpage;
    }

    private String userLastConfirmKey;

    @Basic
    @javax.persistence.Column(name = "user_last_confirm_key")
    public String getUserLastConfirmKey() {
        return userLastConfirmKey;
    }

    public void setUserLastConfirmKey(String userLastConfirmKey) {
        this.userLastConfirmKey = userLastConfirmKey;
    }

    private int userLastSearch;

    @Basic
    @javax.persistence.Column(name = "user_last_search")
    public int getUserLastSearch() {
        return userLastSearch;
    }

    public void setUserLastSearch(int userLastSearch) {
        this.userLastSearch = userLastSearch;
    }

    private byte userWarnings;

    @Basic
    @javax.persistence.Column(name = "user_warnings")
    public byte getUserWarnings() {
        return userWarnings;
    }

    public void setUserWarnings(byte userWarnings) {
        this.userWarnings = userWarnings;
    }

    private int userLastWarning;

    @Basic
    @javax.persistence.Column(name = "user_last_warning")
    public int getUserLastWarning() {
        return userLastWarning;
    }

    public void setUserLastWarning(int userLastWarning) {
        this.userLastWarning = userLastWarning;
    }

    private byte userLoginAttempts;

    @Basic
    @javax.persistence.Column(name = "user_login_attempts")
    public byte getUserLoginAttempts() {
        return userLoginAttempts;
    }

    public void setUserLoginAttempts(byte userLoginAttempts) {
        this.userLoginAttempts = userLoginAttempts;
    }

    private byte userInactiveReason;

    @Basic
    @javax.persistence.Column(name = "user_inactive_reason")
    public byte getUserInactiveReason() {
        return userInactiveReason;
    }

    public void setUserInactiveReason(byte userInactiveReason) {
        this.userInactiveReason = userInactiveReason;
    }

    private int userInactiveTime;

    @Basic
    @javax.persistence.Column(name = "user_inactive_time")
    public int getUserInactiveTime() {
        return userInactiveTime;
    }

    public void setUserInactiveTime(int userInactiveTime) {
        this.userInactiveTime = userInactiveTime;
    }

    private int userPosts;

    @Basic
    @javax.persistence.Column(name = "user_posts")
    public int getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(int userPosts) {
        this.userPosts = userPosts;
    }

    private String userLang;

    @Basic
    @javax.persistence.Column(name = "user_lang")
    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    private BigDecimal userTimezone;

    @Basic
    @javax.persistence.Column(name = "user_timezone")
    public BigDecimal getUserTimezone() {
        return userTimezone;
    }

    public void setUserTimezone(BigDecimal userTimezone) {
        this.userTimezone = userTimezone;
    }

    private byte userDst;

    @Basic
    @javax.persistence.Column(name = "user_dst")
    public byte getUserDst() {
        return userDst;
    }

    public void setUserDst(byte userDst) {
        this.userDst = userDst;
    }

    private String userDateformat;

    @Basic
    @javax.persistence.Column(name = "user_dateformat")
    public String getUserDateformat() {
        return userDateformat;
    }

    public void setUserDateformat(String userDateformat) {
        this.userDateformat = userDateformat;
    }

    private int userStyle;

    @Basic
    @javax.persistence.Column(name = "user_style")
    public int getUserStyle() {
        return userStyle;
    }

    public void setUserStyle(int userStyle) {
        this.userStyle = userStyle;
    }

    private int userRank;

    @Basic
    @javax.persistence.Column(name = "user_rank")
    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    private String userColour;

    @Basic
    @javax.persistence.Column(name = "user_colour")
    public String getUserColour() {
        return userColour;
    }

    public void setUserColour(String userColour) {
        this.userColour = userColour;
    }

    private int userNewPrivmsg;

    @Basic
    @javax.persistence.Column(name = "user_new_privmsg")
    public int getUserNewPrivmsg() {
        return userNewPrivmsg;
    }

    public void setUserNewPrivmsg(int userNewPrivmsg) {
        this.userNewPrivmsg = userNewPrivmsg;
    }

    private int userUnreadPrivmsg;

    @Basic
    @javax.persistence.Column(name = "user_unread_privmsg")
    public int getUserUnreadPrivmsg() {
        return userUnreadPrivmsg;
    }

    public void setUserUnreadPrivmsg(int userUnreadPrivmsg) {
        this.userUnreadPrivmsg = userUnreadPrivmsg;
    }

    private int userLastPrivmsg;

    @Basic
    @javax.persistence.Column(name = "user_last_privmsg")
    public int getUserLastPrivmsg() {
        return userLastPrivmsg;
    }

    public void setUserLastPrivmsg(int userLastPrivmsg) {
        this.userLastPrivmsg = userLastPrivmsg;
    }

    private byte userMessageRules;

    @Basic
    @javax.persistence.Column(name = "user_message_rules")
    public byte getUserMessageRules() {
        return userMessageRules;
    }

    public void setUserMessageRules(byte userMessageRules) {
        this.userMessageRules = userMessageRules;
    }

    private int userFullFolder;

    @Basic
    @javax.persistence.Column(name = "user_full_folder")
    public int getUserFullFolder() {
        return userFullFolder;
    }

    public void setUserFullFolder(int userFullFolder) {
        this.userFullFolder = userFullFolder;
    }

    private int userEmailtime;

    @Basic
    @javax.persistence.Column(name = "user_emailtime")
    public int getUserEmailtime() {
        return userEmailtime;
    }

    public void setUserEmailtime(int userEmailtime) {
        this.userEmailtime = userEmailtime;
    }

    private short userTopicShowDays;

    @Basic
    @javax.persistence.Column(name = "user_topic_show_days")
    public short getUserTopicShowDays() {
        return userTopicShowDays;
    }

    public void setUserTopicShowDays(short userTopicShowDays) {
        this.userTopicShowDays = userTopicShowDays;
    }

    private String userTopicSortbyType;

    @Basic
    @javax.persistence.Column(name = "user_topic_sortby_type")
    public String getUserTopicSortbyType() {
        return userTopicSortbyType;
    }

    public void setUserTopicSortbyType(String userTopicSortbyType) {
        this.userTopicSortbyType = userTopicSortbyType;
    }

    private String userTopicSortbyDir;

    @Basic
    @javax.persistence.Column(name = "user_topic_sortby_dir")
    public String getUserTopicSortbyDir() {
        return userTopicSortbyDir;
    }

    public void setUserTopicSortbyDir(String userTopicSortbyDir) {
        this.userTopicSortbyDir = userTopicSortbyDir;
    }

    private short userPostShowDays;

    @Basic
    @javax.persistence.Column(name = "user_post_show_days")
    public short getUserPostShowDays() {
        return userPostShowDays;
    }

    public void setUserPostShowDays(short userPostShowDays) {
        this.userPostShowDays = userPostShowDays;
    }

    private String userPostSortbyType;

    @Basic
    @javax.persistence.Column(name = "user_post_sortby_type")
    public String getUserPostSortbyType() {
        return userPostSortbyType;
    }

    public void setUserPostSortbyType(String userPostSortbyType) {
        this.userPostSortbyType = userPostSortbyType;
    }

    private String userPostSortbyDir;

    @Basic
    @javax.persistence.Column(name = "user_post_sortby_dir")
    public String getUserPostSortbyDir() {
        return userPostSortbyDir;
    }

    public void setUserPostSortbyDir(String userPostSortbyDir) {
        this.userPostSortbyDir = userPostSortbyDir;
    }

    private byte userNotify;

    @Basic
    @javax.persistence.Column(name = "user_notify")
    public byte getUserNotify() {
        return userNotify;
    }

    public void setUserNotify(byte userNotify) {
        this.userNotify = userNotify;
    }

    private byte userNotifyPm;

    @Basic
    @javax.persistence.Column(name = "user_notify_pm")
    public byte getUserNotifyPm() {
        return userNotifyPm;
    }

    public void setUserNotifyPm(byte userNotifyPm) {
        this.userNotifyPm = userNotifyPm;
    }

    private byte userNotifyType;

    @Basic
    @javax.persistence.Column(name = "user_notify_type")
    public byte getUserNotifyType() {
        return userNotifyType;
    }

    public void setUserNotifyType(byte userNotifyType) {
        this.userNotifyType = userNotifyType;
    }

    private byte userAllowPm;

    @Basic
    @javax.persistence.Column(name = "user_allow_pm")
    public byte getUserAllowPm() {
        return userAllowPm;
    }

    public void setUserAllowPm(byte userAllowPm) {
        this.userAllowPm = userAllowPm;
    }

    private byte userAllowViewonline;

    @Basic
    @javax.persistence.Column(name = "user_allow_viewonline")
    public byte getUserAllowViewonline() {
        return userAllowViewonline;
    }

    public void setUserAllowViewonline(byte userAllowViewonline) {
        this.userAllowViewonline = userAllowViewonline;
    }

    private byte userAllowViewemail;

    @Basic
    @javax.persistence.Column(name = "user_allow_viewemail")
    public byte getUserAllowViewemail() {
        return userAllowViewemail;
    }

    public void setUserAllowViewemail(byte userAllowViewemail) {
        this.userAllowViewemail = userAllowViewemail;
    }

    private byte userAllowMassemail;

    @Basic
    @javax.persistence.Column(name = "user_allow_massemail")
    public byte getUserAllowMassemail() {
        return userAllowMassemail;
    }

    public void setUserAllowMassemail(byte userAllowMassemail) {
        this.userAllowMassemail = userAllowMassemail;
    }

    private int userOptions;

    @Basic
    @javax.persistence.Column(name = "user_options")
    public int getUserOptions() {
        return userOptions;
    }

    public void setUserOptions(int userOptions) {
        this.userOptions = userOptions;
    }

    private String userAvatar;

    @Basic
    @javax.persistence.Column(name = "user_avatar")
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    private byte userAvatarType;

    @Basic
    @javax.persistence.Column(name = "user_avatar_type")
    public byte getUserAvatarType() {
        return userAvatarType;
    }

    public void setUserAvatarType(byte userAvatarType) {
        this.userAvatarType = userAvatarType;
    }

    private short userAvatarWidth;

    @Basic
    @javax.persistence.Column(name = "user_avatar_width")
    public short getUserAvatarWidth() {
        return userAvatarWidth;
    }

    public void setUserAvatarWidth(short userAvatarWidth) {
        this.userAvatarWidth = userAvatarWidth;
    }

    private short userAvatarHeight;

    @Basic
    @javax.persistence.Column(name = "user_avatar_height")
    public short getUserAvatarHeight() {
        return userAvatarHeight;
    }

    public void setUserAvatarHeight(short userAvatarHeight) {
        this.userAvatarHeight = userAvatarHeight;
    }

    private String userSig;

    @Basic
    @javax.persistence.Column(name = "user_sig")
    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }

    private String userSigBbcodeUid;

    @Basic
    @javax.persistence.Column(name = "user_sig_bbcode_uid")
    public String getUserSigBbcodeUid() {
        return userSigBbcodeUid;
    }

    public void setUserSigBbcodeUid(String userSigBbcodeUid) {
        this.userSigBbcodeUid = userSigBbcodeUid;
    }

    private String userSigBbcodeBitfield;

    @Basic
    @javax.persistence.Column(name = "user_sig_bbcode_bitfield")
    public String getUserSigBbcodeBitfield() {
        return userSigBbcodeBitfield;
    }

    public void setUserSigBbcodeBitfield(String userSigBbcodeBitfield) {
        this.userSigBbcodeBitfield = userSigBbcodeBitfield;
    }

    private String userFrom;

    @Basic
    @javax.persistence.Column(name = "user_from")
    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    private String userIcq;

    @Basic
    @javax.persistence.Column(name = "user_icq")
    public String getUserIcq() {
        return userIcq;
    }

    public void setUserIcq(String userIcq) {
        this.userIcq = userIcq;
    }

    private String userAim;

    @Basic
    @javax.persistence.Column(name = "user_aim")
    public String getUserAim() {
        return userAim;
    }

    public void setUserAim(String userAim) {
        this.userAim = userAim;
    }

    private String userYim;

    @Basic
    @javax.persistence.Column(name = "user_yim")
    public String getUserYim() {
        return userYim;
    }

    public void setUserYim(String userYim) {
        this.userYim = userYim;
    }

    private String userMsnm;

    @Basic
    @javax.persistence.Column(name = "user_msnm")
    public String getUserMsnm() {
        return userMsnm;
    }

    public void setUserMsnm(String userMsnm) {
        this.userMsnm = userMsnm;
    }

    private String userJabber;

    @Basic
    @javax.persistence.Column(name = "user_jabber")
    public String getUserJabber() {
        return userJabber;
    }

    public void setUserJabber(String userJabber) {
        this.userJabber = userJabber;
    }

    private String userWebsite;

    @Basic
    @javax.persistence.Column(name = "user_website")
    public String getUserWebsite() {
        return userWebsite;
    }

    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    private String userOcc;

    @Basic
    @javax.persistence.Column(name = "user_occ")
    public String getUserOcc() {
        return userOcc;
    }

    public void setUserOcc(String userOcc) {
        this.userOcc = userOcc;
    }

    private String userInterests;

    @Basic
    @javax.persistence.Column(name = "user_interests")
    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }

    private String userActkey;

    @Basic
    @javax.persistence.Column(name = "user_actkey")
    public String getUserActkey() {
        return userActkey;
    }

    public void setUserActkey(String userActkey) {
        this.userActkey = userActkey;
    }

    private String userNewpasswd;

    @Basic
    @javax.persistence.Column(name = "user_newpasswd")
    public String getUserNewpasswd() {
        return userNewpasswd;
    }

    public void setUserNewpasswd(String userNewpasswd) {
        this.userNewpasswd = userNewpasswd;
    }

    private String userFormSalt;

    @Basic
    @javax.persistence.Column(name = "user_form_salt")
    public String getUserFormSalt() {
        return userFormSalt;
    }

    public void setUserFormSalt(String userFormSalt) {
        this.userFormSalt = userFormSalt;
    }

    private byte userNew;

    @Basic
    @javax.persistence.Column(name = "user_new")
    public byte getUserNew() {
        return userNew;
    }

    public void setUserNew(byte userNew) {
        this.userNew = userNew;
    }

    private byte userReminded;

    @Basic
    @javax.persistence.Column(name = "user_reminded")
    public byte getUserReminded() {
        return userReminded;
    }

    public void setUserReminded(byte userReminded) {
        this.userReminded = userReminded;
    }

    private int userRemindedTime;

    @Basic
    @javax.persistence.Column(name = "user_reminded_time")
    public int getUserRemindedTime() {
        return userRemindedTime;
    }

    public void setUserRemindedTime(int userRemindedTime) {
        this.userRemindedTime = userRemindedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (groupId != that.groupId) return false;
        if (userAllowMassemail != that.userAllowMassemail) return false;
        if (userAllowPm != that.userAllowPm) return false;
        if (userAllowViewemail != that.userAllowViewemail) return false;
        if (userAllowViewonline != that.userAllowViewonline) return false;
        if (userAvatarHeight != that.userAvatarHeight) return false;
        if (userAvatarType != that.userAvatarType) return false;
        if (userAvatarWidth != that.userAvatarWidth) return false;
        if (userDst != that.userDst) return false;
        if (userEmailHash != that.userEmailHash) return false;
        if (userEmailtime != that.userEmailtime) return false;
        if (userFullFolder != that.userFullFolder) return false;
        if (userId != that.userId) return false;
        if (userInactiveReason != that.userInactiveReason) return false;
        if (userInactiveTime != that.userInactiveTime) return false;
        if (userLastPrivmsg != that.userLastPrivmsg) return false;
        if (userLastSearch != that.userLastSearch) return false;
        if (userLastWarning != that.userLastWarning) return false;
        if (userLastmark != that.userLastmark) return false;
        if (userLastpostTime != that.userLastpostTime) return false;
        if (userLastvisit != that.userLastvisit) return false;
        if (userLoginAttempts != that.userLoginAttempts) return false;
        if (userMessageRules != that.userMessageRules) return false;
        if (userNew != that.userNew) return false;
        if (userNewPrivmsg != that.userNewPrivmsg) return false;
        if (userNotify != that.userNotify) return false;
        if (userNotifyPm != that.userNotifyPm) return false;
        if (userNotifyType != that.userNotifyType) return false;
        if (userOptions != that.userOptions) return false;
        if (userPassConvert != that.userPassConvert) return false;
        if (userPasschg != that.userPasschg) return false;
        if (userPermFrom != that.userPermFrom) return false;
        if (userPostShowDays != that.userPostShowDays) return false;
        if (userPosts != that.userPosts) return false;
        if (userRank != that.userRank) return false;
        if (userRegdate != that.userRegdate) return false;
        if (userReminded != that.userReminded) return false;
        if (userRemindedTime != that.userRemindedTime) return false;
        if (userStyle != that.userStyle) return false;
        if (userTopicShowDays != that.userTopicShowDays) return false;
        if (userType != that.userType) return false;
        if (userUnreadPrivmsg != that.userUnreadPrivmsg) return false;
        if (userWarnings != that.userWarnings) return false;
        if (userActkey != null ? !userActkey.equals(that.userActkey) : that.userActkey != null) return false;
        if (userAim != null ? !userAim.equals(that.userAim) : that.userAim != null) return false;
        if (userAvatar != null ? !userAvatar.equals(that.userAvatar) : that.userAvatar != null) return false;
        if (userBirthday != null ? !userBirthday.equals(that.userBirthday) : that.userBirthday != null) return false;
        if (userColour != null ? !userColour.equals(that.userColour) : that.userColour != null) return false;
        if (userDateformat != null ? !userDateformat.equals(that.userDateformat) : that.userDateformat != null)
            return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userFormSalt != null ? !userFormSalt.equals(that.userFormSalt) : that.userFormSalt != null) return false;
        if (userFrom != null ? !userFrom.equals(that.userFrom) : that.userFrom != null) return false;
        if (userIcq != null ? !userIcq.equals(that.userIcq) : that.userIcq != null) return false;
        if (userInterests != null ? !userInterests.equals(that.userInterests) : that.userInterests != null)
            return false;
        if (userIp != null ? !userIp.equals(that.userIp) : that.userIp != null) return false;
        if (userJabber != null ? !userJabber.equals(that.userJabber) : that.userJabber != null) return false;
        if (userLang != null ? !userLang.equals(that.userLang) : that.userLang != null) return false;
        if (userLastConfirmKey != null ? !userLastConfirmKey.equals(that.userLastConfirmKey) : that.userLastConfirmKey != null)
            return false;
        if (userLastpage != null ? !userLastpage.equals(that.userLastpage) : that.userLastpage != null) return false;
        if (userMsnm != null ? !userMsnm.equals(that.userMsnm) : that.userMsnm != null) return false;
        if (userNewpasswd != null ? !userNewpasswd.equals(that.userNewpasswd) : that.userNewpasswd != null)
            return false;
        if (userOcc != null ? !userOcc.equals(that.userOcc) : that.userOcc != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userPermissions != null ? !userPermissions.equals(that.userPermissions) : that.userPermissions != null)
            return false;
        if (userPostSortbyDir != null ? !userPostSortbyDir.equals(that.userPostSortbyDir) : that.userPostSortbyDir != null)
            return false;
        if (userPostSortbyType != null ? !userPostSortbyType.equals(that.userPostSortbyType) : that.userPostSortbyType != null)
            return false;
        if (userSig != null ? !userSig.equals(that.userSig) : that.userSig != null) return false;
        if (userSigBbcodeBitfield != null ? !userSigBbcodeBitfield.equals(that.userSigBbcodeBitfield) : that.userSigBbcodeBitfield != null)
            return false;
        if (userSigBbcodeUid != null ? !userSigBbcodeUid.equals(that.userSigBbcodeUid) : that.userSigBbcodeUid != null)
            return false;
        if (userTimezone != null ? !userTimezone.equals(that.userTimezone) : that.userTimezone != null) return false;
        if (userTopicSortbyDir != null ? !userTopicSortbyDir.equals(that.userTopicSortbyDir) : that.userTopicSortbyDir != null)
            return false;
        if (userTopicSortbyType != null ? !userTopicSortbyType.equals(that.userTopicSortbyType) : that.userTopicSortbyType != null)
            return false;
        if (userWebsite != null ? !userWebsite.equals(that.userWebsite) : that.userWebsite != null) return false;
        if (userYim != null ? !userYim.equals(that.userYim) : that.userYim != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (usernameClean != null ? !usernameClean.equals(that.usernameClean) : that.usernameClean != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (int) userType;
        result = 31 * result + groupId;
        result = 31 * result + (userPermissions != null ? userPermissions.hashCode() : 0);
        result = 31 * result + userPermFrom;
        result = 31 * result + (userIp != null ? userIp.hashCode() : 0);
        result = 31 * result + userRegdate;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (usernameClean != null ? usernameClean.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + userPasschg;
        result = 31 * result + (int) userPassConvert;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (int) (userEmailHash ^ (userEmailHash >>> 32));
        result = 31 * result + (userBirthday != null ? userBirthday.hashCode() : 0);
        result = 31 * result + userLastvisit;
        result = 31 * result + userLastmark;
        result = 31 * result + userLastpostTime;
        result = 31 * result + (userLastpage != null ? userLastpage.hashCode() : 0);
        result = 31 * result + (userLastConfirmKey != null ? userLastConfirmKey.hashCode() : 0);
        result = 31 * result + userLastSearch;
        result = 31 * result + (int) userWarnings;
        result = 31 * result + userLastWarning;
        result = 31 * result + (int) userLoginAttempts;
        result = 31 * result + (int) userInactiveReason;
        result = 31 * result + userInactiveTime;
        result = 31 * result + userPosts;
        result = 31 * result + (userLang != null ? userLang.hashCode() : 0);
        result = 31 * result + (userTimezone != null ? userTimezone.hashCode() : 0);
        result = 31 * result + (int) userDst;
        result = 31 * result + (userDateformat != null ? userDateformat.hashCode() : 0);
        result = 31 * result + userStyle;
        result = 31 * result + userRank;
        result = 31 * result + (userColour != null ? userColour.hashCode() : 0);
        result = 31 * result + userNewPrivmsg;
        result = 31 * result + userUnreadPrivmsg;
        result = 31 * result + userLastPrivmsg;
        result = 31 * result + (int) userMessageRules;
        result = 31 * result + userFullFolder;
        result = 31 * result + userEmailtime;
        result = 31 * result + (int) userTopicShowDays;
        result = 31 * result + (userTopicSortbyType != null ? userTopicSortbyType.hashCode() : 0);
        result = 31 * result + (userTopicSortbyDir != null ? userTopicSortbyDir.hashCode() : 0);
        result = 31 * result + (int) userPostShowDays;
        result = 31 * result + (userPostSortbyType != null ? userPostSortbyType.hashCode() : 0);
        result = 31 * result + (userPostSortbyDir != null ? userPostSortbyDir.hashCode() : 0);
        result = 31 * result + (int) userNotify;
        result = 31 * result + (int) userNotifyPm;
        result = 31 * result + (int) userNotifyType;
        result = 31 * result + (int) userAllowPm;
        result = 31 * result + (int) userAllowViewonline;
        result = 31 * result + (int) userAllowViewemail;
        result = 31 * result + (int) userAllowMassemail;
        result = 31 * result + userOptions;
        result = 31 * result + (userAvatar != null ? userAvatar.hashCode() : 0);
        result = 31 * result + (int) userAvatarType;
        result = 31 * result + (int) userAvatarWidth;
        result = 31 * result + (int) userAvatarHeight;
        result = 31 * result + (userSig != null ? userSig.hashCode() : 0);
        result = 31 * result + (userSigBbcodeUid != null ? userSigBbcodeUid.hashCode() : 0);
        result = 31 * result + (userSigBbcodeBitfield != null ? userSigBbcodeBitfield.hashCode() : 0);
        result = 31 * result + (userFrom != null ? userFrom.hashCode() : 0);
        result = 31 * result + (userIcq != null ? userIcq.hashCode() : 0);
        result = 31 * result + (userAim != null ? userAim.hashCode() : 0);
        result = 31 * result + (userYim != null ? userYim.hashCode() : 0);
        result = 31 * result + (userMsnm != null ? userMsnm.hashCode() : 0);
        result = 31 * result + (userJabber != null ? userJabber.hashCode() : 0);
        result = 31 * result + (userWebsite != null ? userWebsite.hashCode() : 0);
        result = 31 * result + (userOcc != null ? userOcc.hashCode() : 0);
        result = 31 * result + (userInterests != null ? userInterests.hashCode() : 0);
        result = 31 * result + (userActkey != null ? userActkey.hashCode() : 0);
        result = 31 * result + (userNewpasswd != null ? userNewpasswd.hashCode() : 0);
        result = 31 * result + (userFormSalt != null ? userFormSalt.hashCode() : 0);
        result = 31 * result + (int) userNew;
        result = 31 * result + (int) userReminded;
        result = 31 * result + userRemindedTime;
        return result;
    }
}
