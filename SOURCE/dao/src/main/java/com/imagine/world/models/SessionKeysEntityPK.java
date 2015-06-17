package com.imagine.world.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tuan on 10/9/14.
 */
public class SessionKeysEntityPK implements Serializable {
    private String keyId;
    private int userId;

    @Column(name = "key_id")
    @Id
    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionKeysEntityPK that = (SessionKeysEntityPK) o;

        if (userId != that.userId) return false;
        if (keyId != null ? !keyId.equals(that.keyId) : that.keyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyId != null ? keyId.hashCode() : 0;
        result = 31 * result + userId;
        return result;
    }
}
