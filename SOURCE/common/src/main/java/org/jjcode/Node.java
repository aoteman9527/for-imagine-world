/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text
 * streams. 
 * Copyright (c) 2006 Alexander Hristov.
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

import java.util.ArrayList;

/**
 * Node represents a token from the input stream. A node can be a literal node (plain text that needs
 * no further interpretation or processing), a command node (such as [b] for bold or any other command)
 * or the root node.  
 * @author Alexander Hristov
 *
 */
public class Node {
	/**
	 * This constant marks command nodes. These nodes require processing in order to retrieve their rendered
	 * text.
	 */
  public static final int TYPE_COMMAND = 1;
  
  /**
   * This constant marks literal nodes. Literal nodes merely contain text that is returned unprocessed
   * when requested 
   */
  public static final int TYPE_LITERAL = 2;
  
  /**
   * This constant marks the root node. There is only one root node per stream, and it acts as the
   * starting point of the processing.
   */
  public static final int TYPE_ROOT = 3;
  
  /**
   * List of all children immediately below this node. The list may contain only Node objects.
   */
  protected ArrayList children = new ArrayList();
  
  /**
   * Parent of the current node. Every node except the root node must have a parent.
   */
  protected Node parent;
  
  /**
   * Type of this node. Must be one of the predefined TYPE_ constants.
   */
  protected int type;
  
  /**
   * For command nodes, the tag is the character sequence that identifies the command name. For example,
   * for a node with value [url=http://www.planetalia.com], the tag is "url"
   */
  protected String tag;
  
  /**
   * Value of the node. For text nodes, the value of the node is .   
   */
  protected String value;

  public Node(int type, String value) {
    this.type = type;
    this.value = value;
    if (type == TYPE_COMMAND) {
    	tag = value.substring(1); // Remove starting [
    	int eq = tag.indexOf("=");
    	if (eq != -1)
    		tag = tag.substring(0,eq); // Remove parameters and trailing ]
    	else
    		tag = tag.substring(0,tag.length()-1); // Remove last ]
    }
  }

  /**
   * Returns the number of available children. 
   * @return Number of children. It is always 0 for TYPE_LITERAL nodes, and may be 0 for other nodes.
   */
  public int getChildCount() { return children.size(); }
  
  /**
   * Returns the type of the current node. 
   * @return Node type. The value will be one of the TYPE_ constants
   */
  public int getType() { return type; }
  
  /**
   * Retrieves the i-th child of the current node.
   * @param i Child to retrieve, from 0 to getChildCount() - 1
   * @return i-th child. 
   */
  public Node getChild(int i) { return (Node)children.get(i); }
  
  /**
   * Returns the parent of the current node.
   * @return Parent of the current node. Guaranteed to be not null for all nodes but the root node, and
   * always null for the root node.
   */
  public Node getParent() { return parent; }
  
  /**
   * Returns the value of the current node
   * @return Value of the current node.
   */
  public String getValue() { return value; }
  
  /**
   * Appends a child to the list of children.
   * @param child Child node to be added
   */
  public void addChild(Node child) {
  	if (getType() == TYPE_LITERAL) throw new IllegalArgumentException("This node is a text node, and does not accept children");
    child.parent = this;
    children.add(child);
  }

  /**
   * Retrieves the transformed text of this node. For text nodes, the result is the text itself. For command
   * nodes, the result is the rendered subtree. 
   * @return The result of processing the current node.
   */  
  public StringBuffer getText() {
    if (type == TYPE_LITERAL) return new StringBuffer(value);
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < getChildCount(); i++) {
      sb.append( getChild(i).getText());
    }
    return sb;
  }

  /**
   * Auxiliary method for debugging the parsing process. Dumps out the current node and all its children
   * in a more-or-less hierarchical way. 
   * @param level The tab position at which to place the current node. Successive levels of children will
   * be offset from this position.
   */
  public void dump(int level) {
    for (int i = 0; i < level; i++) System.out.print("\t");
    System.out.println(type+"->"+value);
    for (int i = 0; i < getChildCount(); i++)
      getChild(i).dump(level+1);
  }
  
  /**
   * Retrieves the tag of the current node.  
   * @return For nodes of type TYPE_COMMAND, the tag of the command node. For other node types,null
   */
  public String getTag() {
  	return tag;
  }
}
