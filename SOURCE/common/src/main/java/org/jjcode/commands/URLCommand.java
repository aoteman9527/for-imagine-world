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
 * Handles the [url] command for inserting a hyperlink. <br/><br/>
 * <b>Syntax</b>: <code>[url=<i>url</i>] link text [/url] </code> <br/></br>
 * <b>Example</b>:<code> Press [url=http://www.myblog.com] here [/url] to read the full review <br/><br/></code>
 * <b>Contents</b>: The [url] command allows any kind of nested contents <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.link<br/>
 * core.jjcodes.link.help<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeLink</code> <br/><br/> 
 * <b>Pre-processed</b>: Yes 
 * 
 * @author Alexander Hristov
 *
 */
public class URLCommand extends RenderCommand {
  public boolean recognized(String token) {
    return token.startsWith("[url");
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
    sb.append("'>");
    sb.append(renderChildren(node,mode,info));
    sb.append("</a>");
    return sb;
  }

  public StringBuffer renderControl(String fieldName, String helpFieldName, HashMap info) {
  	return renderButtonControl("link","link.help","[url=http://]","[/url]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return true;
	}


}
