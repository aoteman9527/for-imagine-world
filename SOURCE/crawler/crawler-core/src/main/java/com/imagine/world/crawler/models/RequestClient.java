package com.imagine.world.crawler.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by tuanlhd on 12/16/14.
 */
public class RequestClient {
    private static RequestClient requestClient;
    private final HttpClientBuilder builder = HttpClientBuilder.create();
    private final CloseableHttpClient client = builder.build();
    private final String USER_AGENT = "Mozilla/5.0";
    private final ObjectMapper mapper = new ObjectMapper();

    private RequestClient(){
    }

    public String sendPost(String endPointUrl,String accessToken,HashMap json) throws IOException {
        HttpPost post = new HttpPost(endPointUrl);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer "+accessToken);
        StringEntity params =new StringEntity(mapper.writeValueAsString(json), "UTF-8");
        post.setEntity(params);
        return execute(post);
    }

    public String sendPost(String endPointUrl, List<NameValuePair> postParameters) throws IOException {
        HttpPost post = new HttpPost(endPointUrl);
        post.setHeader("User-Agent", USER_AGENT);
        post.setEntity(new UrlEncodedFormEntity(postParameters));
        return execute(post);
    }

    public String sendGet(String endPointUrl, Map<String,String> params) throws IOException {
        Iterator keysIterator = params.keySet().iterator();
        String key;
        endPointUrl +=endPointUrl.contains("?")?"":"?";
        while(keysIterator.hasNext()){
            key = keysIterator.next().toString();
            endPointUrl += key+"="+params.get(key);
        }

        HttpGet get = new HttpGet(endPointUrl);
        get.setHeader("User-Agent", USER_AGENT);
        get.releaseConnection();
        return execute(get);
    }

    public final synchronized String execute(HttpRequestBase h) throws IOException {
        HttpResponse response = client.execute(h);
        int code = response.getStatusLine().getStatusCode();
        Reader reader = new InputStreamReader(response.getEntity().getContent());
        String textBody = IOUtils.toString(reader);
        if(code != HttpStatus.SC_OK){
            throw new IOException(textBody);
        }
        /**
         * this is important
         * We must tell HttpClient that we are done with the connection and that it can now be reused. Without doing this HttpClient will wait indefinitely for a connection to free up so that it can be reused.
         */
        h.releaseConnection();
        return textBody;
    }

    public final static RequestClient i(){
        if (requestClient==null){
            requestClient = new RequestClient();
        }
        return requestClient;
    }
}
