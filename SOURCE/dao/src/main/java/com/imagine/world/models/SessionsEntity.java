package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@Table(name = "SESSIONS", schema = "", catalog = "blogs")
public class SessionsEntity {
    private String sessionId;
    private int sessionUserId;
    private int sessionForumId;
    private int sessionLastVisit;
    private int sessionStart;
    private int sessionTime;
    private String sessionIp;
    private String sessionBrowser;
    private String sessionForwardedFor;
    private String sessionPage;
    private byte sessionViewonline;
    private byte sessionAutologin;
    private byte sessionAdmin;

    @Id
    @Column(name = "session_id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "session_user_id")
    public int getSessionUserId() {
        return sessionUserId;
    }

    public void setSessionUserId(int sessionUserId) {
        this.sessionUserId = sessionUserId;
    }

    @Basic
    @Column(name = "session_forum_id")
    public int getSessionForumId() {
        return sessionForumId;
    }

    public void setSessionForumId(int sessionForumId) {
        this.sessionForumId = sessionForumId;
    }

    @Basic
    @Column(name = "session_last_visit")
    public int getSessionLastVisit() {
        return sessionLastVisit;
    }

    public void setSessionLastVisit(int sessionLastVisit) {
        this.sessionLastVisit = sessionLastVisit;
    }

    @Basic
    @Column(name = "session_start")
    public int getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(int sessionStart) {
        this.sessionStart = sessionStart;
    }

    @Basic
    @Column(name = "session_time")
    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Basic
    @Column(name = "session_ip")
    public String getSessionIp() {
        return sessionIp;
    }

    public void setSessionIp(String sessionIp) {
        this.sessionIp = sessionIp;
    }

    @Basic
    @Column(name = "session_browser")
    public String getSessionBrowser() {
        return sessionBrowser;
    }

    public void setSessionBrowser(String sessionBrowser) {
        this.sessionBrowser = sessionBrowser;
    }

    @Basic
    @Column(name = "session_forwarded_for")
    public String getSessionForwardedFor() {
        return sessionForwardedFor;
    }

    public void setSessionForwardedFor(String sessionForwardedFor) {
        this.sessionForwardedFor = sessionForwardedFor;
    }

    @Basic
    @Column(name = "session_page")
    public String getSessionPage() {
        return sessionPage;
    }

    public void setSessionPage(String sessionPage) {
        this.sessionPage = sessionPage;
    }

    @Basic
    @Column(name = "session_viewonline")
    public byte getSessionViewonline() {
        return sessionViewonline;
    }

    public void setSessionViewonline(byte sessionViewonline) {
        this.sessionViewonline = sessionViewonline;
    }

    @Basic
    @Column(name = "session_autologin")
    public byte getSessionAutologin() {
        return sessionAutologin;
    }

    public void setSessionAutologin(byte sessionAutologin) {
        this.sessionAutologin = sessionAutologin;
    }

    @Basic
    @Column(name = "session_admin")
    public byte getSessionAdmin() {
        return sessionAdmin;
    }

    public void setSessionAdmin(byte sessionAdmin) {
        this.sessionAdmin = sessionAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionsEntity that = (SessionsEntity) o;

        if (sessionAdmin != that.sessionAdmin) return false;
        if (sessionAutologin != that.sessionAutologin) return false;
        if (sessionForumId != that.sessionForumId) return false;
        if (sessionLastVisit != that.sessionLastVisit) return false;
        if (sessionStart != that.sessionStart) return false;
        if (sessionTime != that.sessionTime) return false;
        if (sessionUserId != that.sessionUserId) return false;
        if (sessionViewonline != that.sessionViewonline) return false;
        if (sessionBrowser != null ? !sessionBrowser.equals(that.sessionBrowser) : that.sessionBrowser != null)
            return false;
        if (sessionForwardedFor != null ? !sessionForwardedFor.equals(that.sessionForwardedFor) : that.sessionForwardedFor != null)
            return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (sessionIp != null ? !sessionIp.equals(that.sessionIp) : that.sessionIp != null) return false;
        if (sessionPage != null ? !sessionPage.equals(that.sessionPage) : that.sessionPage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + sessionUserId;
        result = 31 * result + sessionForumId;
        result = 31 * result + sessionLastVisit;
        result = 31 * result + sessionStart;
        result = 31 * result + sessionTime;
        result = 31 * result + (sessionIp != null ? sessionIp.hashCode() : 0);
        result = 31 * result + (sessionBrowser != null ? sessionBrowser.hashCode() : 0);
        result = 31 * result + (sessionForwardedFor != null ? sessionForwardedFor.hashCode() : 0);
        result = 31 * result + (sessionPage != null ? sessionPage.hashCode() : 0);
        result = 31 * result + (int) sessionViewonline;
        result = 31 * result + (int) sessionAutologin;
        result = 31 * result + (int) sessionAdmin;
        return result;
    }
}
