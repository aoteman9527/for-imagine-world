package com.imagine.world;

import com.google.common.collect.ImmutableList;
import com.google.common.io.LineReader;
import com.imagine.world.config.PropertiesValue;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by letuan on 6/19/14.
 */
public abstract class ServiceAbstract {

    private final String USER_AGENT = "Mozilla/5.0";
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ServiceAbstract.class.getName());
    private CloseableHttpClient client;

    @Autowired
    public PropertiesValue propertiesValue;

    protected ServiceAbstract(){
        HttpClientBuilder builder = HttpClientBuilder.create();
        client= builder.build();
    }

    /**
     *
     * @param endPointUrl equavilent with request url
     * @param urlParameters
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws org.apache.http.HttpException
     */
    public ImmutableList sendPost(String endPointUrl, List<NameValuePair> urlParameters)
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

        Reader reader = new InputStreamReader(response.getEntity().getContent());
        LineReader lineReader = new LineReader(reader);
        ImmutableList.Builder<String> b = ImmutableList.builder();
        String line = "";
        while((line=lineReader.readLine() )!=null){
            b.add(line);
        }
        reader.close();
        return b.build();
    }

    public ImmutableList sendGet(String endPointUrl, Map<String,String> params) throws IOException {
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
        LOGGER.info("\nSending 'POST' request to URL : " + endPointUrl);
        LOGGER.info("Response Code : " +
                response.getStatusLine().getStatusCode());

        Reader reader = new InputStreamReader(response.getEntity().getContent());
        LineReader lineReader = new LineReader(reader);
        ImmutableList.Builder<String> b = ImmutableList.builder();
        String line = "";
        while((line=lineReader.readLine() )!=null){
            b.add(line);
        }
        reader.close();
        return b.build();
    }

}
