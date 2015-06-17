package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@Table(name = "SESSION_KEYS", schema = "", catalog = "blogs")
@IdClass(SessionKeysEntityPK.class)
public class SessionKeysEntity {
    private String keyId;
    private int userId;
    private String lastIp;
    private int lastLogin;

    @Id
    @Column(name = "key_id")
    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "last_login")
    public int getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(int lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionKeysEntity that = (SessionKeysEntity) o;

        if (lastLogin != that.lastLogin) return false;
        if (userId != that.userId) return false;
        if (keyId != null ? !keyId.equals(that.keyId) : that.keyId != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyId != null ? keyId.hashCode() : 0;
        result = 31 * result + userId;
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + lastLogin;
        return result;
    }
}
