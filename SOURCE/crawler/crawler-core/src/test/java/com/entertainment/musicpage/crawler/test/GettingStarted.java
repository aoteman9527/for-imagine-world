package com.entertainment.musicpage.crawler.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.*;
import com.imagine.world.crawler.dao.SqliteDAO;
import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
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

import java.io.*;
import java.net.URISyntaxException;
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


    /**
     * To use this test. must use it from debug mode. to replace "code"
     */
    HttpClientBuilder builder = HttpClientBuilder.create();
    CloseableHttpClient client = builder.build();
    final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Intel Mac OS X 10.6; rv:7.0.1) Gecko/20100101 Firefox/7.0.1";

    public void testObtainCodeToken() throws HttpException, IOException, URISyntaxException, InterruptedException {
        List<NameValuePair> pl = new ArrayList<>();

        pl.add(new BasicNameValuePair("response_type","code"));
        pl.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        pl.add(new BasicNameValuePair("redirect_uri","http://localhost"));
        pl.add(new BasicNameValuePair("scope","https://www.googleapis.com/auth/blogger"));

        String s = this.sendPost("https://accounts.google.com/o/oauth2/auth",pl);
        System.out.println(s);

        /**
         * get redirect
         */
        Document d = Jsoup.parse(s);
        Element e = d.select("A").get(0);
        final String redirect = e.absUrl("href");
        final WebClient w = new WebClient();w.getOptions().setThrowExceptionOnScriptError(false);w.getOptions().setCssEnabled(false);

        /**
         * Open redirect go to login form
         */
        w.getOptions().setJavaScriptEnabled(false);
        HtmlPage p = w.getPage(redirect);IOUtils.copy(new ByteArrayInputStream(p.asXml().getBytes()), new FileOutputStream(new File("/tmp/login.html")));
        WebWindow window = p.getEnclosingWindow();
        w.getOptions().setJavaScriptEnabled(true);

        /**
         * get login form then submit
         */
        HtmlForm form = p.getFormByName("");//no name are set
        ((HtmlTextInput)form.getInputByName("Email")).setValueAttribute("tuanlhdnl@gmail.com");
        ((HtmlPasswordInput)form.getInputByName("Passwd")).setValueAttribute("sieunhan123");
        ((HtmlSubmitInput)form.getInputByName("signIn")).click();
        while(window.getEnclosedPage() == p) {
            // The page hasn't changed.
            Thread.sleep(500);
        }

        /**
         * Login success get Permission page
         */
        // This loop above will wait until the page changes.
        p = (HtmlPage) window.getEnclosedPage();
        IOUtils.copy(new ByteArrayInputStream(p.asXml().getBytes()), new FileOutputStream(new File("/tmp/RequirePermission.html")));

        /**
         * filter approval form and accept button. then submit
         */
        System.out.println("Submit login form.");
        form = p.getFormByName("");//get approval form
        form.getElementsByAttribute("button","id","submit_approve_access").get(0).click();
        System.out.println("Submit approve");
        /**
         * Getting code form response
         */
        while(window.getEnclosedPage() == p) {
            // The page hasn't changed.
            Thread.sleep(500);
        }
        p = (HtmlPage) window.getEnclosedPage();
        System.out.println(p.asText());
        w.closeAllWindows();


    }

    /**
     * this test for oauth2.0
     */
    public void testObtainAccessToken() throws HttpException, IOException, URISyntaxException {
        List<NameValuePair> pl = new ArrayList<>();

        pl.add(new BasicNameValuePair("response_type","code"));
        pl.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        pl.add(new BasicNameValuePair("redirect_uri","http://localhost"));
        pl.add(new BasicNameValuePair("scope","https://www.googleapis.com/auth/blogger"));

        String s = this.sendPost("https://accounts.google.com/o/oauth2/auth",pl);

        /**
         * get redirect
         */
        Document d = Jsoup.parse(s);
        Element e = d.select("A").get(0);
        final String redirect = e.absUrl("href");
        System.out.println("This is the redirect Approval page, paste it to web browser and input your code here ");
        System.out.println(redirect);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine();reader.close();

        /**
         * This continueing when you have a "code"
         */
        pl = new ArrayList<>();
        pl.add(new BasicNameValuePair("code",code));
        pl.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        pl.add(new BasicNameValuePair("client_secret","HZ0QvZuiibNsLdzt4HPmSyJ7"));
        pl.add(new BasicNameValuePair("redirect_uri","http://localhost"));
        pl.add(new BasicNameValuePair("grant_type","authorization_code"));

        s = this.sendPost("https://accounts.google.com/o/oauth2/token",pl);
        System.out.println(s);

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap accessToken = objectMapper.readValue(s.getBytes(), HashMap.class);

        /**
         * Refresh token
         *
         */
        String refreshToken = accessToken.get("refresh_token").toString();
        pl = new ArrayList<>();
        pl.add(new BasicNameValuePair("client_id","600206105823-o5jfellgek347082t3004n8cgsel6plk.apps.googleusercontent.com"));
        pl.add(new BasicNameValuePair("client_secret","HZ0QvZuiibNsLdzt4HPmSyJ7"));
        pl.add(new BasicNameValuePair("grant_type","refresh_token"));
        pl.add(new BasicNameValuePair("refresh_token",refreshToken));

        s = this.sendPost("https://accounts.google.com/o/oauth2/token",pl);
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

    public static void main(String arg[]) throws URISyntaxException, IOException, HttpException {
        new GettingStarted().testObtainAccessToken();
    }
}
