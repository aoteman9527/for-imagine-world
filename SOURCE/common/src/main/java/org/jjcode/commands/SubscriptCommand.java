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
 * Handles the [sub] command for delimiting a region of subscript text. <br/><br/>
 * <b>Syntax</b>: <code>[sub] Subscript [/sub] </code> <br/></br>
 * <b>Example</b>:<code> H[sub]2[/sub]O <br/><br/></code>
 * <b>Contents</b>: The [sub] command allows any kind of nested contents <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.sub<br/>
 * core.jjcodes.sub.help<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton</code> <br/><br/> 
 * <b>Pre-processed</b>: Yes 
 * 
 * @author Alexander Hristov
 *
 */

public class SubscriptCommand extends RenderCommand {

  public boolean recognized(String token) {
    return  token.startsWith("[sub]");
  }

  public StringBuffer render(Node node,int mode,HashMap info) {
     return new StringBuffer("<sub>").append(renderChildren(node,mode,info)).append("</sub>");
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
  	return renderButtonControl("sub","sub.help","[sub]","[/sub]",fieldName,helpFieldName,null,null,info);
  }

	public boolean preProcessingAllowed() {
		return true;
	}


}
