package com.imagine.world.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@Table(name = "USERS", schema = "", catalog = "blogs")
public class UsersEntity {
    private int userId;
    private byte userType;
    private int groupId;
    private String userPermissions;
    private int userPermFrom;
    private String userIp;
    private int userRegdate;
    private String username;
    private String usernameClean;
    private String userPassword;
    private int userPasschg;
    private byte userPassConvert;
    private String userEmail;
    private long userEmailHash;
    private String userBirthday;
    private int userLastvisit;
    private int userLastmark;
    private int userLastpostTime;
    private String userLastpage;
    private String userLastConfirmKey;
    private int userLastSearch;
    private byte userWarnings;
    private int userLastWarning;
    private byte userLoginAttempts;
    private byte userInactiveReason;
    private int userInactiveTime;
    private int userPosts;
    private String userLang;
    private BigDecimal userTimezone;
    private byte userDst;
    private String userDateformat;
    private int userStyle;
    private int userRank;
    private String userColour;
    private int userNewPrivmsg;
    private int userUnreadPrivmsg;
    private int userLastPrivmsg;
    private byte userMessageRules;
    private int userFullFolder;
    private int userEmailtime;
    private short userTopicShowDays;
    private String userTopicSortbyType;
    private String userTopicSortbyDir;
    private short userPostShowDays;
    private String userPostSortbyType;
    private String userPostSortbyDir;
    private byte userNotify;
    private byte userNotifyPm;
    private byte userNotifyType;
    private byte userAllowPm;
    private byte userAllowViewonline;
    private byte userAllowViewemail;
    private byte userAllowMassemail;
    private int userOptions;
    private String userAvatar;
    private byte userAvatarType;
    private short userAvatarWidth;
    private short userAvatarHeight;
    private String userSig;
    private String userSigBbcodeUid;
    private String userSigBbcodeBitfield;
    private String userFrom;
    private String userIcq;
    private String userAim;
    private String userYim;
    private String userMsnm;
    private String userJabber;
    private String userWebsite;
    private String userOcc;
    private String userInterests;
    private String userActkey;
    private String userNewpasswd;
    private String userFormSalt;
    private byte userNew;
    private byte userReminded;
    private int userRemindedTime;

    @Id
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "group_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "user_permissions", nullable = false, insertable = true, updatable = true, length = 16777215, precision = 0)
    public String getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(String userPermissions) {
        this.userPermissions = userPermissions;
    }

