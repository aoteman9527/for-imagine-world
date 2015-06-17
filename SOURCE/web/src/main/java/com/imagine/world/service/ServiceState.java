package com.imagine.world.service;

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

    private CombineServices combineServices;

    @Autowired
    private NormalUserService normalUserService;
    @Autowired
    private ReviewerService reviewerService;
    @Autowired
    private PowerUserService powerUserService;
    @Autowired
    private NoLoggedInUserService noLoggedInUserService;

    private void setCombineServices(CombineServices combineServices) {
        this.combineServices = combineServices;
    }

    public void changeToNormalUser(){
        this.setCombineServices(normalUserService);
    }

    public void changeToReviewerUser(){
        this.setCombineServices(reviewerService);
    }

    public void changeToPowerUser(){
        this.setCombineServices(powerUserService);
    }

    public void changeToNoLoggedInUser(){
        this.setCombineServices(noLoggedInUserService);
    }

    public CombineServices getService() {
        if(null == combineServices)
            combineServices = normalUserService;
        return combineServices;
    }
}
