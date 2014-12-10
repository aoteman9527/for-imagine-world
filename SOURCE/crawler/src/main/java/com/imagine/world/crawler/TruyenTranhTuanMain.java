package com.imagine.world.crawler;

import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;

/**
 * Created by tuanlhd on 12/10/14.
 */
public class TruyenTranhTuanMain {

    public static void main(String[] arg) throws InterruptedException {
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

}
