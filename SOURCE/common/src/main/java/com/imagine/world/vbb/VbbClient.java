package com.imagine.world.vbb;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.imagine.world.ServiceAbstract;
import com.imagine.world.exception.LoginInvalidUserException;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


/**
 * Created by letuan on 4/19/14.
 *
 */
public class VbbClient extends ServiceAbstract {

    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(VbbClient.class.getName());

    public void login(String requestUrl,String vUrl, String username, String vbLoginMd5password ) throws HttpException, IOException, URISyntaxException, LoginInvalidUserException {

        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("url", vUrl));
        urlParameters.add(new BasicNameValuePair("username", username));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password_utf", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("password", ""));

        ImmutableList<String> lines = this.sendPost(requestUrl,urlParameters);
        if(!lines.toString().contains("Logging in...")) {
            throw new LoginInvalidUserException("invalid username and password");
        }
    }

    public void login(String username, String password) throws URISyntaxException, IOException, HttpException, LoginInvalidUserException {
        HashFunction hf = Hashing.md5();
        HashCode hashCode = hf.newHasher().putString(password, Charsets.UTF_8).hash();

        String vbLoginMd5password = hashCode.toString();
        this.login(
                propertiesValue.VBB_REQUEST_PATH_AUTH_LOGIN,
                propertiesValue.VBB_V_URL,
                username,
                vbLoginMd5password
                );

    }

    public void logout() throws IOException {
        this.sendGet(propertiesValue.VBB_REQUEST_PATH_AUTH_LOGOUT, Maps.<String, String>newHashMap());
        LOGGER.info("logout success");
    }

    public void createNewThread(String requestUrl,
                                String parentId,
                                String ret,
                                String title,
                                String text

    ) throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> urlParameters = Lists.newLinkedList();
        urlParameters.add(new BasicNameValuePair("nodeid", ""));
        urlParameters.add(new BasicNameValuePair("parentid", parentId));
        urlParameters.add(new BasicNameValuePair("channelid", ""));
        urlParameters.add(new BasicNameValuePair("ret", ret));
        urlParameters.add(new BasicNameValuePair("title", title));
        urlParameters.add(new BasicNameValuePair("text", text));
        urlParameters.add(new BasicNameValuePair("autocompleteHelper", ""));
        urlParameters.add(new BasicNameValuePair("tags", ""));
        urlParameters.add(new BasicNameValuePair("tags", ""));
        urlParameters.add(new BasicNameValuePair("btnSubmit", ""));
        urlParameters.add(new BasicNameValuePair("url", ""));
        urlParameters.add(new BasicNameValuePair("url", ""));

        this.sendPost(requestUrl,urlParameters);
    }
}
