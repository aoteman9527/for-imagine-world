package com.entertainment.musicpage.crawler.models;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.mail.EmailException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tuanlhd on 12/9/14.
 */
public class ChapterPage extends Page {
    public ChapterPage(String url) {
        super(url);
    }

    @Override
    public void run() {
    /**
     * Title = [TruyenTranh]
     */

        try {

            HtmlPage page = webClient.getPage(this.url);
            String pageAsXml = page.asXml();
            Document document = Jsoup.parse(pageAsXml);
            Elements elements = document.select("div[id=viewer]");
            System.out.println(this.url);
            System.out.println(elements);
            System.out.println("-----------------------------");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(elements);
            this.sendMail("",stringBuffer.toString());
            sqliteDAO.insertChapter(page.getTitleText(),page.getDocumentURI());

        } catch (IOException e){
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
