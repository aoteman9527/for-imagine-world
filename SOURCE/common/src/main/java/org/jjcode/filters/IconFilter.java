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
package org.jjcode.filters;

import java.util.HashMap;
import java.util.Iterator;

import org.jjcode.Icon;
import org.jjcode.MessageProvider;
import org.jjcode.RenderFilter;


/**
 * This class implements the icon filter - which transform predefined sequences like :-), :-O, etc...
 * to inline icons.
 * 
 * @author Alexander Hristov
 *
 */
public class IconFilter extends RenderFilter {
	protected String iconClass = "jjCodeIcon";

  private String renderIcons(String text, HashMap info) {
  	MessageProvider mp = engine.getMessageProvider();
  	Iterator it = engine.getIcons().iterator();
  	while (it.hasNext()) {
	    Icon icon = engine.getIcon((String)it.next());
	    StringBuffer sb = new StringBuffer();
	    sb.append("<img class='");
	    sb.append(iconClass);
	    sb.append("' src='");
	    sb.append(icon.getURL());
	    sb.append("' alt='");
	    sb.append(mp.getMessage(info,icon.messageKey));
	    sb.append("' title='");
	    sb.append(mp.getMessage(info,icon.titleKey));
	    sb.append("'/>");
      text = replaceAll(text, icon.id,sb.toString());
    }
    return text;
  }

  public StringBuffer render(StringBuffer contents, HashMap info) {
    return new StringBuffer( renderIcons( contents.toString(), info));
  }

	public boolean preProcessingAllowed() {
		return false;
	}

}



