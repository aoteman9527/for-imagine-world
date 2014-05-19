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
 * This class implements the [email] bbcode sequence. This sequence is used to insert mailto: links inside the text. <br/><br/>
 * <b>Syntax</b>: <code>[email=<i>mail address</i>] link contents [/email] </code> <br/></br>
 * <b>Example</b>:<code> [email=me@ahristov.com] Click here to email me [/email] <br/><br/></code>
 * <b>Contents</b>: The [email] command allows any kind of contents <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.email<br/>
 * core.jjcodes.email.help<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeLink </code> <br/><br/> 
 * <b>Pre-processed</b>: Yes 
 * @author Alexander Hristov
 *
 */
public class MailCommand extends RenderCommand {
  public boolean recognized(String token) {
    return token.startsWith("[email");
  }

  public StringBuffer render(Node node, int mode, HashMap info) {
    String token = node.getValue();
    int equal = token.indexOf("=");
    String addr = node.getText().toString();
    if (equal != -1)
      addr = token.substring(equal+1,token.length()-1);

    StringBuffer sb = new StringBuffer();
    sb.append("<a href='mailto:");
    sb.append(addr);
    sb.append("' class='");
    sb.append(linkClassName);
    sb.append("'>");
    sb.append(renderChildren(node,mode,info));
    sb.append("</a>");
    return sb;
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
  	return renderButtonControl("email","email.help","[email=]","[/email]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return true;
	}

}
