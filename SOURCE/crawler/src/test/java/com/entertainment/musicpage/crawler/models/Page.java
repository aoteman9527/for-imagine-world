package com.entertainment.musicpage.crawler.models;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuanlhd on 12/9/14.
 */
public abstract class Page implements Runnable{
    protected String url;
    private static int corePoolSize = 4;
    private static int maxPoolSize = 4;
    private static long keepAliveTime = 10;
    protected static final WebClient webClient = new WebClient();
    protected static final ArrayBlockingQueue<Runnable> pageQueue = new ArrayBlockingQueue<Runnable>(20);
    protected static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,
            TimeUnit.SECONDS, pageQueue);;

    public Page(String url){
        this.url = url;
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

    public void start(){
        if(!threadPoolExecutor.isShutdown())
            threadPoolExecutor.execute(this);
    }

    public void completeWork(){
        this.webClient.closeAllWindows();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }
}
