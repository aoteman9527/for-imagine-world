/*
 * JJCode - A Java library for rendering jjCodes and similar artifacts in text
 * streams. Copyright (c) 2006 Alexander Hristov.
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 */
package org.jjcode.test;

import java.util.HashMap;

import junit.framework.TestCase;

import org.jjcode.Icon;
import org.jjcode.MessageProvider;
import org.jjcode.RenderEngine;

public class JJCodes extends TestCase {
	RenderEngine engine = new RenderEngine();
	
  public void setUp(){
  	engine.registerAll();
    //
    engine.setMessageProvider( new MessageProvider() {
    	public String getMessage(HashMap context,String messageId, Object[] params) {
				return "$"+messageId+"$";
			}
    	
    });
    
    //engine.configureRenderer(renderers);
    engine.addIcon( new Icon(":-)","smile.gif","happy"));
    engine.addIcon( new Icon(":-(","sad.gif","sad"));
    engine.addIcon( new Icon(":-O","surprised.gif","awesome"));

  }
  
  protected void check(String original, String expected) {
  	String result = engine.render(original,RenderEngine.MODE_RENDER,(HashMap)null);
  	assertEquals(expected,result);
  }
  
  public void testUnregistered() {
  	check("[blablabla]hello[/blablabla]","hello");
  	check("[blablabla]hello","hello");
  	check("[blablabla][/blablabla]","");
  	check("[blablabla]hello","hello");
  	check("[blablabla]","");
  }
  
  public void testBold() {
  	check("[b]hello[/b]","<b>hello</b>");
  	check("[b][/b]","<b></b>");
  	check("hello[/b]","hello");
  	check("[b]hello","<b>hello</b>");
  	check("[b]hello [b]there[/b] boy[/b]","<b>hello <b>there</b> boy</b>");
  }

  public void testItalic() {
  	check("[i]hello[/i]","<i>hello</i>");
  	check("[i][/i]","<i></i>");
  	check("hello[/i]","hello");
  	check("[i]hello","<i>hello</i>");
  	check("[i]hello [i]there[/i] boy[/i]","<i>hello <i>there</i> boy</i>");
  }
  
  public void testUnderline() {
  	check("[u]hello[/u]","<u>hello</u>");
  	check("[u][/u]","<u></u>");
  	check("hello[/u]","hello");
  	check("[u]hello","<u>hello</u>");
  	check("[u]hello [u]there[/u] boy[/u]","<u>hello <u>there</u> boy</u>");
  }
  
  public void testSubscript() {
  	check("[sub]hello[/sub]","<sub>hello</sub>");
  	check("[sub][/sub]","<sub></sub>");
  	check("hello[/sub]","hello");
  	check("[sub]hello","<sub>hello</sub>");
  	check("[sub]hello [sub]there[/sub] boy[/sub]","<sub>hello <sub>there</sub> boy</sub>");
  }
  
  public void testSuperscript() {
  	check("[sup]hello[/sup]","<sup>hello</sup>");
  	check("[sup][/sup]","<sup></sup>");
  	check("hello[/sup]","hello");
  	check("[sup]hello","<sup>hello</sup>");
  	check("[sup]hello [sup]there[/sup] boy[/sup]","<sup>hello <sup>there</sup> boy</sup>");
  }
  
  public void testMixed() {
    check( "[b]a[i]b[sub]c[sup]d[u]e[/u]f[/sup]g[/sub]h[/i]i[/b]j",
    		"<b>a<i>b<sub>c<sup>d<u>e</u>f</sup>g</sub>h</i>i</b>j");
    check( "[i]b[sub]c[sup]d[u]e[b]a[/b]j[/u]f[/sup]g[/sub]h[/i]",
    		"<i>b<sub>c<sup>d<u>e<b>a</b>j</u>f</sup>g</sub>h</i>");
    check( "[sub]c[sup]d[u]e[b]a[i]b[/i]h[/b]j[/u]f[/sup]g[/sub]",
    		"<sub>c<sup>d<u>e<b>a<i>b</i>h</b>j</u>f</sup>g</sub>");
    check( "[sup]d[u]e[b]a[i]b[sub]c[/sub]g[/i]h[/b]j[/u]f[/sup]",
					"<sup>d<u>e<b>a<i>b<sub>c</sub>g</i>h</b>j</u>f</sup>");
    check( "[u]e[b]a[i]b[sub]c[sup]d[/sup]f[/sup]g[/i]h[/b]j[/u]",
					"<u>e<b>a<i>b<sub>c<sup>d</sup>f</sub>g</i>h</b>j</u>");
    check( "[b]a[i]b[sub]c[sup]d[u]e[/u]j[/sup]f[/sup]g[/i]h[/b]",
					"<b>a<i>b<sub>c<sup>d<u>e</u>j</sup>f</sub>g</i>h</b>");

  }

