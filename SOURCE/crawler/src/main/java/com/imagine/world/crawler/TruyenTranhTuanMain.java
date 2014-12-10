package com.imagine.world.crawler;

import com.imagine.world.crawler.dao.SqliteDAO;
import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;
import org.apache.commons.mail.EmailException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tuanlhd on 12/10/14.
 */
public class TruyenTranhTuanMain {
    public void testCrawlerTruyenTranhTuan() throws InterruptedException {

        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.start();

        int shutdownTime = 2*60*1000;
        Thread.sleep(shutdownTime);
        System.out.println("Shutdown system ");
        Page.getThreadPoolExecutor().shutdown();

        while(!Page.getThreadPoolExecutor().isTerminated()){
            Thread.sleep(4000);
            System.out.println(" the system is running , remain threads=" + Page.getPageQueue().size());
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
