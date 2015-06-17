/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text
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
package org.jjcode.commands;
import java.util.HashMap;

import org.jjcode.Node;
import org.jjcode.RenderCommand;


/**
 * Implements the [video] bbcode sequence, which defines a link to a videoclip. <br/> 
 * This sequence is similar to the [url] sequence, but it shows a specific help message. <br/><br/>
 * <b>Syntax</b>: <code>[video=<i>url</i>] link text [/video] </code>. <br/></br>
 * <b>Example</b>:<code> [video=http://www.myplace.com/foo.mpg] Click to see it! [/video] </code><br/><br/>
 * <b>Contents</b>: The [video] command allows any kind of nested contents<br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.video<br/>
 * core.jjcodes.video.help<br/>
 * core.jjcodes.video.play<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeLink</code> <br/><br/> 
 * <b>Pre-processed</b>: No 
 * @author Alexander Hristov
 *
 */
public class VideoCommand extends RenderCommand {
  public boolean recognized(String token) {
    return token.startsWith("[video");
  }

  public StringBuffer render(Node node, int mode,HashMap info) {
    String token = node.getValue();
    int equal = token.indexOf("=");
    String url = node.getText().toString();
    if (equal != -1)
      url = token.substring(equal+1,token.length()-1);
    
    StringBuffer sb = new StringBuffer();
    sb.append("<a target='_blank' href='");
    sb.append(url);
    sb.append("' class='");
    sb.append(linkClassName);
    sb.append("' title='");
    sb.append(mp.getMessage(info,rootMessageKey+"video.play"));
    sb.append("' >");
    sb.append(renderChildren(node,mode,info));
    sb.append("</a>");
    return sb;
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
  	return renderButtonControl("video","video.help","[video=http://]","[/video]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return false;
	}


}