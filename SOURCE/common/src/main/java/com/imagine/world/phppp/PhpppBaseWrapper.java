package com.imagine.world.phppp;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.imagine.world.ServiceAbstract;
import com.imagine.world.dao.PhpbbUsersDAO;
import com.imagine.world.dao.UserDAO;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.models.PhpbbUsersEntity;
import com.imagine.world.models.UserEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by tuanle on 7/30/14.
 */
@Service("phpppBaseWrapper")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PhpppBaseWrapper extends ServiceAbstract {

    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PhpppBaseWrapper.class.getName());

    public void login(String username,String password, boolean isAutoLogin) throws HttpException, IOException, URISyntaxException, LoginInvalidUserException {
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("username", username));
        urlParameters.add(new BasicNameValuePair("password", password));
        urlParameters.add(new BasicNameValuePair("autologin", isAutoLogin+""));

        final String condition1 = "LOGIN FAIL";
        final String condition2 = "LOGIN SUCCESS";

        final ImmutableList<String> lines = this.sendPost(propertiesValue.PHPPP_REQUEST_PATH_AUTH,urlParameters);// make a login request
        String response = Iterables.find(lines, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains(condition1) || input.contains(condition2) ;
            }
        });

        if(response.equalsIgnoreCase(condition1)){
            throw new LoginInvalidUserException(condition1);
        }

        System.out.println(lines);
        LOGGER.info(lines);
    }

    public void logout() throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        final ImmutableList<String> lines = this.sendPost(propertiesValue.PHPPP_REQUEST_PATH_AUTH,urlParameters);// make a login request
        System.out.println(lines);
        LOGGER.info(lines);

    }

    /**
     *
     * @param username
     * @param password
     * @param emailAddress
     * @param groupId refer to table phpbb_groups
     * @param timezone
     * @param language
     * @param userType refer to https://wiki.phpbb.com/Table.phpbb_users
     */
    public void addNewUser(String username, String password, String emailAddress, Integer groupId, Integer timezone, String language,Integer userType) throws HttpException, IOException, URISyntaxException, InprocessException {
        //TODO :  validate email , password user name ....
        //Validate duplicate username ....
        //TODO : improve send confirm email feature ....

        if(PhpbbValidation.isExistedUsername(username)){
            LOGGER.info("InprocessException(Existed username) " + username);
            throw new InprocessException("Existed username");
        }

        if(PhpbbValidation.isExistedEmailAddress(emailAddress)){
            LOGGER.info("InprocessException(Existed emailAddress) " + emailAddress);
            throw new InprocessException("Existed emailAddress");
        }

        groupId = Objects.firstNonNull(groupId,1);
        timezone = Objects.firstNonNull(timezone,0);
        language = Objects.firstNonNull(language,"en");
        userType = Objects.firstNonNull(userType,0);

        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("username", username));
        urlParameters.add(new BasicNameValuePair("password", password));
        urlParameters.add(new BasicNameValuePair("email_address", emailAddress));
        urlParameters.add(new BasicNameValuePair("group_id", groupId.toString()));
        urlParameters.add(new BasicNameValuePair("timezone", timezone.toString()));
        urlParameters.add(new BasicNameValuePair("language", language));
        urlParameters.add(new BasicNameValuePair("user_type", userType.toString()));

        final ImmutableList<String> lines = this.sendPost(propertiesValue.PHPPP_REQUEST_PATH_ADD_USER,urlParameters);// make a request
        System.out.println(lines);
        LOGGER.info(lines);


    }

    public void deleteUser(String userId, String username, String email) throws HttpException, IOException, URISyntaxException, InprocessException {

        PhpbbUsersEntity userEntity = null;
        PhpbbUsersDAO phpbbUsersDAO = new PhpbbUsersDAO();
        if(!Strings.isNullOrEmpty(userId)){
            userEntity = phpbbUsersDAO.getUserByUserId(userId);
        } else if(!Strings.isNullOrEmpty(username)){
            userEntity = phpbbUsersDAO.getUserByUsername(username);
        } else if(!Strings.isNullOrEmpty(email)){
            userEntity = phpbbUsersDAO.getUserByEmail(email);
        } else {
            throw new NullPointerException("Invalid 3 parameters");
        }

        if(userEntity==null){
            LOGGER.info("InprocessException No such this user " + userId + username + email);
            throw new InprocessException("No such this user with " + userId + username + email);
        }

        userId= String.valueOf(userEntity.getUserId());
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("user_id", userId));

        ImmutableList<String> lines = this.sendPost(propertiesValue.PHPPP_REQUEST_PATH_DELETE_USER,urlParameters);// make a request
        System.out.println(lines);
        LOGGER.info(lines);
    }

}
