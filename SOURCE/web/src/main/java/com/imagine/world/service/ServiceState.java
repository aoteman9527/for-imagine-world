package com.imagine.world.service;

import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by tuan on 10/10/14.
 */
@Component
@Scope( value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServiceState {

    private UserServiceI userServiceI;

    @Autowired
    private NormalUserService normalUserService;
    @Autowired
    private ReviewerService reviewerService;
    @Autowired
    private PowerUserService powerUserService;

    private void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    public void changeToNormalUser(){
        this.setUserServiceI(normalUserService);
    }

    public void changeToReviewerUser(){
        this.setUserServiceI(reviewerService);
    }

    public void changeToPowerUser(){
        this.setUserServiceI(powerUserService);
    }

    public UserServiceI getService() {
        if(null == userServiceI)
            userServiceI = normalUserService;
        return userServiceI;
    }
}
