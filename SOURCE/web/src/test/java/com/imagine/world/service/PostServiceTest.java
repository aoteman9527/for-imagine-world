package com.imagine.world.service;

import com.imagine.world.dao.ForumDAO;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.ForumsEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.Cookie;
import java.util.Date;

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
    @Ignore
    public void testRegisterNewUserForPost() throws MyException {
        serviceState.getService().register(
                "letuan",
               "letuan@gmail.com",
                "123456",
                new Date(),
                null,null,null,null,null,null,null,null,null);

    }

    @Test
    public void testPostNew() throws MyException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        serviceState.getService().authorize(
//                serviceState, request,
                response, "letuan@gmail.com", "123456");
        request.setCookies(new Cookie[]{
                new Cookie(UserServiceI.COOKIE_KEY_SESSION_ID, 1 + ""),
                new Cookie(UserServiceI.COOKIE_KEY_USER_ID, 1 + "")
        });
//        serviceState.getService().postNew(
//                1,
//                "THIS IS SUBJECT",
//                "HUHUHUHUHUHUHUHUHU "// subject
//        );
    }
}
