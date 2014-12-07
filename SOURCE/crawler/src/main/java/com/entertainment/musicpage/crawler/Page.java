package com.entertainment.musicpage.crawler;

import org.jsoup.nodes.Document;

public class Page {
	private String link;
	private Document pageObtainLink;

	public Page() {
	}

	public Page(String link, Document pageObtainLink) {
		this.link = link;
		this.pageObtainLink = pageObtainLink;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Document getPageObtainLink() {
		return pageObtainLink;
	}

	public void setPageObtainLink(Document pageObtainLink) {
		this.pageObtainLink = pageObtainLink;
	}

}
