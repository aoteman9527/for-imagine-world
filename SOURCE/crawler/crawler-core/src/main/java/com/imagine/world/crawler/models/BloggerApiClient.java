package com.imagine.world.crawler.models;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * Created by tuanlhd on 12/12/14.
 */
public class BloggerApiClient {
    private static BloggerApiClient bloggerApiClient;
    private final String USER_AGENT = "Mozilla/5.0";
    private CloseableHttpClient client;
    private final HttpClientBuilder builder = HttpClientBuilder.create();

    private BloggerApiClient(){
        client= builder.build();
    }

    public String retrievingblog(String blogId) throws IOException {
        Map<String,String> params = new HashMap<>();
                params.put("key",Configuration.i().BLOGGER_API_V3_KEY);
        return this.sendGet("https://www.googleapis.com/blogger/v3/blogs/"+blogId, params);
    }

    public void addingPost(){

    }

    public String retrievingAccessToken() throws IOException {
        List<NameValuePair> codeRequestParams = new ArrayList<>();
        codeRequestParams.add(new BasicNameValuePair("response_type", "code"));
        codeRequestParams.add(new BasicNameValuePair("client_id", "600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        codeRequestParams.add(new BasicNameValuePair("scope", "https://www.googleapis.com/auth/blogger"));
        codeRequestParams.add(new BasicNameValuePair("state", "1131321"));
        codeRequestParams.add(new BasicNameValuePair("access_type", "online"));
        codeRequestParams.add(new BasicNameValuePair("include_granted_scopes", "true"));
        codeRequestParams.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
        return this.sendPost("https://accounts.google.com/o/oauth2/auth",codeRequestParams);


    }

    private String sendPost(String endPointUrl, List<NameValuePair> postParameters) throws IOException {
        HttpPost post = new HttpPost(endPointUrl);
        post.setHeader("User-Agent", USER_AGENT);
        post.setEntity(new UrlEncodedFormEntity(postParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + endPointUrl);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        Reader reader = new InputStreamReader(response.getEntity().getContent());
        return IOUtils.toString(reader);
    }

    private String sendGet(String endPointUrl, Map<String,String> params) throws IOException {
        Iterator keysIterator = params.keySet().iterator();
        String key;
        endPointUrl +=endPointUrl.contains("?")?"":"?";
        while(keysIterator.hasNext()){
            key = keysIterator.next().toString();
            endPointUrl += key+"="+params.get(key);
        }

        HttpGet get = new HttpGet(endPointUrl);
        get.setHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(get);

        Reader reader = new InputStreamReader(response.getEntity().getContent());
        return IOUtils.toString(reader);
    }

    public static BloggerApiClient i(){
        if(bloggerApiClient==null){
            bloggerApiClient = new BloggerApiClient();
        }
        return bloggerApiClient;
    }
}
