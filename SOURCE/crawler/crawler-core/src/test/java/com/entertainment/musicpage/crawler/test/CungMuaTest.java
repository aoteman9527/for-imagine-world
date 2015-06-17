package com.entertainment.musicpage.crawler.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CungMuaTest extends TestCase{
	public void testCrawlCungmua() throws IOException {
		// http://www.cungmua.com/
		String url = "http://www.cungmua.com/";
		Document doc= null;
		doc = Jsoup.connect(url).get();
		Elements productNames = doc.select(".deal_name");
		for (Element l : productNames) {
			System.out.println(l.html());
		}
	}
}
