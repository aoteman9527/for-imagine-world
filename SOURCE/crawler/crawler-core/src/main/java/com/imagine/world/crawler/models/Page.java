package com.imagine.world.crawler.models;

import com.gargoylesoftware.htmlunit.WebClient;
import com.imagine.world.crawler.dao.SqliteDAO;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.sql.SQLException;
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
    protected static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Configuration.i().corePoolSize,Configuration.i().maxPoolSize,Configuration.i().keepAliveTime,
            TimeUnit.SECONDS, pageQueue);;

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
        email.setHostName(Configuration.i().SMTP_HOST);
        email.setSmtpPort(Configuration.i().SMTP_PORT);
        email.setAuthenticator(new DefaultAuthenticator(Configuration.i().SMTP_USERNAME, Configuration.i().SMTP_PASSWORD));
        email.setSSL(true);
        email.setFrom("auto-sender@gmail.com");
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(Configuration.i().SECRET_MAIL_2_BLOGGER);
        email.send();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public static BlockingQueue<Runnable> getPageQueue() {
        return pageQueue;
    }


}
