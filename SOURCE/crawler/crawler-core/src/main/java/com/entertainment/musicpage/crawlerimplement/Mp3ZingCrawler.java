package com.entertainment.musicpage.crawlerimplement;

import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.entertainment.musicpage.crawler.Crawler;

public class Mp3ZingCrawler extends Crawler{
	private final static Pattern FILTERS = Pattern
			.compile(".*(\\.(css|js|bmp|gif|jpe?g"
					+ "|png|tiff?|mid|mp2|mp3|mp4"
					+ "|wav|avi|mov|mpeg|ram|m4v|pdf"
					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	
	public Mp3ZingCrawler(String srcLink) {
		super(srcLink);
	}

	public void processPageFromLink(String link) {
		System.out.println(link);
	}

	@Override
	public boolean isAllowToScanInside(String link) {
		return  !FILTERS.matcher(link).matches()
				&& link.toLowerCase().contains("mp3.zing.vn");
	}

	@Override
	public String getSelector() {
		return "a[href]";
	}

	@Override
	public String getUrl(Element e) {
		return e.absUrl("href");
	}

    public static void main(String[ ]a){
        new Mp3ZingCrawler("http://mp3.zing.vn/").start();
    }

	@Override
	public void processPageFromLink(Document p) {
		// TODO Auto-generated method stub
		
	}
}
