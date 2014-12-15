package com.entertainment.musicpage.crawler.test;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.imagine.world.crawler.dao.SqliteDAO;
import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.mail.EmailException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by tuan on 12/8/14.
 */
public class GettingStarted extends TestCase {
    public void testCrawlerTruyenTranhTuan() throws InterruptedException {
        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int shutdownTime = 2*60*1000;
                try {
                    Thread.sleep(shutdownTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Shutdown system ");
                Page.getThreadPoolExecutor().shutdown();
            }
        }).start();

        while(!Page.getThreadPoolExecutor().isTerminated()){
            Thread.sleep(2000);
            System.out.println(" the system is running , remain threads="+Page.getPageQueue().size());
        }

        System.out.println("Complete work view page");
    }

    public void testSendEmail() throws EmailException {
        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.sendMail("TTTTT asdsadas"," sadas das BODDY");
    }

    public void testSqlite(){
        SqliteDAO sqliteDAO = new SqliteDAO();
        try {
            sqliteDAO.insertChapter("HAHAH link","hihii title");
            List l= sqliteDAO.findChapterByLink("HAHAH link");
            System.out.println("l.size()="+l.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    HttpClientBuilder builder = HttpClientBuilder.create();
    CloseableHttpClient client = builder.build();
    final String USER_AGENT = "Mozilla/5.0";

    public void testOAuth2() throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> pl = new ArrayList<>();
            pl.add(new BasicNameValuePair("response_type","code"));
        pl.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        pl.add(new BasicNameValuePair("redirect_uri","urn:ietf:wg:oauth:2.0:oob"));
        pl.add(new BasicNameValuePair("scope","https://www.googleapis.com/auth/blogger"));

        String s = this.sendPost("https://accounts.google.com/o/oauth2/auth",pl);
        System.out.println(s);

        Document d = Jsoup.parse(s);
        Element e = d.select("A").get(0);
        String redirect = e.absUrl("href");
        s = this.sendGet(redirect,new HashMap<String, String>());
        WebClient w = new WebClient();
        URL url = new URL("http://www.google.com);
        HTMLParser.parseHtml(new StringWebResponse(s,url),w.getCurrentWindow());
        System.out.println(s);
    }

    public String sendPost(String endPointUrl, List<NameValuePair> postParameters)
            throws IOException, URISyntaxException, HttpException {

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
        HttpResponse response = client.execute(get);

        Reader reader = new InputStreamReader(response.getEntity().getContent());
        String s = IOUtils.toString(reader);
        reader.close();
        return s;
    }
}
