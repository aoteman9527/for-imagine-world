package com.entertainment.musicpage.crawler.test;

import com.entertainment.musicpage.crawler.dao.SqliteDAO;
import com.entertainment.musicpage.crawler.models.HomePage;
import com.entertainment.musicpage.crawler.models.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.TestCase;
import org.apache.commons.mail.EmailException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuan on 12/8/14.
 */
public class GettingStarted extends TestCase {

    public void testCrawVnSharing(){
        String url = "http://truyentranhtuan.com/naruto/";
        System.out.println("start thread "+ this.toString());
        WebClient webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        HtmlPage page = null;
        try {
            page = webClient.getPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String pageAsXml = page.asXml();

        String pageAsText = page.asText();
        System.out.println(pageAsXml);
        System.out.println(pageAsText);
        webClient.closeAllWindows();
        System.out.println("complete thread "+ this.toString());
    }

    public void testCrawlerTruyenTranhTuan() throws InterruptedException {

        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.start();

        int shutdownTime = 10*60*1000;
        Thread.sleep(shutdownTime);
        Page.getThreadPoolExecutor().shutdown();

        while(!Page.getThreadPoolExecutor().isTerminated()){
            Thread.sleep(5000);
            System.out.println("the system is running ");
        }

        System.out.println("Complete work view page");
    }

    public void testSendEmail() throws EmailException {
        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.sendMail("TTTTT","BODDY");
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
}
