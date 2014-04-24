package com.imagine.world.vbb;

import com.imagine.world.PropertiesValue;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by letuan on 4/19/14.
 *
 */
public class VbbClient {
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(VbbClient.class.getName());
    private final String USER_AGENT = "Mozilla/5.0";
    private CloseableHttpClient client;

    public VbbClient(){
        HttpClientBuilder builder = HttpClientBuilder.create();
        client= builder.build();

    }

    /**
     *
     * @param endPointUrl equavilent with request url
     * @param urlParameters
     * @throws IOException
     * @throws URISyntaxException
     * @throws HttpException
     */
    void sendPost(String endPointUrl, List<NameValuePair> urlParameters)
            throws IOException, URISyntaxException, HttpException {

        HttpPost post = new HttpPost(endPointUrl);
        post.setHeader("User-Agent", USER_AGENT);
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + endPointUrl);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());
        LOGGER.info("\nSending 'POST' request to URL : " + endPointUrl);
        LOGGER.info("Post parameters : " + post.getEntity());
        LOGGER.info("Response Code : " +
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

    public void login(String requestUrl,String vUrl, String username, String vbLoginMd5password ) throws HttpException, IOException, URISyntaxException {

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("url", vUrl));
        urlParameters.add(new BasicNameValuePair("username", username));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("vb_login_md5password_utf", vbLoginMd5password));
        urlParameters.add(new BasicNameValuePair("password", ""));

        this.sendPost(requestUrl,urlParameters);
    }

    public void createNewThread(String requestUrl,
                                String nodeId, String parentId, String channelId, String ret, String title,
                                String text, String autocompleteHelper,
                                String tags,
                                String btnSubmit,
                                String vUrl
    ) throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> urlParameters = new ArrayList<>();
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
