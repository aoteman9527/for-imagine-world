package com.entertainment.musicpage.crawler.models;

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
public class GroupChapterPage extends Page {
    public GroupChapterPage(String url) {
        super(url);
    }

    @Override
    public void run() {
        try {

            HtmlPage page = webClient.getPage(this.url);
            String pageAsXml = page.asXml();
            Document document = Jsoup.parse(pageAsXml);
            Elements elements = document.select("div[id=manga-chapter] span[class=chapter-name] a");
            System.out.println(this.url);
            System.out.println(elements);
            System.out.println("-----------------------------");

            Iterator<Element> it= elements.iterator();
            while(it.hasNext()){
                if(this.pageQueue.remainingCapacity()==0){
                    Thread.sleep(1000);
                }else{
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
