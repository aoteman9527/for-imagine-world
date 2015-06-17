/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text streams.
 * Copyright (c) 2006 Alexander Hristov .
 * 
 * This library is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU Lesser General Public License as published by the Free Software Foundation; 
 * either version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this library; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 *
 */
package sample;

import org.jjcode.BundleMessageProvider;
import org.jjcode.Icon;
import org.jjcode.RenderEngine;
import org.jjcode.commands.*;
import org.jjcode.filters.IconFilter;

import java.util.Locale;

public class SampleUsage {

	public static RenderEngine engine;
	
  public static void setUp(){
  	
  	// Create the rendering engine
  	engine =  new RenderEngine();
  	
  	// Register all commands we intend to use. Order is not relevant.
  	// Instead of this whole sequence of commands, you may use simply
  	// engine.registerAll();
    engine.registerHandler(new BoldCommand());
    engine.registerHandler(new ColorCommand());
    engine.registerHandler(new ItalicCommand());
    engine.registerHandler(new MailCommand());
    engine.registerHandler(new QuoteCommand());
    engine.registerHandler(new SizeCommand());
    engine.registerHandler(new SubscriptCommand());
    engine.registerHandler(new SuperscriptCommand());
    engine.registerHandler(new UnderlineCommand());
    engine.registerHandler(new URLCommand());
    engine.registerHandler(new ImageCommand());
    engine.registerHandler(new AudioCommand());
    engine.registerHandler(new VideoCommand());
    
//    engine.registerHandler(new UnicodeFilter());
    engine.registerHandler(new IconFilter());
    
 
    
    // Set the message provider to use. In this case, we use the integrated "resource bundle" message provider 
    // which uses the JDK Resource Bundle system to extract messages 
    engine.setMessageProvider( new BundleMessageProvider("messages"));
    
    
    // Add some simleys. Make sure that the messages assigned to each one are present in the bundle 
    engine.addIcon( new Icon(":D","images/icon_biggrin.gif","core.jjcodes.icon.biggrin"));
    engine.addIcon( new Icon(":)","images/icon_smile.gif","core.jjcodes.icon.smile"));
    engine.addIcon( new Icon(":(","images/icon_sad.gif","core.jjcodes.icon.sad"));
    engine.addIcon( new Icon(":o","images/icon_surprised.gif","core.jjcodes.icon.surprised"));
    engine.addIcon( new Icon("8O","images/icon_eek.gif","core.jjcodes.icon.eek"));
    engine.addIcon( new Icon(":?","images/icon_confused.gif","core.jjcodes.icon.confused"));
    engine.addIcon( new Icon("8)","images/icon_cool.gif","core.jjcodes.icon.cool"));
    engine.addIcon( new Icon(":lol:","images/icon_lol.gif","core.jjcodes.icon.lol"));
    engine.addIcon( new Icon(":x","images/icon_mad.gif","core.jjcodes.icon.mad"));
    engine.addIcon( new Icon(":P","images/icon_razz.gif","core.jjcodes.icon.razz"));
    engine.addIcon( new Icon(":oops:","images/icon_redface.gif","core.jjcodes.icon.redface"));
    engine.addIcon( new Icon(":cry:","images/icon_cry.gif","core.jjcodes.icon.cry"));
    engine.addIcon( new Icon(":evil:","images/icon_evil.gif","core.jjcodes.icon.evil"));
    engine.addIcon( new Icon(":twisted:","images/icon_twisted.gif","core.jjcodes.icon.twisted"));
    engine.addIcon( new Icon(":roll:","images/icon_rolleyes.gif","core.jjcodes.icon.rolleyes"));
    engine.addIcon( new Icon(":wink:","images/icon_wink.gif","core.jjcodes.icon.wink"));
    engine.addIcon( new Icon(":!:","images/icon_exclaim.gif","core.jjcodes.icon.exclaim"));
    engine.addIcon( new Icon(":?:","images/icon_question.gif","core.jjcodes.icon.question"));
    engine.addIcon( new Icon(":idea:","images/icon_idea.gif","core.jjcodes.icon.idea"));
    engine.addIcon( new Icon(":arrow:","images/icon_arrow.gif","core.jjcodes.icon.arrow"));
  }
  
	public static void main(String[] args) {
		setUp();
		
		String sampleText = "Hello :-) \n "+
										    "This is a [b]sample[/b] text illustrating how to use "+
										    "the [url=http://www.sourceforge.net/jjcode]jjCode[/url] library\n";
		
		String filtered = engine.render(sampleText,RenderEngine.MODE_RENDER,Locale.US);
		
		System.out.println(filtered);

	}

}
