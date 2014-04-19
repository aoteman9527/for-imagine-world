package com.imagine.world.vbb;

import junit.framework.TestCase;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by letuan on 4/18/14.
 * After this TEST we know
 * 1. use CookieStore to keep session with other server in case login
 * 2. The other way keep static DefaultHttpClient object to keep session.
 */
public class TestWithVbulletin extends TestCase{
    private final String USER_AGENT = "Mozilla/5.0";
    private static Header[] headers=null;
    private static DefaultHttpClient client = new DefaultHttpClient();

    public void testHttpUrlConnectionAndCookie() throws IOException, HttpException, URISyntaxException {
        String hostUrl="http://localhost/forum/upload/auth/login";
        String vUrl="aHR0cDovL2xvY2FsaG9zdC9mb3J1bS91cGxvYWQv";
        String username="root";
        String vb_login_md5password="e10adc3949ba59abbe56e057f20f883e";

        send(hostUrl,vUrl,username,vb_login_md5password);
    }

    private void send(String url, String vUrl, String username, String vbLoginMd5password)
            throws HttpException, URISyntaxException, IOException {
        HttpPost post = new HttpPost(url);

        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("url", "vUrl"));
        urlParameters.add(new BasicNameValuePair("username", username));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password_utf", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("password", ""));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
//        System.out.println(Arrays.toString(response.getHeaders("Cookie")));
        headers = response.getHeaders("Set-Cookie");
        System.out.println(client.getCookieStore());

        //TODO : get set CookieStore instead use DefaultHttpClient
    }

    public void testCreateNewThread() throws URISyntaxException, IOException, HttpException {
        String tittle = "THIS IS TITLE 12312";
        String text = "THIS IS TEXT 213123";
        String cookie = "THIS IS TITLE";

        testHttpUrlConnectionAndCookie();
        CookieStore cookieStore = client.getCookieStore();
        client = new DefaultHttpClient();// renew DefaultHttpClient. avoid use same cookie
        client.setCookieStore(cookieStore);
        sendNewThread(tittle, text, cookie);
    }
    private void sendNewThread(String title, String text, String cookie)
            throws HttpException, URISyntaxException, IOException{
        String url = "http://localhost/forum/upload/create-content/text/";
        HttpPost post = new HttpPost(url);

        post.setHeader("User-Agent", USER_AGENT);
//        post.setHeaders(headers);
        //post.setHeader("Cookie","discussion_view=%7B.35.-1397838059%2C.36.-1397838206%2C.38.-1397838232%7D; lastvisit=1397836709; lastactivity=1397836709; sessionhash=05da49f4e15b7fc920f91cd803cf5eb6; userstyleid=3");
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nodeid", ""));
        urlParameters.add(new BasicNameValuePair("parentid", "15"));
        urlParameters.add(new BasicNameValuePair("channelid", ""));
        urlParameters.add(new BasicNameValuePair("ret", "http://localhost/forum/upload/forum/main-category/products"));
        urlParameters.add(new BasicNameValuePair("title", title));
        urlParameters.add(new BasicNameValuePair("text", text));
        urlParameters.add(new BasicNameValuePair("autocompleteHelper", ""));
        urlParameters.add(new BasicNameValuePair("tags", ""));
        urlParameters.add(new BasicNameValuePair("tags", ""));
        urlParameters.add(new BasicNameValuePair("btnSubmit", ""));
        urlParameters.add(new BasicNameValuePair("url", ""));
        urlParameters.add(new BasicNameValuePair("url", ""));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
        System.out.println(Arrays.toString(response.getHeaders("Cookie")));
    }

    // HTTP GET request
    private void sendGet() throws Exception {


        String url = "http://www.google.com/search?q=developer";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {
        String url = "https://selfsolve.apple.com/wcResults.do";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
        urlParameters.add(new BasicNameValuePair("cn", ""));
        urlParameters.add(new BasicNameValuePair("locale", ""));
        urlParameters.add(new BasicNameValuePair("caller", ""));
        urlParameters.add(new BasicNameValuePair("num", "12345"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }
}
