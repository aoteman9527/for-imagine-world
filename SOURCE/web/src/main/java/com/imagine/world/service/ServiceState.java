package com.imagine.world.service;

import com.imagine.world.exception.MyException;
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
    private static NormalUserService NORMAL_USER = new NormalUserService();
    private static ReviewerService REVIEWER = new ReviewerService();
    private static PowerUserService POWER_USER = new PowerUserService();

    public ServiceState(){
        userServiceI = NORMAL_USER;
    }

    private void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    public void changeToNormalUser(){
        this.setUserServiceI(NORMAL_USER);
    }

    public void changeToReviewerUser(){
        this.setUserServiceI(REVIEWER);
    }

    public void changeToPowerUser(){
        this.setUserServiceI(POWER_USER);
    }

    public UserServiceI getService() {
        return userServiceI;
    }
}
