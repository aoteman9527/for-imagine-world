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
 * Handles the [quote] command for delimiting a quoted text <br/><br/>
 * <b>Syntax</b>: <code>[quote=<i>name of the user who is being quoted</i>] quoted text [/quote] </code>. The user name is optional <br/></br>
 * <b>Example</b>:<code> [quote=john] you are stupid [/quote] <br/><br/></code>
 * <b>Contents</b>: The [quote] command allows any kind of nested contents <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.quote<br/>
 * core.jjcodes.quote.help<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeQuote, jjCodeQuoteName, jjCodeQuoteText</code> <br/><br/> 
 * <b>Pre-processed</b>: Yes 
 * 
 * @author Alexander Hristov
 *
 */
public class QuoteCommand extends RenderCommand {
	protected String quoteStyle = "jjCodeQuote";
	protected String quoteNameStyle = "jjCodeQuoteName";
	protected String quoteTextStyle = "jjCodeQuoteText";
	
  public boolean recognized(String token) {
    return token.startsWith("[quote");
  }

  public StringBuffer render(Node node, int mode,HashMap info) {
    String token = node.getValue().toString();
    int equal = token.indexOf("=");
    String name = "";
    if (equal != -1)
      name = token.substring(equal+1,token.length()-1);

    StringBuffer renderedBody = renderChildren(node, mode,info);
    //width='90%' cellspacing='1' cellpadding='3' border='0' align='center'
    StringBuffer sb = new StringBuffer();
    sb.append("<table class='");
    sb.append(quoteStyle);
    sb.append("'>");
    if (name.length() > 0) {
    	sb.append("<tr><td class='");
    	sb.append(quoteNameStyle);
    	sb.append("'>");
    	sb.append(name);
	    sb.append(":</td></tr>");
    }
    
    sb.append("<tr><td class='");
    sb.append(quoteTextStyle);
    sb.append("'>");
    sb.append(renderedBody);
    sb.append("</td></tr></table>");
    return sb;
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
  	return renderButtonControl("quote","quote.help","[quote]","[/quote]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return true;
	}


}
