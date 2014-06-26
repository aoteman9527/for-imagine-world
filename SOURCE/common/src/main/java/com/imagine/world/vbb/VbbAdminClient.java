package com.imagine.world.vbb;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.LoginInvalidUserException;
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
 * Created by letuan on 6/20/14.
 */
@Service("vbbAdminClient")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VbbAdminClient extends VbbClient {

    protected String sessionhash = null;
    protected String adminhash = null;
    protected String securitytoken = null;

    public void loginAdmincp(String username,String password) throws HttpException, IOException, URISyntaxException, LoginInvalidUserException {
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("securitytoken", "guest"));
        urlParameters.add(new BasicNameValuePair("do", "login"));
        urlParameters.add(new BasicNameValuePair("logintype", "cplogin"));
        urlParameters.add(new BasicNameValuePair("vb_login_username", username));
        urlParameters.add(new BasicNameValuePair("vb_login_password", password));
        urlParameters.add(new BasicNameValuePair("url", propertiesValue.VBB_HOST.concat("/admincp/index.php")));

        ImmutableList<String> lines = this.sendPost(propertiesValue.VBB_ADMIN_LOGIN_URL,urlParameters);// make a login request
        String redirectLink = null;// After login we have a link of vbb
        redirectLink = Iterables.find(lines,new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains("window.location");
            }
        });

        if(redirectLink.contains("loginerror")){
            throw new LoginInvalidUserException("Wrong username or password");
        }

        redirectLink = redirectLink.split("\"")[1];
        redirectLink+="do=head";
        lines = this.sendGet(redirectLink, Maps.<String, String>newHashMap());//at this time the response contain sessionhash, adminhash , securitytoken

        Iterator<String> iterator = Iterables.filter(lines, new Predicate<String>() {
                @Override
                public boolean apply(String input) {
                    return input.contains("SESSIONHASH")||input.contains("ADMINHASH")||input.contains("SECURITYTOKEN");
                }
        }).iterator();

        sessionhash = iterator.next().split("\"")[1];
        adminhash = iterator.next().split("\"")[1];
        securitytoken = iterator.next().split("\"")[1];
        System.out.println(sessionhash);
        System.out.println(adminhash);
        System.out.println(securitytoken);
        /**
         * Complete logged in because there are no exception.
         */
    }

    public void createUser(String username, String password, String email, int languageId, String title, int customTitle, String homePage, int userGroupId,
                           int birthMonth, int birthDay, int birthYear, int showbirthday,
                           String signature,int showSignature, int showavatars,
                           String icq, String aim, String yahoo, String msn, String skype
                           ) throws HttpException, IOException, URISyntaxException, AuthorizationException, InprocessException {

        if(Strings.isNullOrEmpty(securitytoken)){
            throw new AuthorizationException("Invalid securitytoken mean request does not authorize !");
        }

        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("s", sessionhash));
        urlParameters.add(new BasicNameValuePair("do", "update"));
        urlParameters.add(new BasicNameValuePair("adminhash", adminhash));
        urlParameters.add(new BasicNameValuePair("securitytoken", securitytoken));
        urlParameters.add(new BasicNameValuePair("user[username]", username));
        urlParameters.add(new BasicNameValuePair("password", password));
        urlParameters.add(new BasicNameValuePair("user[email]", email));
        urlParameters.add(new BasicNameValuePair("user[languageid]", String.valueOf(languageId)));
        urlParameters.add(new BasicNameValuePair("user[usertitle]", title));
        urlParameters.add(new BasicNameValuePair("user[customtitle]", String.valueOf(customTitle)));
        urlParameters.add(new BasicNameValuePair("user[homepage]", homePage));
        urlParameters.add(new BasicNameValuePair("user[usergroupid]", String.valueOf(userGroupId)));
        urlParameters.add(new BasicNameValuePair("user[birthday][month]", String.valueOf(birthMonth)));
        urlParameters.add(new BasicNameValuePair("user[birthday][day]", String.valueOf(birthDay)));
        urlParameters.add(new BasicNameValuePair("user[birthday][year]", String.valueOf(birthYear)));
        urlParameters.add(new BasicNameValuePair("user[signature]", signature));
        urlParameters.add(new BasicNameValuePair("user[icq]", icq));
        urlParameters.add(new BasicNameValuePair("user[aim]", aim));
        urlParameters.add(new BasicNameValuePair("user[yahoo]", yahoo));
        urlParameters.add(new BasicNameValuePair("user[msn]", msn));
        urlParameters.add(new BasicNameValuePair("user[skype]", skype));
        urlParameters.add(new BasicNameValuePair("user[msn]", msn));
        urlParameters.add(new BasicNameValuePair("options[showsignatures]", String.valueOf(showSignature)));
        urlParameters.add(new BasicNameValuePair("options[showavatars]", String.valueOf(showavatars)));

        ImmutableList<String> lines = this.sendPost(propertiesValue.VBB_ADMIN_USER_UPDATE,urlParameters);
        final String condition1 = "The email address you entered is already in use";
        final String condition2 = "That username is already in use or does not meet the administrator's standards.";
        final String condition3 = "Successfully";
        String response = Iterables.find(lines,new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains(condition1)|| input.contains(condition2)|| input.contains(condition3);
            }
        });

        if(response.contains(condition1)){
            throw new InprocessException(condition1);
        }else if(response.contains(condition2)){
            throw new InprocessException(condition2);
        } else{
            System.out.println("success creating user");
        }

    }

}
