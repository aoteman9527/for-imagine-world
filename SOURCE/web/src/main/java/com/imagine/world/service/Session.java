package com.imagine.world.service;

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

    public String getTempAvatarPath() {
        return tempAvatarPath;
    }

    public void setTempAvatarPath(String tempAvatarPath) {
        this.tempAvatarPath = tempAvatarPath;
    }
}
