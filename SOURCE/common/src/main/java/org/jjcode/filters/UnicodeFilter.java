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

import org.jjcode.RenderFilter;


/**
 * This filter replaces all non-ASCII characters with their UNICODE escape sequence in HTML, and also
 * converts line feeds to the HTML <br /> new line sequence.
 *  
 * @author Alexander Hristov
 *
 */

public class UnicodeFilter extends RenderFilter {

  public StringBuffer render(StringBuffer contents, HashMap info) {
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < contents.length(); i++) {
      char c = contents.charAt(i);
      switch (c) {
        case '\n':result.append("<br />");continue;
      }
      if (c <= 127) {
        result.append(c);
        continue;
      }
      result.append("&#"+(int)c+";");
    }
    return result;
  }

	public boolean preProcessingAllowed() {
		return true;
	}


}
