package com.imagine.world.vbb;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.imagine.world.dao.UserDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.models.UserEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by letuan on 6/20/14.
 */
@Service("vbbAdminClient")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VbbAdminClient extends VbbClient {

    protected String sessionhash = null;
    protected String adminhash = null;
    protected String securitytoken = null;
    protected SimpleDateFormat BIRTHDAY_DATE_FORMAT = new SimpleDateFormat(UserDAO.BIRTHDAY_DATE_FORMAT);


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

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param languageId "0">Use Forum Default "1">English (US)
     * @param title
     * @param customTitle "0">No, "2">Yes, user set, "1">Yes, admin set (HTML allowed)
     * @param homePage
     * @param userGroupId "6">Administrators "8">Banned Users "11">Channel Member "10">Channel Moderator "9">Channel Owner "7">Moderators "2" >Registered Users "5">Super Moderators "1">Unregistered / Not Logged In "3">Users Awaiting Email Confirmation "4">Users Awaiting Moderation
     * @param birthMonth
     * @param birthDay
     * @param birthYear
     * @param showbirthday      "0" >Hide Age and Date of Birth
                                "1">Display Only Age
                                "3">Display Only Day and Month of Birth
                                "2">Display Age and Full Date of Birth
     * @param signature
     * @param showSignature value="1" tabindex="1" >Yes
                            value="0" tabindex="1" >No
     * @param showavatars   value="1" tabindex="1" >Yes
                            value="0" tabindex="1" >No
     * @param icq
     * @param aim
     * @param yahoo
     * @param msn
     * @param skype
     * @throws HttpException
     * @throws IOException
     * @throws URISyntaxException
     * @throws AuthorizationException
     * @throws InprocessException
     */
    public void createUser(String username, String password, String email, int languageId, String title, int customTitle, String homePage, int userGroupId,
                           int birthMonth, int birthDay, int birthYear, int showbirthday,
                           String signature,int showSignature, int showavatars,
                           String icq, String aim, String yahoo, String msn, String skype
                           ) throws HttpException, IOException, URISyntaxException, AuthorizationException, InprocessException {

        this.authenticateChecking();

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

    public void updateUser(String username, String password, String email, String languageId, String title, String customTitle, String homePage, String userGroupId,
                           String birthMonth, String birthDay, String birthYear, String showbirthday,
                           String signature,int showSignature, int showavatars,
                           String icq, String aim, String yahoo, String msn, String skype) throws InprocessException, ParseException {
        //TODO : find user in db by username
        // update information
        // save to database

        UserDAO userDAO = new UserDAO();
        UserEntity userEntity = null;
        if(!Strings.isNullOrEmpty(username)){
            userEntity = userDAO.getUserByUsername(username);
        } else if(!Strings.isNullOrEmpty(email)){
            userEntity = userDAO.getUserByUsername(email);
        }

        if(userEntity==null){
            throw new InprocessException("not found user with ".concat(username).concat(" "+email));
        }

        if(!Strings.isNullOrEmpty(password)){
            userEntity.setPassword(password);
        }

        if(!Strings.isNullOrEmpty(email)){
            userEntity.setEmail(email);
        }

        if(!Strings.isNullOrEmpty(languageId)){
            userEntity.setLanguageid(Short.valueOf(languageId));
        }

        if(!Strings.isNullOrEmpty(title)){
            userEntity.setUsertitle(title);
        }

        if(!Strings.isNullOrEmpty(customTitle)){
            userEntity.setCustomtitle(Short.valueOf(customTitle));
        }

        if(!Strings.isNullOrEmpty(homePage)){
            userEntity.setHomepage(homePage);
        }

        if(!Strings.isNullOrEmpty(userGroupId)){
            userEntity.setUsergroupid(Short.valueOf(userGroupId));
        }

        if(!Strings.isNullOrEmpty(birthMonth)|| !Strings.isNullOrEmpty(birthDay)|| !Strings.isNullOrEmpty(birthYear)){
//            userEntity.setB(homePage);
            Date bithday = BIRTHDAY_DATE_FORMAT.parse(userEntity.getBirthday());
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(bithday);
            try {
                calendar.set(Calendar.MONTH,Integer.valueOf(birthMonth));
            }catch(NullPointerException e){}

            try {
                calendar.set(Calendar.MONTH,Integer.valueOf(birthDay));
            }catch(NullPointerException e){}

            try {
                calendar.set(Calendar.MONTH,Integer.valueOf(birthYear));
            }catch(NullPointerException e){}
        }

        if(!Strings.isNullOrEmpty(showbirthday)){
            userEntity.setShowbirthday(Short.valueOf(showbirthday));
        }

        if(!Strings.isNullOrEmpty(signature)){
//            userEntity.set(homePage);
        }

        if(!Strings.isNullOrEmpty(homePage)){
            userEntity.setHomepage(homePage);
        }

        if(!Strings.isNullOrEmpty(homePage)){
            userEntity.setHomepage(homePage);
        }

        if(!Strings.isNullOrEmpty(homePage)){
            userEntity.setHomepage(homePage);
        }

    }

    /**
     * one of them
     * @param userId
     * @param username
     * @param email
     * @throws HttpException
     * @throws URISyntaxException
     * @throws AuthorizationException
     * @throws InprocessException
     * @throws IOException
     */
    public void deleteUser( String userId, String username, String email ) throws HttpException, URISyntaxException, AuthorizationException, InprocessException, IOException {


        if(!Strings.isNullOrEmpty(userId)){
            deleteUserByUserid(userId);
        } else if(!Strings.isNullOrEmpty(username)){
            UserDAO userDAO = new UserDAO();
            UserEntity userEntity = userDAO.getUserByUsername(username);
            deleteUserByUserid(String.valueOf(userEntity.getUserid()));
        } else if(!Strings.isNullOrEmpty(email)){
            UserDAO userDAO = new UserDAO();
            UserEntity userEntity = userDAO.getUserByEmail(email);
            deleteUserByUserid(String.valueOf(userEntity.getUserid()));
        } else {
            throw new NullPointerException("Invalid 3 parameters");
        }

        System.out.println("Success delete user ".concat(Strings.nullToEmpty(username)).concat(Strings.nullToEmpty(userId)).concat(Strings.nullToEmpty(email)));

    }

    public void deleteUserByUserid(String userId) throws AuthorizationException, HttpException, IOException, URISyntaxException, InprocessException {

        this.authenticateChecking();

        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("do", "kill"));
        urlParameters.add(new BasicNameValuePair("adminhash", adminhash));
        urlParameters.add(new BasicNameValuePair("securitytoken", securitytoken));
        urlParameters.add(new BasicNameValuePair("userid", userId));

        ImmutableList<String> lines = this.sendPost(propertiesValue.VBB_ADMIN_USER_KILL,urlParameters);

        //Deleted User Successfully
        final String condition1 = "Deleted User Successfully";
        String response = Iterables.find(lines,new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains(condition1);
            }
        });

        if(response.contains(condition1)){
            System.out.println("success deleting user");
        } else {
            throw new InprocessException("Error deleting user.");
        }
    }

    public void authenticateChecking() throws AuthorizationException {
        if(Strings.isNullOrEmpty(securitytoken)){
            throw new AuthorizationException("Invalid securitytoken mean request does not authorize !");
        }
    }
}
