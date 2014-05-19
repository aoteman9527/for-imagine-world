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
package org.jjcode;

/**
 * This class handles the parsing of data streams
 * @author Alexander Hristov
 *
 */
public class Parser {
   private int parsePos;

   
   private static String extractToken(String s, int pos) {
     char c= s.charAt(pos);
     pos++;
     StringBuffer token = new StringBuffer();
     token.append(c);
     char limitingChar = ( c == '[')?']':'[';
     while ( pos < s.length() && ( c = s.charAt(pos)) != limitingChar) {
        token.append(c);
        pos++;
      }
      if (limitingChar ==']') {
        pos++;
        token.append(']');
      }
      return token.toString();
   }

  /**
   * Parses a string and adds all resulting nodes as children of the specified parent. The parent cannot be null,
   * and must be a type of node that allows children
   * @param s
   * @param parent
   */
  public void parse(String s, Node parent) {
     while (parsePos < s.length()) {
        String token = extractToken(s,parsePos);
        parsePos += token.length();
        if (token.startsWith("[/")) {
          return;
        }
        if (token.startsWith("[")) {
          Node child = new Node(Node.TYPE_COMMAND,token);
          parent.addChild(child);
          parse(s,child);
        } else {
          Node child = new Node(Node.TYPE_LITERAL,token);
          parent.addChild(child);
        }
     }
  }
 
  /**
   * Parses a string and returns the corresponding tree
   * @param s String to be parsed
   * @return A tree representing the parsed sequence
   */ 
  public Node parse(String s) {
    parsePos = 0;
    Node root = new Node(Node.TYPE_ROOT,"");
    parse(s,root);
    return root;
  }

}
