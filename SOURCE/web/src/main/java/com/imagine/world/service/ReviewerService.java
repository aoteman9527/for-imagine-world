package com.imagine.world.service;

import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;

/**
 * Created by tuan on 10/9/14.
 */
public class ReviewerService extends NormalUserService {

    @Override
    public void authorize(ServiceState serviceState) throws MyException {
        serviceState.changeToNormalUser();
        throw new AuthorizationException("TEST");
    }

    @Override
    public void issueArticle() {
        //TODO: do something to allow article to public
    }
}
