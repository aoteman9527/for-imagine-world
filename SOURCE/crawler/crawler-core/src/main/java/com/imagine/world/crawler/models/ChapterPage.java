package com.imagine.world.crawler.models;

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
        //enable javascript for this
        webClient.getOptions().setJavaScriptEnabled(true);
    }

    @Override
    public void run() {
    /**
     * Title = [TRUYEN][TEN TRUYEN][CHAPTER_NAME]
     */

        try {
            System.out.println("Crawl chapter "+this.url);
            HtmlPage page = webClient.getPage(this.url);
            String pageAsXml = page.asXml();
            Document document = Jsoup.parse(pageAsXml);
            Elements elements = document.select("div[id=viewer]");
            String commicName=document.select("div[id=read-title] a").text();
            String comicChapterName=document.select("div[id=read-title] p").text();
            System.out.println("-----------------------------");
            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append(String.format("<input type=\"hidden\" name=\"source\" value=\"%s\">",this.url));
            String reloadImageScript= "<style type=\"text/css\"> #originalWebsite{position:absolute; z-index:-11; top:0px; left:0px;}</style>\n" +
                    "\n" +
                    "<iframe id=\"originalWebsite\" name=\"originalWebsite\" src=\"http://truyentranhtuan.com\" frameborder=\"0\" scrolling=\"yes\" height=\"100%\" width=\"100%\"></iframe>\n" +
                    "<script>\n" +
                    "document.getElementsByName('originalWebsite')[0].onload = function() {\n" +
                    "     frames[0].location = '__URL_CHAPTER__'\n" +
                    "     document.getElementsByName('originalWebsite')[0].onload = null;\n" +
                    "}\n" +
                    "var id=setInterval(function(){jQuery(\"img\").each(function(index){img=jQuery(this); var src=img.attr('src'); img.attr('src', src);})},3000)\n" +
                    "</script>";
            stringBuffer.append(reloadImageScript.replace("__URL_CHAPTER__",this.url));
            stringBuffer.append(elements);
            this.sendMail(String.format("[TRUYEN][%s][%s]",commicName,comicChapterName),stringBuffer.toString());
            sqliteDAO.insertChapter(page.getUrl().toString(),page.getTitleText());

        } catch (IOException e){
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
