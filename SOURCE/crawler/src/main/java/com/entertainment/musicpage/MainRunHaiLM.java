package com.entertainment.musicpage;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuanlhd on 12/9/14.
 */
public class MainRunHaiLM {
    public static void main(String[] arg) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5000));

        final String url = "http://hailm.net/view/mot-po-ro-call-of-duty-head-shot-100-lan-chat";
        for (int i=0;i<4000;i++){

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start thread "+ this.toString());
                    WebClient webClient = new WebClient();
                    webClient.getOptions().setCssEnabled(false);
                    webClient.getOptions().setThrowExceptionOnScriptError(false);
                    HtmlPage page = null;
                    try {
                        page = webClient.getPage(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    String pageAsXml = page.asXml();

                    String pageAsText = page.asText();

                    webClient.closeAllWindows();
                    System.out.println("complete thread "+ this.toString());
                }
            });
            Thread.sleep(1000);
        }

        threadPoolExecutor.shutdown();

        while(!threadPoolExecutor.isTerminated()){
            Thread.sleep(5000);
            System.out.println("the system is running ");
        }

        System.out.println("Complete work view page");
    }
}