    @Basic
    @Column(name = "user_perm_from", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getUserPermFrom() {
        return userPermFrom;
    }

    public void setUserPermFrom(int userPermFrom) {
        this.userPermFrom = userPermFrom;
    }

    @Basic
    @Column(name = "user_ip", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Basic
    @Column(name = "user_regdate", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserRegdate() {
        return userRegdate;
    }

    public void setUserRegdate(int userRegdate) {
        this.userRegdate = userRegdate;
    }

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "username_clean", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUsernameClean() {
        return usernameClean;
    }

    public void setUsernameClean(String usernameClean) {
        this.usernameClean = usernameClean;
    }

    @Basic
    @Column(name = "user_password", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_passchg", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserPasschg() {
        return userPasschg;
    }

    public void setUserPasschg(int userPasschg) {
        this.userPasschg = userPasschg;
    }

    @Basic
    @Column(name = "user_pass_convert", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserPassConvert() {
        return userPassConvert;
    }

    public void setUserPassConvert(byte userPassConvert) {
        this.userPassConvert = userPassConvert;
    }

    @Basic
    @Column(name = "user_email", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_email_hash", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    public long getUserEmailHash() {
        return userEmailHash;
    }

    public void setUserEmailHash(long userEmailHash) {
        this.userEmailHash = userEmailHash;
    }

    @Basic
    @Column(name = "user_birthday", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "user_lastvisit", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastvisit() {
        return userLastvisit;
    }

    public void setUserLastvisit(int userLastvisit) {
        this.userLastvisit = userLastvisit;
    }

    @Basic
    @Column(name = "user_lastmark", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastmark() {
        return userLastmark;
    }

    public void setUserLastmark(int userLastmark) {
        this.userLastmark = userLastmark;
    }

    @Basic
    @Column(name = "user_lastpost_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastpostTime() {
        return userLastpostTime;
    }

    public void setUserLastpostTime(int userLastpostTime) {
        this.userLastpostTime = userLastpostTime;
    }

    @Basic
    @Column(name = "user_lastpage", nullable = false, insertable = true, updatable = true, length = 200, precision = 0)
    public String getUserLastpage() {
        return userLastpage;
    }

    public void setUserLastpage(String userLastpage) {
        this.userLastpage = userLastpage;
    }

    @Basic
    @Column(name = "user_last_confirm_key", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getUserLastConfirmKey() {
        return userLastConfirmKey;
    }

    public void setUserLastConfirmKey(String userLastConfirmKey) {
        this.userLastConfirmKey = userLastConfirmKey;
    }

    @Basic
    @Column(name = "user_last_search", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastSearch() {
        return userLastSearch;
    }

    public void setUserLastSearch(int userLastSearch) {
        this.userLastSearch = userLastSearch;
    }

    @Basic
    @Column(name = "user_warnings", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserWarnings() {
        return userWarnings;
    }

    public void setUserWarnings(byte userWarnings) {
        this.userWarnings = userWarnings;
    }

    @Basic
    @Column(name = "user_last_warning", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastWarning() {
        return userLastWarning;
    }

    public void setUserLastWarning(int userLastWarning) {
        this.userLastWarning = userLastWarning;
    }

    @Basic
    @Column(name = "user_login_attempts", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserLoginAttempts() {
        return userLoginAttempts;
    }

    public void setUserLoginAttempts(byte userLoginAttempts) {
        this.userLoginAttempts = userLoginAttempts;
    }

    @Basic
    @Column(name = "user_inactive_reason", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserInactiveReason() {
        return userInactiveReason;
    }

    public void setUserInactiveReason(byte userInactiveReason) {
        this.userInactiveReason = userInactiveReason;
    }

    @Basic
    @Column(name = "user_inactive_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserInactiveTime() {
        return userInactiveTime;
    }

    public void setUserInactiveTime(int userInactiveTime) {
        this.userInactiveTime = userInactiveTime;
    }

    @Basic
    @Column(name = "user_posts", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(int userPosts) {
        this.userPosts = userPosts;
    }

    @Basic
    @Column(name = "user_lang", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    @Basic
    @Column(name = "user_timezone", nullable = false, insertable = true, updatable = true, length = 5, precision = 2)
    public BigDecimal getUserTimezone() {
        return userTimezone;
    }

    public void setUserTimezone(BigDecimal userTimezone) {
        this.userTimezone = userTimezone;
    }

    @Basic
    @Column(name = "user_dst", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserDst() {
        return userDst;
    }

    public void setUserDst(byte userDst) {
        this.userDst = userDst;
    }

    @Basic
    @Column(name = "user_dateformat", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getUserDateformat() {
        return userDateformat;
    }

    public void setUserDateformat(String userDateformat) {
        this.userDateformat = userDateformat;
    }

    @Basic
    @Column(name = "user_style", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getUserStyle() {
        return userStyle;
    }

    public void setUserStyle(int userStyle) {
        this.userStyle = userStyle;
    }

    @Basic
    @Column(name = "user_rank", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    @Basic
    @Column(name = "user_colour", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public String getUserColour() {
        return userColour;
    }

    public void setUserColour(String userColour) {
        this.userColour = userColour;
    }

    @Basic
    @Column(name = "user_new_privmsg", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserNewPrivmsg() {
        return userNewPrivmsg;
    }

    public void setUserNewPrivmsg(int userNewPrivmsg) {
        this.userNewPrivmsg = userNewPrivmsg;
    }

    @Basic
    @Column(name = "user_unread_privmsg", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserUnreadPrivmsg() {
        return userUnreadPrivmsg;
    }

    public void setUserUnreadPrivmsg(int userUnreadPrivmsg) {
        this.userUnreadPrivmsg = userUnreadPrivmsg;
    }

    @Basic
    @Column(name = "user_last_privmsg", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserLastPrivmsg() {
        return userLastPrivmsg;
    }

    public void setUserLastPrivmsg(int userLastPrivmsg) {
        this.userLastPrivmsg = userLastPrivmsg;
    }

    @Basic
    @Column(name = "user_message_rules", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserMessageRules() {
        return userMessageRules;
    }

    public void setUserMessageRules(byte userMessageRules) {
        this.userMessageRules = userMessageRules;
    }

    @Basic
    @Column(name = "user_full_folder", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserFullFolder() {
        return userFullFolder;
    }

    public void setUserFullFolder(int userFullFolder) {
        this.userFullFolder = userFullFolder;
    }

    @Basic
    @Column(name = "user_emailtime", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserEmailtime() {
        return userEmailtime;
    }

    public void setUserEmailtime(int userEmailtime) {
        this.userEmailtime = userEmailtime;
    }

    @Basic
    @Column(name = "user_topic_show_days", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getUserTopicShowDays() {
        return userTopicShowDays;
    }

    public void setUserTopicShowDays(short userTopicShowDays) {
        this.userTopicShowDays = userTopicShowDays;
    }

    @Basic
    @Column(name = "user_topic_sortby_type", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getUserTopicSortbyType() {
        return userTopicSortbyType;
    }

    public void setUserTopicSortbyType(String userTopicSortbyType) {
        this.userTopicSortbyType = userTopicSortbyType;
    }

    @Basic
    @Column(name = "user_topic_sortby_dir", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getUserTopicSortbyDir() {
        return userTopicSortbyDir;
    }

    public void setUserTopicSortbyDir(String userTopicSortbyDir) {
        this.userTopicSortbyDir = userTopicSortbyDir;
    }

    @Basic
    @Column(name = "user_post_show_days", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getUserPostShowDays() {
        return userPostShowDays;
    }

    public void setUserPostShowDays(short userPostShowDays) {
        this.userPostShowDays = userPostShowDays;
    }

    @Basic
    @Column(name = "user_post_sortby_type", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getUserPostSortbyType() {
        return userPostSortbyType;
    }

    public void setUserPostSortbyType(String userPostSortbyType) {
        this.userPostSortbyType = userPostSortbyType;
    }

    @Basic
    @Column(name = "user_post_sortby_dir", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    public String getUserPostSortbyDir() {
        return userPostSortbyDir;
    }

    public void setUserPostSortbyDir(String userPostSortbyDir) {
        this.userPostSortbyDir = userPostSortbyDir;
    }

    @Basic
    @Column(name = "user_notify", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserNotify() {
        return userNotify;
    }

    public void setUserNotify(byte userNotify) {
        this.userNotify = userNotify;
    }

    @Basic
    @Column(name = "user_notify_pm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserNotifyPm() {
        return userNotifyPm;
    }

    public void setUserNotifyPm(byte userNotifyPm) {
        this.userNotifyPm = userNotifyPm;
    }

    @Basic
    @Column(name = "user_notify_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserNotifyType() {
        return userNotifyType;
    }

    public void setUserNotifyType(byte userNotifyType) {
        this.userNotifyType = userNotifyType;
    }

    @Basic
    @Column(name = "user_allow_pm", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserAllowPm() {
        return userAllowPm;
    }

    public void setUserAllowPm(byte userAllowPm) {
        this.userAllowPm = userAllowPm;
    }

    @Basic
    @Column(name = "user_allow_viewonline", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserAllowViewonline() {
        return userAllowViewonline;
    }

    public void setUserAllowViewonline(byte userAllowViewonline) {
        this.userAllowViewonline = userAllowViewonline;
    }

    @Basic
    @Column(name = "user_allow_viewemail", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserAllowViewemail() {
        return userAllowViewemail;
    }

    public void setUserAllowViewemail(byte userAllowViewemail) {
        this.userAllowViewemail = userAllowViewemail;
    }

    @Basic
    @Column(name = "user_allow_massemail", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserAllowMassemail() {
        return userAllowMassemail;
    }

    public void setUserAllowMassemail(byte userAllowMassemail) {
        this.userAllowMassemail = userAllowMassemail;
    }

    @Basic
    @Column(name = "user_options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserOptions() {
        return userOptions;
    }

    public void setUserOptions(int userOptions) {
        this.userOptions = userOptions;
    }

    @Basic
    @Column(name = "user_avatar", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Basic
    @Column(name = "user_avatar_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserAvatarType() {
        return userAvatarType;
    }

    public void setUserAvatarType(byte userAvatarType) {
        this.userAvatarType = userAvatarType;
    }

    @Basic
    @Column(name = "user_avatar_width", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getUserAvatarWidth() {
        return userAvatarWidth;
    }

    public void setUserAvatarWidth(short userAvatarWidth) {
        this.userAvatarWidth = userAvatarWidth;
    }

    @Basic
    @Column(name = "user_avatar_height", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getUserAvatarHeight() {
        return userAvatarHeight;
    }

    public void setUserAvatarHeight(short userAvatarHeight) {
        this.userAvatarHeight = userAvatarHeight;
    }

    @Basic
    @Column(name = "user_sig", nullable = false, insertable = true, updatable = true, length = 16777215, precision = 0)
    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }

    @Basic
    @Column(name = "user_sig_bbcode_uid", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public String getUserSigBbcodeUid() {
        return userSigBbcodeUid;
    }

    public void setUserSigBbcodeUid(String userSigBbcodeUid) {
        this.userSigBbcodeUid = userSigBbcodeUid;
    }

    @Basic
    @Column(name = "user_sig_bbcode_bitfield", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserSigBbcodeBitfield() {
        return userSigBbcodeBitfield;
    }

    public void setUserSigBbcodeBitfield(String userSigBbcodeBitfield) {
        this.userSigBbcodeBitfield = userSigBbcodeBitfield;
    }

    @Basic
    @Column(name = "user_from", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    @Basic
    @Column(name = "user_icq", nullable = false, insertable = true, updatable = true, length = 15, precision = 0)
    public String getUserIcq() {
        return userIcq;
    }

    public void setUserIcq(String userIcq) {
        this.userIcq = userIcq;
    }

    @Basic
    @Column(name = "user_aim", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserAim() {
        return userAim;
    }

    public void setUserAim(String userAim) {
        this.userAim = userAim;
    }

    @Basic
    @Column(name = "user_yim", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserYim() {
        return userYim;
    }

    public void setUserYim(String userYim) {
        this.userYim = userYim;
    }

    @Basic
    @Column(name = "user_msnm", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserMsnm() {
        return userMsnm;
    }

    public void setUserMsnm(String userMsnm) {
        this.userMsnm = userMsnm;
    }

    @Basic
    @Column(name = "user_jabber", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getUserJabber() {
        return userJabber;
    }

    public void setUserJabber(String userJabber) {
        this.userJabber = userJabber;
    }

    @Basic
    @Column(name = "user_website", nullable = false, insertable = true, updatable = true, length = 200, precision = 0)
    public String getUserWebsite() {
        return userWebsite;
    }

    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    @Basic
    @Column(name = "user_occ", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    public String getUserOcc() {
        return userOcc;
    }

    public void setUserOcc(String userOcc) {
        this.userOcc = userOcc;
    }

    @Basic
    @Column(name = "user_interests", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }

    @Basic
    @Column(name = "user_actkey", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getUserActkey() {
        return userActkey;
    }

    public void setUserActkey(String userActkey) {
        this.userActkey = userActkey;
    }

    @Basic
    @Column(name = "user_newpasswd", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    public String getUserNewpasswd() {
        return userNewpasswd;
    }

    public void setUserNewpasswd(String userNewpasswd) {
        this.userNewpasswd = userNewpasswd;
    }

    @Basic
    @Column(name = "user_form_salt", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getUserFormSalt() {
        return userFormSalt;
    }

    public void setUserFormSalt(String userFormSalt) {
        this.userFormSalt = userFormSalt;
    }

    @Basic
    @Column(name = "user_new", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserNew() {
        return userNew;
    }

    public void setUserNew(byte userNew) {
        this.userNew = userNew;
    }

    @Basic
    @Column(name = "user_reminded", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getUserReminded() {
        return userReminded;
    }

    public void setUserReminded(byte userReminded) {
        this.userReminded = userReminded;
    }

    @Basic
    @Column(name = "user_reminded_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
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
