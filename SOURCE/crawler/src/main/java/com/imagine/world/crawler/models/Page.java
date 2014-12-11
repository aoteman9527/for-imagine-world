package com.imagine.world.crawler.models;

import com.gargoylesoftware.htmlunit.WebClient;
import com.imagine.world.crawler.dao.SqliteDAO;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuanlhd on 12/9/14.
 */
public abstract class Page implements Runnable{
    protected String url;
    protected WebClient webClient;

    private static final Properties pros = new Properties();
    static {
        try {
            pros.load(new FileInputStream(Page.class.getResource("/").getFile()+"crawler.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int corePoolSize = 4;
    private static int maxPoolSize = Integer.parseInt(pros.getProperty("thread.max.pool.size"));
    private static long keepAliveTime = 2;//minutes
    protected static final BlockingQueue<Runnable> pageQueue = new LinkedBlockingDeque<Runnable>(){
        /**
         * override to put objects at the front of the list
         * THIS TRICK FOR LIFO ThreadExecutor -> help DEPTH CRAWLING => haha it is perfect thing.
         * @param runnable
         * @throws InterruptedException
         */
        @Override
        public boolean offer(Runnable runnable) {
            super.addFirst(runnable);
            return true;
        }
    };
    protected static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,
            TimeUnit.SECONDS, pageQueue);;
    /**
     * Properties email
     */

    private static final String SECRET_MAIL_2_BLOGGER = pros.getProperty("email.secret.email2blogger");
    private static final String SMTP_HOST = pros.getProperty("email.smtp.host");
    private static final int SMTP_PORT = Integer.parseInt(pros.getProperty("email.smtp.port"));
    private static final String SMTP_USERNAME=pros.getProperty("email.smtp.username");
    private static final String SMTP_PASSWORD=pros.getProperty("email.smtp.password");
    /**
     * properties DAO
     */
    protected static final SqliteDAO sqliteDAO = new SqliteDAO();

    public Page(String url){
        this.url = url;
        webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

    public void start(){
        if(!threadPoolExecutor.isShutdown()){
            threadPoolExecutor.execute(this);
        }
    }

    public void completeWork(){
        this.webClient.closeAllWindows();
    }

    public boolean isExistedChapter(String urlChapter) throws SQLException {
        return !sqliteDAO.findChapterByLink(urlChapter).isEmpty();
    }

    public void sendMail(String subject, String message) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(SMTP_HOST);
        email.setSmtpPort(SMTP_PORT);
        email.setAuthenticator(new DefaultAuthenticator(SMTP_USERNAME, SMTP_PASSWORD));
//        email.setSSL(true);
        email.setFrom("auto-sender@gmail.com");
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(SECRET_MAIL_2_BLOGGER);
        email.send();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public static BlockingQueue<Runnable> getPageQueue() {
        return pageQueue;
    }

    public static int getShutDownTime(){
        return Integer.parseInt(pros.getProperty("thread.shutdown.time"));
    }
}
