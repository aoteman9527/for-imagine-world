package com.imagine.world.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by tuan on 10/11/14.
 */
@Component
@Scope( value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session {
    private String tempAvatarPath;
    private String email;
    private int userId=-1;

    public String getTempAvatarPath() {
        return tempAvatarPath;
    }

    public void setTempAvatarPath(String tempAvatarPath) {
        this.tempAvatarPath = tempAvatarPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * this function is used for log out case.
     */
    public void clearData(){
        this.tempAvatarPath = null;
        this.email = null;
        this.userId = -1;
    }
}
