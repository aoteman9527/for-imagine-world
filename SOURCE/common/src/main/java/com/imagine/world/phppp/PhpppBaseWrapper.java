package com.imagine.world.phppp;

import com.google.common.base.Defaults;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.imagine.world.ServiceAbstract;
import com.imagine.world.exception.InprocessException;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tuanle on 7/30/14.
 */
@Service("phpppBaseWrapper")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PhpppBaseWrapper extends ServiceAbstract {

    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PhpppBaseWrapper.class.getName());

    public void login(String username,String password, boolean isAutoLogin) throws HttpException, IOException, URISyntaxException, InprocessException {
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
            throw new InprocessException(condition1);
        }

        System.out.println(lines);
    }

    public void logout() throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        final ImmutableList<String> lines = this.sendPost(propertiesValue.PHPPP_REQUEST_PATH_AUTH,urlParameters);// make a login request
        System.out.println(lines);
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
    public void addNewUser(String username, String password, String emailAddress, Integer groupId, Integer timezone, String language,Integer userType) throws HttpException, IOException, URISyntaxException {
        //TODO :  validate email , password user name ....
        //TODO : improve send confirm email feature....
        //TODO : adapt for
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

    }
}
