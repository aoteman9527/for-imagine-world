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
            Thread.sleep(4000);
            System.out.println(" the system is running , remain threads=" + Page.getPageQueue().size());
        }
        System.out.println("Complete work view page");
    }

}
