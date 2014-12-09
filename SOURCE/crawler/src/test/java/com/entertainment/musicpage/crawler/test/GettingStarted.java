package com.entertainment.musicpage.crawler.test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.TestCase;

import java.io.IOException;

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
}
