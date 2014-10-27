package com.imagine.world.service;

import com.imagine.world.exception.MyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.Cookie;

/**
 * Created by tuanlhd on 10/27/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
@Service
public class PostServiceTest extends MyAbstractTest {
    @Autowired
    ServiceState serviceState ;

    @Test
    public void testPostNew() throws MyException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "123456");
        request.setCookies(new Cookie[]{
                new Cookie(UserServiceI.COOKIE_KEY_SESSION_ID, 1 + ""),
                new Cookie(UserServiceI.COOKIE_KEY_USER_ID, 1 + "")
        });
        serviceState.getService().postNew(
                request,
                1,
                "THIS IS SUBJECT",
                "HUHUHUHUHUHUHUHUHU "// subject
        );
    }
}
