package com.entertainment.musicpage.crawlerimplement;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.dao.models.Album;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAOImpl;

public class GetAlbumImageChiaSeNhac {
	public static void main(String[] args) {
		CustomAlbumDAO dao = new CustomAlbumDAOImpl();
		int index = 0;
		int limit = 30;
		List<Album> listAlbums =  null;
		while(true){
			listAlbums =  dao.findAllByLimit(index*limit, limit);
			index++;
			for (Album a : listAlbums) {
				String src = a.getSource();
				try {
					a.setUrlImage(getUrlImage(src));
					dao.update(a);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getUrlImage(String source) throws IOException{
		Document doc= null;
		doc = Jsoup.connect(source).get();
		Elements imgs =  doc.select("#fulllyric img");
		System.out.println(imgs.size());
		if(imgs.size() > 0){
			Element l = imgs.get(0);
			return l.absUrl("src");
		}else {
			return null;
		}
		
	}
}
