package com.imagine.world.crawler.models;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by tuanlhd on 12/9/14.
 */
public class HomePage extends Page {

    public HomePage(String url) {
        super(url);
    }

    @Override
    public void run() {
        try {
            System.out.println("Crawl homepage "+this.url);
            HtmlPage page = webClient.getPage(this.url);
            String pageAsXml = page.asXml();
            Document document = Jsoup.parse(pageAsXml);
//            Elements elements = document.select("a[href]");
            Elements elements = document.select("div[id=new-chapter] span[class=manga easy-tooltip] a");
            System.out.println("-----------------------------");
            Iterator<Element> it= elements.iterator();
            while(it.hasNext()){
                    new GroupChapterPage(it.next().absUrl("href")).start();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
