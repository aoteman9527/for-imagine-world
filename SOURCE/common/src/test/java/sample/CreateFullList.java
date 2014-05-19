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
import org.jjcode.RenderCommand;
import org.jjcode.RenderEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/**
 * Quick and dirty class to create the full list of command sequences and their
 * rendered result. Used for generating the reference section of the web site
 * 
 * @author Alexander Hristov
 * 
 */
public class CreateFullList {
	public static RenderEngine engine;

	public static void setUp() {
		engine = new RenderEngine();
		engine.registerAll();
		
		engine.setMessageProvider( new BundleMessageProvider("messages"));

		engine.addIcon(new Icon(":D", "images/icon_biggrin.gif",
				"core.jjcodes.icon.biggrin"));
		engine.addIcon(new Icon(":oops:", "images/icon_redface.gif",
				"core.jjcodes.icon.redface"));
		engine.addIcon(new Icon(":)", "images/icon_smile.gif",
				"core.jjcodes.icon.smile"));
		engine.addIcon(new Icon(":(", "images/icon_sad.gif",
				"core.jjcodes.icon.sad"));
		engine.addIcon(new Icon(":O", "images/icon_surprised.gif",
				"core.jjcodes.icon.surprised"));
		engine.addIcon(new Icon("8O", "images/icon_eek.gif",
				"core.jjcodes.icon.eek"));
		engine.addIcon(new Icon(":?", "images/icon_confused.gif",
				"core.jjcodes.icon.confused"));
		engine.addIcon(new Icon("8)", "images/icon_cool.gif",
				"core.jjcodes.icon.cool"));
		engine.addIcon(new Icon(":lol:", "images/icon_lol.gif",
				"core.jjcodes.icon.lol"));
		engine.addIcon(new Icon(":x", "images/icon_mad.gif",
				"core.jjcodes.icon.mad"));
		engine.addIcon(new Icon(":P", "images/icon_razz.gif",
				"core.jjcodes.icon.razz"));
		engine.addIcon(new Icon(":cry:", "images/icon_cry.gif",
				"core.jjcodes.icon.cry"));
		engine.addIcon(new Icon(":evil:", "images/icon_evil.gif",
				"core.jjcodes.icon.evil"));
		engine.addIcon(new Icon(":twisted:", "images/icon_twisted.gif",
				"core.jjcodes.icon.twisted"));
		engine.addIcon(new Icon(":roll:", "images/icon_rolleyes.gif",
				"core.jjcodes.icon.rolleyes"));
		engine.addIcon(new Icon(":wink:", "images/icon_wink.gif",
				"core.jjcodes.icon.wink"));
		engine.addIcon(new Icon(":!:", "images/icon_exclaim.gif",
				"core.jjcodes.icon.exclaim"));
		engine.addIcon(new Icon(":?:", "images/icon_question.gif",
				"core.jjcodes.icon.question"));
		engine.addIcon(new Icon(":idea:", "images/icon_idea.gif",
				"core.jjcodes.icon.idea"));
		engine.addIcon(new Icon(":arrow:", "images/icon_arrow.gif",
				"core.jjcodes.icon.arrow"));

	}

	public static void main(String[] args) throws Exception {
		setUp();
		BufferedReader in = new BufferedReader(new FileReader("full_list.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("web/full_list.html"));
		String line;
		out.println("<script src='controls.js'></script>");
		out.println("<link href='styles.css' rel='stylesheet' type='text/css' />");
		out.println("<link href='jjCode.css' rel='stylesheet' type='text/css' />");
		out.println("<table width='100%' border='1' cellpadding='0' cellspacing='0'>");

		HashMap map = new HashMap();
		map.put(RenderEngine.LOCALE_KEY,Locale.US);
		out.println("<tr class='table-header'>");
		out.println("<td width='40%'>Command Sequence</td>");
		out.println("<td width='40%'>Rendering result with default CSS</td>");
		out.println("<td >Editing control</td>");
		out.println("<tr>");
		while ((line = in.readLine()) != null) {
			String fragments[] = line.split(",");
			RenderCommand cmd = engine.findHandler(fragments[0]);
			out.println("<tr>");
			out.println("<td ><pre>");
			out.println(fragments[1]);
			out.println("</pre></td>");
			out.println("<td>");
			out.println(engine.render(fragments[2], RenderEngine.MODE_RENDER,
					Locale.US));
			out.println("</td>");
			out.println("<td align='center'>");
			if (cmd != null)
				out.println(cmd.renderControl("sample","sample_help",map));
			out.println("</td>");
			out.println("</tr>");
		}
		
		
		// Now render the icons
		Set icons = engine.getIcons();
		Iterator it = icons.iterator();
		while (it.hasNext()) {
			Icon icon = engine.getIcon( (String)it.next());
			out.println("<tr>");
			out.println("<td ><pre>");
			out.println(icon.id);
			out.println("</pre></td>");
			out.println("<td>");
			out.println(engine.render(icon.id, RenderEngine.MODE_RENDER,
					Locale.US));
			out.println("</td>");
			out.println("<td>&nbsp;");
			out.println("</td>");
			out.println("</tr>");
			
		}
		

		out.println("</table>");
		out.println("<h2>Rendering control & help field</h2>");
		out.println("<form name='sampleForm' method='post' action='#'>");
		out.println("<input class='jjCodeHelp' type='text' id='sample_help' name='help' size='50'><br/>");
		out.println("<textarea rows='10' cols='60' id='sample' name='sample'></textarea>");
		out.println("</form>");
		in.close();
		out.close();

	}

}
