package com.imagine.world;

import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.vbb.VbbClient;
import junit.framework.TestCase;
import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by letuan on 4/19/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
public class VbbClientTest extends MyAbstractTest {
    @Autowired
    VbbClient vbbClient;

    @Test
    public void testLogin() throws URISyntaxException, IOException, HttpException, LoginInvalidUserException {
        startSession();
        startRequest();
        vbbClient.login("root","1234456");
        endRequest();
        endSession();
    }

    @Test
    public void testLogout() throws HttpException, IOException, LoginInvalidUserException, URISyntaxException {
        startSession();
        startRequest();
        vbbClient.login("root", "123456");
        vbbClient.logout();
        endRequest();
        endSession();
    }
}
