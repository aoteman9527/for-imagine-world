package com.imagine.world;

import com.imagine.world.dao.UsersDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.vbb.VbbAdminClient;
import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by letuan on 4/19/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
public class VbbClientTest extends MyAbstractTest {
    @Autowired(required = true)
    VbbAdminClient vbbClient;

    @Test
    public void testLogin() throws URISyntaxException, IOException, HttpException, LoginInvalidUserException {
        startSession();
        startRequest();
        vbbClient.login("root","123456");
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

    @Test
    public void testLoginAdmincp() throws HttpException, URISyntaxException, LoginInvalidUserException, IOException {
        startSession();
        startRequest();
        vbbClient.loginAdmincp("root", "1233456");
        endRequest();
        endSession();

    }

    @Test
    public void testCreateUser() throws HttpException, URISyntaxException, LoginInvalidUserException, IOException, AuthorizationException, InprocessException {
        startSession();

        startRequest();
        vbbClient.loginAdmincp("root", "123456");
        endRequest();

        startRequest();
        vbbClient.createUser("playernodie20", "this is password", "myEmailTest3@mail.com",0,"This is title", 0, "this is home page", 2,
                12,12,1990, 1, "This is signature", 1, 1, null, null, null, null, null
        );
        UsersDAO usersDAO = new UsersDAO();
        usersDAO.getUserByUsername("playernodie20");
        endRequest();

        startRequest();
        vbbClient.deleteUser(null,"playernodie20",null);
        endRequest();

        endSession();

    }
}
