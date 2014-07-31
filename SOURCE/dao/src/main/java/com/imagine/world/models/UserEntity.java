package com.imagine.world.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by tuanle on 7/7/14.
 */
@Entity
@javax.persistence.Table(name = "user", schema = "", catalog = "imagine_world")
public class UserEntity {
    private int userid;

    @Id
    @javax.persistence.Column(name = "userid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private short usergroupid;

    @Basic
    @javax.persistence.Column(name = "usergroupid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getUsergroupid() {
        return usergroupid;
    }

    public void setUsergroupid(short usergroupid) {
        this.usergroupid = usergroupid;
    }

    private String membergroupids;

    @Basic
    @javax.persistence.Column(name = "membergroupids", nullable = false, insertable = true, updatable = true, length = 250, precision = 0)
    public String getMembergroupids() {
        return membergroupids;
    }

    public void setMembergroupids(String membergroupids) {
        this.membergroupids = membergroupids;
    }

    private short displaygroupid;

    @Basic
    @javax.persistence.Column(name = "displaygroupid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getDisplaygroupid() {
        return displaygroupid;
    }

    public void setDisplaygroupid(short displaygroupid) {
        this.displaygroupid = displaygroupid;
    }

    private String username;

    @Basic
    @javax.persistence.Column(name = "username", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    @Basic
    @javax.persistence.Column(name = "password", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Date passworddate;

    @Basic
    @javax.persistence.Column(name = "passworddate", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getPassworddate() {
        return passworddate;
    }

    public void setPassworddate(Date passworddate) {
        this.passworddate = passworddate;
    }

    private String email;

    @Basic
    @javax.persistence.Column(name = "email", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private short styleid;

    @Basic
    @javax.persistence.Column(name = "styleid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getStyleid() {
        return styleid;
    }

    public void setStyleid(short styleid) {
        this.styleid = styleid;
    }

    private String parentemail;

    @Basic
    @javax.persistence.Column(name = "parentemail", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getParentemail() {
        return parentemail;
    }

    public void setParentemail(String parentemail) {
        this.parentemail = parentemail;
    }

    private String homepage;

    @Basic
    @javax.persistence.Column(name = "homepage", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    private String icq;

    @Basic
    @javax.persistence.Column(name = "icq", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq;
    }

    private String aim;

    @Basic
    @javax.persistence.Column(name = "aim", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    private String yahoo;

    @Basic
    @javax.persistence.Column(name = "yahoo", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    private String msn;

    @Basic
    @javax.persistence.Column(name = "msn", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    private String skype;

    @Basic
    @javax.persistence.Column(name = "skype", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    private String google;

    @Basic
    @javax.persistence.Column(name = "google", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "status", nullable = true, insertable = true, updatable = true, length = 16777215, precision = 0)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private short showvbcode;

    @Basic
    @javax.persistence.Column(name = "showvbcode", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getShowvbcode() {
        return showvbcode;
    }

    public void setShowvbcode(short showvbcode) {
        this.showvbcode = showvbcode;
    }

    private short showbirthday;

    @Basic
    @javax.persistence.Column(name = "showbirthday", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getShowbirthday() {
        return showbirthday;
    }

    public void setShowbirthday(short showbirthday) {
        this.showbirthday = showbirthday;
    }

    private String usertitle;

    @Basic
    @javax.persistence.Column(name = "usertitle", nullable = false, insertable = true, updatable = true, length = 250, precision = 0)
    public String getUsertitle() {
        return usertitle;
    }

    public void setUsertitle(String usertitle) {
        this.usertitle = usertitle;
    }

    private short customtitle;

    @Basic
    @javax.persistence.Column(name = "customtitle", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getCustomtitle() {
        return customtitle;
    }

    public void setCustomtitle(short customtitle) {
        this.customtitle = customtitle;
    }

    private int joindate;

    @Basic
    @javax.persistence.Column(name = "joindate", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getJoindate() {
        return joindate;
    }

    public void setJoindate(int joindate) {
        this.joindate = joindate;
    }

    private short daysprune;

    @Basic
    @javax.persistence.Column(name = "daysprune", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getDaysprune() {
        return daysprune;
    }

    public void setDaysprune(short daysprune) {
        this.daysprune = daysprune;
    }

    private int lastvisit;

    @Basic
    @javax.persistence.Column(name = "lastvisit", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(int lastvisit) {
        this.lastvisit = lastvisit;
    }

    private int lastactivity;

    @Basic
    @javax.persistence.Column(name = "lastactivity", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getLastactivity() {
        return lastactivity;
    }

    public void setLastactivity(int lastactivity) {
        this.lastactivity = lastactivity;
    }

    private int lastpost;

    @Basic
    @javax.persistence.Column(name = "lastpost", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getLastpost() {
        return lastpost;
    }

    public void setLastpost(int lastpost) {
        this.lastpost = lastpost;
    }

    private int lastpostid;

    @Basic
    @javax.persistence.Column(name = "lastpostid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getLastpostid() {
        return lastpostid;
    }

    public void setLastpostid(int lastpostid) {
        this.lastpostid = lastpostid;
    }

    private int posts;

    @Basic
    @javax.persistence.Column(name = "posts", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    private int reputation;

    @Basic
    @javax.persistence.Column(name = "reputation", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    private int reputationlevelid;

    @Basic
    @javax.persistence.Column(name = "reputationlevelid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getReputationlevelid() {
        return reputationlevelid;
    }

    public void setReputationlevelid(int reputationlevelid) {
        this.reputationlevelid = reputationlevelid;
    }

    private String timezoneoffset;

    @Basic
    @javax.persistence.Column(name = "timezoneoffset", nullable = false, insertable = true, updatable = true, length = 4, precision = 0)
    public String getTimezoneoffset() {
        return timezoneoffset;
    }

    public void setTimezoneoffset(String timezoneoffset) {
        this.timezoneoffset = timezoneoffset;
    }

    private short pmpopup;

    @Basic
    @javax.persistence.Column(name = "pmpopup", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getPmpopup() {
        return pmpopup;
    }

    public void setPmpopup(short pmpopup) {
        this.pmpopup = pmpopup;
    }

    private short avatarid;

    @Basic
    @javax.persistence.Column(name = "avatarid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getAvatarid() {
        return avatarid;
    }

    public void setAvatarid(short avatarid) {
        this.avatarid = avatarid;
    }

    private int avatarrevision;

    @Basic
    @javax.persistence.Column(name = "avatarrevision", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getAvatarrevision() {
        return avatarrevision;
    }

    public void setAvatarrevision(int avatarrevision) {
        this.avatarrevision = avatarrevision;
    }

    private int profilepicrevision;

    @Basic
    @javax.persistence.Column(name = "profilepicrevision", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getProfilepicrevision() {
        return profilepicrevision;
    }

    public void setProfilepicrevision(int profilepicrevision) {
        this.profilepicrevision = profilepicrevision;
    }

    private int sigpicrevision;

    @Basic
    @javax.persistence.Column(name = "sigpicrevision", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getSigpicrevision() {
        return sigpicrevision;
    }

    public void setSigpicrevision(int sigpicrevision) {
        this.sigpicrevision = sigpicrevision;
    }

    private int options;

    @Basic
    @javax.persistence.Column(name = "options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

    private String privacyOptions;

    @Basic
    @javax.persistence.Column(name = "privacy_options", nullable = true, insertable = true, updatable = true, length = 16777215, precision = 0)
    public String getPrivacyOptions() {
        return privacyOptions;
    }

    public void setPrivacyOptions(String privacyOptions) {
        this.privacyOptions = privacyOptions;
    }

    private int notificationOptions;

    @Basic
    @javax.persistence.Column(name = "notification_options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getNotificationOptions() {
        return notificationOptions;
    }

    public void setNotificationOptions(int notificationOptions) {
        this.notificationOptions = notificationOptions;
    }

    private String birthday;

    @Basic
    @javax.persistence.Column(name = "birthday", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private Date birthdaySearch;

    @Basic
    @javax.persistence.Column(name = "birthday_search", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getBirthdaySearch() {
        return birthdaySearch;
    }

    public void setBirthdaySearch(Date birthdaySearch) {
        this.birthdaySearch = birthdaySearch;
    }

    private short maxposts;

    @Basic
    @javax.persistence.Column(name = "maxposts", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getMaxposts() {
        return maxposts;
    }

    public void setMaxposts(short maxposts) {
        this.maxposts = maxposts;
    }

    private short startofweek;

    @Basic
    @javax.persistence.Column(name = "startofweek", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getStartofweek() {
        return startofweek;
    }

    public void setStartofweek(short startofweek) {
        this.startofweek = startofweek;
    }

    private String ipaddress;

    @Basic
    @javax.persistence.Column(name = "ipaddress", nullable = false, insertable = true, updatable = true, length = 15, precision = 0)
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    private int referrerid;

    @Basic
    @javax.persistence.Column(name = "referrerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getReferrerid() {
        return referrerid;
    }

    public void setReferrerid(int referrerid) {
        this.referrerid = referrerid;
    }

    private short languageid;

    @Basic
    @javax.persistence.Column(name = "languageid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getLanguageid() {
        return languageid;
    }

    public void setLanguageid(short languageid) {
        this.languageid = languageid;
    }

    private int emailstamp;

    @Basic
    @javax.persistence.Column(name = "emailstamp", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getEmailstamp() {
        return emailstamp;
    }

    public void setEmailstamp(int emailstamp) {
        this.emailstamp = emailstamp;
    }

    private short threadedmode;

    @Basic
    @javax.persistence.Column(name = "threadedmode", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getThreadedmode() {
        return threadedmode;
    }

    public void setThreadedmode(short threadedmode) {
        this.threadedmode = threadedmode;
    }

    private short autosubscribe;

    @Basic
    @javax.persistence.Column(name = "autosubscribe", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getAutosubscribe() {
        return autosubscribe;
    }

    public void setAutosubscribe(short autosubscribe) {
        this.autosubscribe = autosubscribe;
    }

    private short pmtotal;

    @Basic
    @javax.persistence.Column(name = "pmtotal", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getPmtotal() {
        return pmtotal;
    }

    public void setPmtotal(short pmtotal) {
        this.pmtotal = pmtotal;
    }

    private short pmunread;

    @Basic
    @javax.persistence.Column(name = "pmunread", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getPmunread() {
        return pmunread;
    }

    public void setPmunread(short pmunread) {
        this.pmunread = pmunread;
    }

    private String salt;

    @Basic
    @javax.persistence.Column(name = "salt", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private int ipoints;

    @Basic
    @javax.persistence.Column(name = "ipoints", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getIpoints() {
        return ipoints;
    }

    public void setIpoints(int ipoints) {
        this.ipoints = ipoints;
    }

    private int infractions;

    @Basic
    @javax.persistence.Column(name = "infractions", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getInfractions() {
        return infractions;
    }

    public void setInfractions(int infractions) {
        this.infractions = infractions;
    }

    private int warnings;

    @Basic
    @javax.persistence.Column(name = "warnings", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    private String infractiongroupids;

    @Basic
    @javax.persistence.Column(name = "infractiongroupids", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getInfractiongroupids() {
        return infractiongroupids;
    }

    public void setInfractiongroupids(String infractiongroupids) {
        this.infractiongroupids = infractiongroupids;
    }

    private short infractiongroupid;

    @Basic
    @javax.persistence.Column(name = "infractiongroupid", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getInfractiongroupid() {
        return infractiongroupid;
    }

    public void setInfractiongroupid(short infractiongroupid) {
        this.infractiongroupid = infractiongroupid;
    }

    private int adminoptions;

    @Basic
    @javax.persistence.Column(name = "adminoptions", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getAdminoptions() {
        return adminoptions;
    }

    public void setAdminoptions(int adminoptions) {
        this.adminoptions = adminoptions;
    }

    private int profilevisits;

    @Basic
    @javax.persistence.Column(name = "profilevisits", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getProfilevisits() {
        return profilevisits;
    }

    public void setProfilevisits(int profilevisits) {
        this.profilevisits = profilevisits;
    }

    private int friendcount;

    @Basic
    @javax.persistence.Column(name = "friendcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getFriendcount() {
        return friendcount;
    }

    public void setFriendcount(int friendcount) {
        this.friendcount = friendcount;
    }

    private int friendreqcount;

    @Basic
    @javax.persistence.Column(name = "friendreqcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getFriendreqcount() {
        return friendreqcount;
    }

    public void setFriendreqcount(int friendreqcount) {
        this.friendreqcount = friendreqcount;
    }

    private int vmunreadcount;

    @Basic
    @javax.persistence.Column(name = "vmunreadcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getVmunreadcount() {
        return vmunreadcount;
    }

    public void setVmunreadcount(int vmunreadcount) {
        this.vmunreadcount = vmunreadcount;
    }

    private int vmmoderatedcount;

    @Basic
    @javax.persistence.Column(name = "vmmoderatedcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getVmmoderatedcount() {
        return vmmoderatedcount;
    }

    public void setVmmoderatedcount(int vmmoderatedcount) {
        this.vmmoderatedcount = vmmoderatedcount;
    }

    private int socgroupinvitecount;

    @Basic
    @javax.persistence.Column(name = "socgroupinvitecount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getSocgroupinvitecount() {
        return socgroupinvitecount;
    }

    public void setSocgroupinvitecount(int socgroupinvitecount) {
        this.socgroupinvitecount = socgroupinvitecount;
    }

    private int socgroupreqcount;

    @Basic
    @javax.persistence.Column(name = "socgroupreqcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getSocgroupreqcount() {
        return socgroupreqcount;
    }

    public void setSocgroupreqcount(int socgroupreqcount) {
        this.socgroupreqcount = socgroupreqcount;
    }

    private int pcunreadcount;

    @Basic
    @javax.persistence.Column(name = "pcunreadcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPcunreadcount() {
        return pcunreadcount;
    }

    public void setPcunreadcount(int pcunreadcount) {
        this.pcunreadcount = pcunreadcount;
    }

    private int pcmoderatedcount;

    @Basic
    @javax.persistence.Column(name = "pcmoderatedcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPcmoderatedcount() {
        return pcmoderatedcount;
    }

    public void setPcmoderatedcount(int pcmoderatedcount) {
        this.pcmoderatedcount = pcmoderatedcount;
    }

    private int gmmoderatedcount;

    @Basic
    @javax.persistence.Column(name = "gmmoderatedcount", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getGmmoderatedcount() {
        return gmmoderatedcount;
    }

    public void setGmmoderatedcount(int gmmoderatedcount) {
        this.gmmoderatedcount = gmmoderatedcount;
    }

    private String assetposthash;

    @Basic
    @javax.persistence.Column(name = "assetposthash", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    public String getAssetposthash() {
        return assetposthash;
    }

    public void setAssetposthash(String assetposthash) {
        this.assetposthash = assetposthash;
    }

    private String fbuserid;

    @Basic
    @javax.persistence.Column(name = "fbuserid", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getFbuserid() {
        return fbuserid;
    }

    public void setFbuserid(String fbuserid) {
        this.fbuserid = fbuserid;
    }

    private int fbjoindate;

    @Basic
    @javax.persistence.Column(name = "fbjoindate", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getFbjoindate() {
        return fbjoindate;
    }

    public void setFbjoindate(int fbjoindate) {
        this.fbjoindate = fbjoindate;
    }

    private String fbname;

    @Basic
    @javax.persistence.Column(name = "fbname", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getFbname() {
        return fbname;
    }

    public void setFbname(String fbname) {
        this.fbname = fbname;
    }

    private String logintype;

    @Basic
    @javax.persistence.Column(name = "logintype", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    private String fbaccesstoken;

    @Basic
    @javax.persistence.Column(name = "fbaccesstoken", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getFbaccesstoken() {
        return fbaccesstoken;
    }

    public void setFbaccesstoken(String fbaccesstoken) {
        this.fbaccesstoken = fbaccesstoken;
    }

    private short newrepcount;

    @Basic
    @javax.persistence.Column(name = "newrepcount", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getNewrepcount() {
        return newrepcount;
    }

    public void setNewrepcount(short newrepcount) {
        this.newrepcount = newrepcount;
    }

    private Boolean panjoSelling;

    @Basic
    @javax.persistence.Column(name = "panjo_selling", nullable = true, insertable = true, updatable = true, length = 0, precision = 0)
    public Boolean getPanjoSelling() {
        return panjoSelling;
    }

    public void setPanjoSelling(Boolean panjoSelling) {
        this.panjoSelling = panjoSelling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (adminoptions != that.adminoptions) return false;
        if (autosubscribe != that.autosubscribe) return false;
        if (avatarid != that.avatarid) return false;
        if (avatarrevision != that.avatarrevision) return false;
        if (customtitle != that.customtitle) return false;
        if (daysprune != that.daysprune) return false;
        if (displaygroupid != that.displaygroupid) return false;
        if (emailstamp != that.emailstamp) return false;
        if (fbjoindate != that.fbjoindate) return false;
        if (friendcount != that.friendcount) return false;
        if (friendreqcount != that.friendreqcount) return false;
        if (gmmoderatedcount != that.gmmoderatedcount) return false;
        if (infractiongroupid != that.infractiongroupid) return false;
        if (infractions != that.infractions) return false;
        if (ipoints != that.ipoints) return false;
        if (joindate != that.joindate) return false;
        if (languageid != that.languageid) return false;
        if (lastactivity != that.lastactivity) return false;
        if (lastpost != that.lastpost) return false;
        if (lastpostid != that.lastpostid) return false;
        if (lastvisit != that.lastvisit) return false;
        if (maxposts != that.maxposts) return false;
        if (newrepcount != that.newrepcount) return false;
        if (notificationOptions != that.notificationOptions) return false;
        if (options != that.options) return false;
        if (pcmoderatedcount != that.pcmoderatedcount) return false;
        if (pcunreadcount != that.pcunreadcount) return false;
        if (pmpopup != that.pmpopup) return false;
        if (pmtotal != that.pmtotal) return false;
        if (pmunread != that.pmunread) return false;
        if (posts != that.posts) return false;
        if (profilepicrevision != that.profilepicrevision) return false;
        if (profilevisits != that.profilevisits) return false;
        if (referrerid != that.referrerid) return false;
        if (reputation != that.reputation) return false;
        if (reputationlevelid != that.reputationlevelid) return false;
        if (showbirthday != that.showbirthday) return false;
        if (showvbcode != that.showvbcode) return false;
        if (sigpicrevision != that.sigpicrevision) return false;
        if (socgroupinvitecount != that.socgroupinvitecount) return false;
        if (socgroupreqcount != that.socgroupreqcount) return false;
        if (startofweek != that.startofweek) return false;
        if (styleid != that.styleid) return false;
        if (threadedmode != that.threadedmode) return false;
        if (usergroupid != that.usergroupid) return false;
        if (userid != that.userid) return false;
        if (vmmoderatedcount != that.vmmoderatedcount) return false;
        if (vmunreadcount != that.vmunreadcount) return false;
        if (warnings != that.warnings) return false;
        if (aim != null ? !aim.equals(that.aim) : that.aim != null) return false;
        if (assetposthash != null ? !assetposthash.equals(that.assetposthash) : that.assetposthash != null)
            return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (birthdaySearch != null ? !birthdaySearch.equals(that.birthdaySearch) : that.birthdaySearch != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fbaccesstoken != null ? !fbaccesstoken.equals(that.fbaccesstoken) : that.fbaccesstoken != null)
            return false;
        if (fbname != null ? !fbname.equals(that.fbname) : that.fbname != null) return false;
        if (fbuserid != null ? !fbuserid.equals(that.fbuserid) : that.fbuserid != null) return false;
        if (google != null ? !google.equals(that.google) : that.google != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
        if (icq != null ? !icq.equals(that.icq) : that.icq != null) return false;
        if (infractiongroupids != null ? !infractiongroupids.equals(that.infractiongroupids) : that.infractiongroupids != null)
            return false;
        if (ipaddress != null ? !ipaddress.equals(that.ipaddress) : that.ipaddress != null) return false;
        if (logintype != null ? !logintype.equals(that.logintype) : that.logintype != null) return false;
        if (membergroupids != null ? !membergroupids.equals(that.membergroupids) : that.membergroupids != null)
            return false;
        if (msn != null ? !msn.equals(that.msn) : that.msn != null) return false;
        if (panjoSelling != null ? !panjoSelling.equals(that.panjoSelling) : that.panjoSelling != null) return false;
        if (parentemail != null ? !parentemail.equals(that.parentemail) : that.parentemail != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (passworddate != null ? !passworddate.equals(that.passworddate) : that.passworddate != null) return false;
        if (privacyOptions != null ? !privacyOptions.equals(that.privacyOptions) : that.privacyOptions != null)
            return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (skype != null ? !skype.equals(that.skype) : that.skype != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (timezoneoffset != null ? !timezoneoffset.equals(that.timezoneoffset) : that.timezoneoffset != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (usertitle != null ? !usertitle.equals(that.usertitle) : that.usertitle != null) return false;
        if (yahoo != null ? !yahoo.equals(that.yahoo) : that.yahoo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (int) usergroupid;
        result = 31 * result + (membergroupids != null ? membergroupids.hashCode() : 0);
        result = 31 * result + (int) displaygroupid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passworddate != null ? passworddate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) styleid;
        result = 31 * result + (parentemail != null ? parentemail.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (icq != null ? icq.hashCode() : 0);
        result = 31 * result + (aim != null ? aim.hashCode() : 0);
        result = 31 * result + (yahoo != null ? yahoo.hashCode() : 0);
        result = 31 * result + (msn != null ? msn.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (google != null ? google.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) showvbcode;
        result = 31 * result + (int) showbirthday;
        result = 31 * result + (usertitle != null ? usertitle.hashCode() : 0);
        result = 31 * result + (int) customtitle;
        result = 31 * result + joindate;
        result = 31 * result + (int) daysprune;
        result = 31 * result + lastvisit;
        result = 31 * result + lastactivity;
        result = 31 * result + lastpost;
        result = 31 * result + lastpostid;
        result = 31 * result + posts;
        result = 31 * result + reputation;
        result = 31 * result + reputationlevelid;
        result = 31 * result + (timezoneoffset != null ? timezoneoffset.hashCode() : 0);
        result = 31 * result + (int) pmpopup;
        result = 31 * result + (int) avatarid;
        result = 31 * result + avatarrevision;
        result = 31 * result + profilepicrevision;
        result = 31 * result + sigpicrevision;
        result = 31 * result + options;
        result = 31 * result + (privacyOptions != null ? privacyOptions.hashCode() : 0);
        result = 31 * result + notificationOptions;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (birthdaySearch != null ? birthdaySearch.hashCode() : 0);
        result = 31 * result + (int) maxposts;
        result = 31 * result + (int) startofweek;
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + referrerid;
        result = 31 * result + (int) languageid;
        result = 31 * result + emailstamp;
        result = 31 * result + (int) threadedmode;
        result = 31 * result + (int) autosubscribe;
        result = 31 * result + (int) pmtotal;
        result = 31 * result + (int) pmunread;
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + ipoints;
        result = 31 * result + infractions;
        result = 31 * result + warnings;
        result = 31 * result + (infractiongroupids != null ? infractiongroupids.hashCode() : 0);
        result = 31 * result + (int) infractiongroupid;
        result = 31 * result + adminoptions;
        result = 31 * result + profilevisits;
        result = 31 * result + friendcount;
        result = 31 * result + friendreqcount;
        result = 31 * result + vmunreadcount;
        result = 31 * result + vmmoderatedcount;
        result = 31 * result + socgroupinvitecount;
        result = 31 * result + socgroupreqcount;
        result = 31 * result + pcunreadcount;
        result = 31 * result + pcmoderatedcount;
        result = 31 * result + gmmoderatedcount;
        result = 31 * result + (assetposthash != null ? assetposthash.hashCode() : 0);
        result = 31 * result + (fbuserid != null ? fbuserid.hashCode() : 0);
        result = 31 * result + fbjoindate;
        result = 31 * result + (fbname != null ? fbname.hashCode() : 0);
        result = 31 * result + (logintype != null ? logintype.hashCode() : 0);
        result = 31 * result + (fbaccesstoken != null ? fbaccesstoken.hashCode() : 0);
        result = 31 * result + (int) newrepcount;
        result = 31 * result + (panjoSelling != null ? panjoSelling.hashCode() : 0);
        return result;
    }
}
