package com.entertainment.musicpage.crawlerimplement;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawler.Crawler;
import com.entertainment.musicpage.dao.models.Album;
import com.entertainment.musicpage.dao.models.Song;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAOImpl;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAOImpl;
import com.entertainment.musicpage.daoimplement.CustomSongDAO;
import com.entertainment.musicpage.daoimplement.CustomSongDAOImpl;

public class ChiaSeNhacCrawler extends Crawler {
	private final static Pattern FILTERS = Pattern
			.compile(".*(\\.(css|js|bmp|gif|jpe?g"
					+ "|png|tiff?|mid|mp2|mp3|mp4"
					+ "|wav|avi|mov|mpeg|ram|m4v|pdf"
					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	private static Logger log = Logger.getLogger(ChiaSeNhacCrawler.class.getName());
	private CustomSongDAO customSongDao = new CustomSongDAOImpl();
	private CustomAlbumDAO customAlbumDao = new CustomAlbumDAOImpl();
	private CustomAlbumSongDAO customAlbumSongDao = new CustomAlbumSongDAOImpl();
	private String SOURCE_TYPE = "chiasenhac";
	
	public ChiaSeNhacCrawler(String srcLink) {
		super(srcLink);
	}


	public boolean isAllowToScanInside(String link) {
		return !FILTERS.matcher(link).matches()
				&& link.toLowerCase().contains("chiasenhac.com") && !link.toLowerCase().contains("download.php") ;
	}

	public String getSelector() {
		return "a[href]";
	}

	public String getUrl(Element e) {
		return e.absUrl("href");
	}

	@Override
	public void processPageFromLink(Document p) {
		String title = p.title().split("~")[0];
		String songTitle = null;
		List<Song> listSongs = null;
		List<Album> listAlbums=null;
        String uri = p.baseUri();
        log.info("process page ".concat(uri));
        if(uri.toLowerCase().contains("playlist.chiasenhac")){
        	
        	//save songs with play list style
        	Elements linksOfPlaylist = p.select("div.playlist_prv.page-dsms a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
        	for (Element l : linksOfPlaylist  ) {
        		songTitle = l.attr("title").split("Download ")[1];
        		log.info(title + " - "+ l.absUrl("href") + " - " + songTitle);
        		Integer idSong = null;
        		Integer idAlbum = null;
        		try {
					
	        		if((listSongs = customSongDao.findBySource(l.absUrl("href"))) == null){
	        			idSong = customSongDao.insertSong(songTitle, l.absUrl("href"), SOURCE_TYPE, null);
	        		}else{
	        			idSong = listSongs.get(0).getId();
	        		}
	        		
	        		if((listAlbums = customAlbumDao.findBySource(uri)) == null){
	        			idAlbum = customAlbumDao.insertAlbum(title, uri, SOURCE_TYPE, null);
	        		}else{
	        			idAlbum = listAlbums.get(0).getId();
	        		}
	        		
	        		customAlbumSongDao.insertAlbumSong(idSong, idAlbum);
	        		
	        		log.info(String.format("save data success with idSong %s idAlbum %s ", idSong.toString(),idAlbum.toString()));
	        		idSong = null;
	        		idAlbum = null;
	        		listAlbums = null;
	        		listSongs = null;
        		} catch (Exception e) {
        			log.error(String.format("error store database %s with songid %s albumid %s",e.toString(),idSong,idAlbum));
        			
        			//clear cache id to avoid delete wrong record at next iterator
        			idSong = null;
            		idAlbum = null;
				}
        		
    		}
        }
        
        Elements songLinks = p.select("a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
        Integer idSong = null;
        for (Element l : songLinks  ) {
        	try {
        		songTitle = l.attr("title").split("[dD]ownload ")[1];
        		log.info(l.absUrl("href") + " - " + songTitle);
       		if((listSongs = customSongDao.findBySource(l.absUrl("href"))) == null){
       			idSong = customSongDao.insertSong(songTitle, l.absUrl("href"), SOURCE_TYPE, null);
       			log.info(String.format("insert successful song has id %s", idSong));
       		}
        		
			} catch (Exception e) {
				log.error("error store database "+ e.toString() +" with link "+l.toString());
			}
        		
		}
	}

	public static void main(String[] args) {
		new ChiaSeNhacCrawler("http://chiasenhac.com").start();
	}
	
}
