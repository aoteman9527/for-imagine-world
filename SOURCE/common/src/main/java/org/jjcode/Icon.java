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
 * Class (but really a data structure) representing an Icon. Icons are character sequences that are
 * replaced by inline images when the data stream is rendered. Typically used for emoticons, such as
 * :-), :-O or similar.
 * 
 * @author Alexander Hristov
 *
 */

public class Icon {
	/**
	 * Unique character sequence representing this icon 
	 */
  public String id;
  
  /**
   * Image to use when replacing the character sequence
   */
  public String image;
  
  /**
   * Message key for the ALT attribute of the image
   */
  public String messageKey;
  
  /**
   * Message key for the TITLE attribute of the image
   */
  public String titleKey;
  

  /**
   * Creates a new Icon
   * @param id Character sequence representing the icon. For example, :-O
   * @param image Image to be used when replacing the character sequence
   * @param messageKey Message key to use for this icon
   */
  public Icon(String id, String image, String messageKey) {
    this.id = id;
    this.image = image;
    this.messageKey = messageKey;
    this.titleKey = messageKey;
  }

  /**
   * Retrieves the URL of the icon. By default it is the name of the image
   * @return URL of the icon
   */
  public String getURL() {
    return image;
  }
  
}
