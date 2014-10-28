package com.imagine.world.service;

import com.imagine.world.common.AvatarType;
import com.imagine.world.exception.MyException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * Created by tuan on 10/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
@WebAppConfiguration
//@Service
public class UserServicesTest extends MyAbstractTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Autowired
    ServiceState serviceState ;
//    @Autowired
//    MockHttpServletRequest request = new MockHttpServletRequest();


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testRegisterUser() throws MyException {

        Random r =new Random();
        serviceState.getService().register("DELETE-"+r.nextInt(10000),r.nextInt()+"@gmail.com",
                r.nextInt(100000)+"",new Date(), null,null,null,null,null,null,null,null,null);

        serviceState.getService().uploadTempAvatar(new MockMultipartFile("beeeeep","kia co be co mai toc duoi ga".getBytes()));
        serviceState.getService().register("DELETE-"+r.nextInt(10000),r.nextInt()+"@gmail.com",
                r.nextInt(100000)+"",new Date(), 1,new BigDecimal(1.00),1000,"BEEEEP", AvatarType.UPLOADED.getValue(),
                null,null,"askjjdh aksdhk","California");

    }

    @Test
    public void testLogin() throws MyException {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
        this.startSession();
        this.startRequest();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        System.out.println("Please note. the UserServiceI ID of before and after authorization");
        System.out.println(serviceState.getService().getClass());

        serviceState.getService().authorize(
//                serviceState, request,
                response, "letuan@gmail.com", "123456");
        Cookie cookie = response.getCookie(UserServiceI.COOKIE_KEY_SESSION_ID);
        Cookie cookie2 = response.getCookie(UserServiceI.COOKIE_KEY_USER_ID);
        System.out.println(cookie);


        System.out.println(serviceState.getService().getClass());
    }

    @Test
    public void testTimeStamp(){
        System.out.println(new Timestamp(new Date().getTime()).getTime());
        System.out.println(System.currentTimeMillis());
        int a = 1413368407;
    }

    @Test
    public void testLoginFail() throws MyException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        /**
         * Please look to error message every trycatch
         */
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }
//        try {            serviceState.getService().authorize(serviceState, request, response, "letuan@gmail.com", "wrongpass");      } catch (MyException e){            System.out.println(e.getMessage());        }

        Cookie cookie = response.getCookie(UserServiceI.COOKIE_KEY_USER_ID);
        System.out.println("Cookie "+cookie);
    }

    @Test
    public void testUserInfo() throws MyException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setCookies(new Cookie[]{
                new Cookie(UserServiceI.COOKIE_KEY_SESSION_ID, 1 + ""),
                new Cookie(UserServiceI.COOKIE_KEY_USER_ID, 1 + "")
        });
//        serviceState.getService().userInfo(request);
    }

    @Test
    public void testModifyUser() throws MyException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setCookies(new Cookie[]{
                new Cookie(UserServiceI.COOKIE_KEY_SESSION_ID, 1 + ""),
                new Cookie(UserServiceI.COOKIE_KEY_USER_ID, 1 + "")
        });
//        serviceState.getService().userInfo(request);
//        serviceState.getService().modifyUser(request,1,"newUsername","letuan@gmail.com","leuleuleu@gmail.com",
//                "newpass","123456","1990-12-30",
//                UserType.NORMAL_USER.getValue(),"avatar ne",AvatarType.REMOTE.getValue(),(short)123,(short)123,"hohoho","hohoho");
        serviceState.getService().modifyUser(1,null,null,null,
                 null,null,"1990-12-30",
                -1,null,null,(short)-1,(short)-1,"hohoho","hohoho");

    }

    @Test
    public void testLoginNew() throws Exception {
        this.mockMvc.perform(get("/testLogin").accept("application/json"))
                .andExpect(status().isOk());

    }
}
