package com.imagine.world.crawler.models;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
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
            System.out.println("Crawl groupchapter "+this.url);
            HtmlPage page = webClient.getPage(this.url);
            String pageAsXml = page.asXml();
            Document document = Jsoup.parse(pageAsXml);
            Elements elements = document.select("div[id=manga-chapter] span[class=chapter-name] a");
//            System.out.println(elements);
            System.out.println("-----------------------------");
            Iterator<Element> it= elements.iterator();
            Element e;
            while(it.hasNext()){
                e=it.next();
                if(!this.isExistedChapter(e.absUrl("href"))){
                    new ChapterPage(e.absUrl("href")).start();
                }
            }
        }  catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
