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
 * This class implements the [img] bbcode sequence. This sequence is used to insert images inside the text. <br/><br/>
 * <b>Syntax</b>: <code>[img=<i>url</i>] <i> alternative text </i> [/img] </code> <br/></br>
 * <b>Example</b>:<code> [img=http://www.planetalia.com/logo.gif] Planetalia logo [/img] <br/><br/></code>
 * <b>Contents</b>: The [img] command allows only unformatted text <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.image<br/>
 * core.jjcodes.image.help<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeImage</code> <br/><br/>
 * <b>Pre-processed</b>: Yes 
 * @author Alexander Hristov
 *
 */
public class ImageCommand extends RenderCommand {
	protected String imageClass = "jjCodeImage";
	
  public boolean recognized(String token) {
    return token.startsWith("[img");
  }

  public StringBuffer render(Node node, int mode, HashMap info) {
    String token = node.getValue();
    int equal = token.indexOf("=");
    String url = node.getText().toString();
    if (equal != -1)
      url = token.substring(equal+1,token.length()-1);
    
    StringBuffer sb = new StringBuffer();
    sb.append("<img class='");
    sb.append(imageClass);
    sb.append("' src='");
    sb.append(url);
    sb.append("' alt='");
    sb.append(renderChildren(node,mode,info));
    sb.append("' />");
    return sb;
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
  	return renderButtonControl("image","image.help","[img=http://]alt-text","[/img]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return true;
	}



}