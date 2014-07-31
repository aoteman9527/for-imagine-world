package com.imagine.world;

import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.phppp.PhpppBaseWrapper;
import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by tuanle on 7/30/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
public class PhpppClientTest extends MyAbstractTest {

    @Autowired(required = true)
    PhpppBaseWrapper phpppBaseWrapper;

    @Test
    public void testLogin() throws URISyntaxException, IOException, HttpException, LoginInvalidUserException, InprocessException {
        startSession();
        startRequest();
        phpppBaseWrapper.login("playernodien","sieunhan",true);
        endRequest();
        endSession();
    }

    @Test
    public void testLogout() throws URISyntaxException, IOException, HttpException, LoginInvalidUserException, InprocessException {
        startSession();
        startRequest();
        phpppBaseWrapper.login("playernodien", "sieunhan", true);
        endRequest();

        startRequest();
        phpppBaseWrapper.logout();
        endRequest();
        endSession();
    }

    @Test
    public void testAddNewUser() throws URISyntaxException, IOException, HttpException {
        startSession();
        startRequest();
        phpppBaseWrapper.addNewUser("playernodie1", "123456", "jjjj@lll.co", null, null, null, null);
        endRequest();
        endSession();
    }
}
