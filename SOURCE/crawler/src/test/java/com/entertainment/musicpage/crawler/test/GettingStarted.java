package com.entertainment.musicpage.crawler.test;

import com.imagine.world.crawler.dao.SqliteDAO;
import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;
import junit.framework.TestCase;
import org.apache.commons.mail.EmailException;

import java.sql.SQLException;
import java.util.List;

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