   /*
    * This test should be run only if the Unicode filter is present
    */
  public void testText() {
  	check("Hello\nThere","Hello<br />There");
  	check("ñ","&#241;");
  }
  
  public void testColor() {
  	check("[color=red]Hello[/color]","<span style='color:red'>Hello</span>");
  	check("[color=#FFEEEE]Hello[/color]","<span style='color:#FFEEEE'>Hello</span>");
  	check("[color=rgb(10,20,30)]Hello[/color]","<span style='color:rgb(10,20,30)'>Hello</span>");
  	check("[color=]Hello[/color]","<span style='color:black'>Hello</span>");
  	check("[color=red]Hello","<span style='color:red'>Hello</span>");
  	check("Hello[/color]","Hello");
  	check("[color=red]Hello[color=white] There [/color]Boy[/color]",
  			"<span style='color:red'>Hello<span style='color:white'> There </span>Boy</span>");
  }
  
  public void testURL() {
  	check("[url=foo]link[/url]","<a target='_blank' href='foo' class='jjCodeLink'>link</a>");
  	check("[url]link[/url]","<a target='_blank' href='link' class='jjCodeLink'>link</a>");
  	check("[url]link[/url]","<a target='_blank' href='link' class='jjCodeLink'>link</a>");
  }
  
  public void testMail() {
  	check("[email]foo@bar.com[/email]","<a href='mailto:foo@bar.com' class='jjCodeLink'>foo@bar.com</a>");
  	check("[email=blabla@bar.com]foo@bar.com[/email]","<a href='mailto:blabla@bar.com' class='jjCodeLink'>foo@bar.com</a>");
  }
  
  public void testIcons() {
    // Configure some icons
    check(":-)","<img class='jjCodeIcon' src='smile.gif' alt='$happy$' title='$happy$'/>");  	
    check(":-):-)","<img class='jjCodeIcon' src='smile.gif' alt='$happy$' title='$happy$'/><img class='jjCodeIcon' src='smile.gif' alt='$happy$' title='$happy$'/>");
    check(":-(","<img class='jjCodeIcon' src='sad.gif' alt='$sad$' title='$sad$'/>");
    check(":-O","<img class='jjCodeIcon' src='surprised.gif' alt='$awesome$' title='$awesome$'/>");
  }
  
  public void testTables() {
  	check("[quote]foo[/quote]",
  			  "<table class='jjCodeQuote'><tr><td class='jjCodeQuoteText'>foo</td></tr></table>");
  	check("[quote=username]foo[/quote]",
	  "<table class='jjCodeQuote'><tr><td class='jjCodeQuoteName'>username:</td></tr><tr><td class='jjCodeQuoteText'>foo</td></tr></table>");
  	
  }

  public void testImages() {
  	check("[img=foo]text[/img]","<img class='jjCodeImage' src='foo' alt='text' />");
  	check("[img]text[/img]","<img class='jjCodeImage' src='text' alt='text' />");
  }
  
  public void testAudio() {
  	check("[audio=foo]play[/audio]","<a target='_blank' href='foo' class='jjCodeLink' title='$core.jjcodes.audio.play$' >play</a>");
  }
  
  public void testVideo() {
  	check("[video=foo]play[/video]","<a target='_blank' href='foo' class='jjCodeLink' title='$core.jjcodes.video.play$' >play</a>");
  }
  
  
}
