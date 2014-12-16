package com.imagine.world.crawler.models;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuanlhd on 12/12/14.
 */
public class BloggerApiClient {
    private static BloggerApiClient bloggerApiClient;
    private HashMap<String,Object> accessToken;
    private RequestClient rq = RequestClient.i();
    private Configuration cf = Configuration.i();

    private BloggerApiClient(){
    }

    public String retrievingblog(String blogId) throws IOException {
        Map<String,String> params = new HashMap<>();
                params.put("key",cf.BLOGGER_API_V3_KEY);
        return rq.sendGet("https://www.googleapis.com/blogger/v3/blogs/" + blogId, params);
    }

    public String addingPost(String title, String content) throws IOException {
        HashMap params = new HashMap();
        params.put("kind","blogger#post");
        params.put("blog","{\"id\": \""+cf.BLOGGER_BLOG_ID+"\"}");
        params.put("title",title);
        params.put("content",content);
        return rq.sendPost(String.format("https://www.googleapis.com/blogger/v3/blogs/%s/posts/", cf.BLOGGER_BLOG_ID),
                this.retrievingAccessToken(), params);
    }

    private synchronized String retrievingAccessToken() throws IOException {
        if(accessToken == null || Long.parseLong(accessToken.get("expires_in").toString())<= System.currentTimeMillis()/1000L){
            List<NameValuePair> codeRequestParams = new ArrayList<>();
            String refreshToken = cf.GOOGLE_OAUTH_REFRESH_TOKEN;
            codeRequestParams.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
            codeRequestParams.add(new BasicNameValuePair("client_secret","HZ0QvZuiibNsLdzt4HPmSyJ7"));
            codeRequestParams.add(new BasicNameValuePair("grant_type","refresh_token"));
            codeRequestParams.add(new BasicNameValuePair("refresh_token", refreshToken));
            accessToken = new ObjectMapper().readValue(
                    rq.sendPost("https://accounts.google.com/o/oauth2/token", codeRequestParams)
                            .getBytes(),
                    HashMap.class);
            String a = accessToken.get("expires_in").toString();
            final Object expireTime = System.currentTimeMillis()/1000L+Integer.parseInt(accessToken.get("expires_in").toString());
            accessToken.put("expires_in",expireTime+"");
        }
        return accessToken.get("access_token").toString();
    }



    public final static BloggerApiClient i(){
        if(bloggerApiClient==null){
            bloggerApiClient = new BloggerApiClient();
        }
        return bloggerApiClient;
    }
}
