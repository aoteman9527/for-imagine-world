package com.imagine.world.crawler;

import com.imagine.world.crawler.models.HomePage;
import com.imagine.world.crawler.models.Page;

/**
 * Created by tuanlhd on 12/10/14.
 */
public class TruyenTranhTuanMain {

    /**
     *
     * @param arg (0)shutdown time = 10*60*1000 =10 minutes
     *            (1)poolsize default 4
     * @throws InterruptedException
     */
    public static void main(final String[] arg) throws InterruptedException {
        if(arg.length == 2 && arg[1]!=null){
            Page.setMaxPoolSize(Integer.parseInt(arg[1]));
        }
        HomePage homePage = new HomePage("http://truyentranhtuan.com/");
        homePage.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int shutdownTime = Integer.parseInt(arg[0]);
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
        System.exit(0);
    }

}
