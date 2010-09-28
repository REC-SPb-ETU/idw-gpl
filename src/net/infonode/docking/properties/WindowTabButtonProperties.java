/*
 * Copyright (C) 2004 NNL Technology AB
 * Visit www.infonode.net for information about InfoNode(R) 
 * products and how to contact NNL Technology AB.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, 
 * MA 02111-1307, USA.
 */


// $Id: WindowTabButtonProperties.java,v 1.9 2004/09/28 15:07:29 jesper Exp $
package net.infonode.docking.properties;

import net.infonode.gui.button.ButtonFactory;
import net.infonode.properties.propertymap.*;
import net.infonode.properties.types.BooleanProperty;
import net.infonode.properties.types.ButtonFactoryProperty;
import net.infonode.properties.types.IconProperty;
import net.infonode.properties.types.StringProperty;

import javax.swing.*;

/**
 * Properties and property values for a button in a window tab.
 *
 * @author $Author: jesper $
 * @version $Revision: 1.9 $
 */
public class WindowTabButtonProperties extends PropertyMapContainer {
  /**
   * Property group containing all window tab button properties.
   */
  public static final PropertyMapGroup PROPERTIES = new PropertyMapGroup("Window Tab Button Properties", "");

  /**
   * The button is visible.
   */
  public static final BooleanProperty VISIBLE = new BooleanProperty(PROPERTIES,
                                                                    "Visible",
                                                                    "The button is visible.",
                                                                    PropertyMapValueHandler.INSTANCE);

  /**
   * The button icon.
   */
  public static final IconProperty ICON = new IconProperty(PROPERTIES,
                                                           "Icon",
                                                           "The button icon.",
                                                           PropertyMapValueHandler.INSTANCE);

  /**
   * The button tool tip text.
   *
   * @since IDW 1.1.0
   */
  public static final StringProperty TOOL_TIP_TEXT = new StringProperty(PROPERTIES,
                                                                        "Tool Tip Text",
                                                                        "The button tool tip text.",
                                                                        PropertyMapValueHandler.INSTANCE);

  /**
   * The button factory.
   * This factory is used to create the button when it's first needed. Modifying this property will NOT cause already
   * created buttons to be replaced. The created button will be set to non-focusable and will be assigned the icon from
   * {@link #ICON} and the tool tip from {@link #TOOL_TIP_TEXT}. An action listener is also added to the button.
   *
   * @since IDW 1.1.0
   */
  public static final ButtonFactoryProperty FACTORY =
      new ButtonFactoryProperty(PROPERTIES,
                                "Factory",
                                "The button factory. This factory is used to create the button when it's first needed. " +
                                "Modifying this property will NOT cause already created buttons to be replaced. The " +
                                "created button will be set to non-focusable and will be assigned the icon from the '" +
                                ICON.getName() + "' property and the tool tip from the '" + TOOL_TIP_TEXT.getName() + "' " +
                                "property. An action listener is also added to the button.",
                                PropertyMapValueHandler.INSTANCE);


  /**
   * Creates an empty property object.
   */
  public WindowTabButtonProperties() {
    super(PROPERTIES);
  }

  /**
   * Creates a property object containing the map.
   *
   * @param map the property map
   */
  public WindowTabButtonProperties(PropertyMap map) {
    super(map);
  }

  /**
   * Creates a property object that inherit values from another property object.
   *
   * @param inheritFrom the object from which to inherit property values
   */
  public WindowTabButtonProperties(WindowTabButtonProperties inheritFrom) {
    super(PropertyMapFactory.create(inheritFrom.getMap()));
  }

  /**
   * Adds a super object from which property values are inherited.
   *
   * @param properties the object from which to inherit property values
   * @return this
   */
  public WindowTabButtonProperties addSuperObject(WindowTabButtonProperties properties) {
    getMap().addSuperMap(properties.getMap());
    return this;
  }

  /**
   * Removes the last added super object.
   *
   * @return this
   * @since IDW 1.1.0
   */
  public WindowTabButtonProperties removeSuperObject() {
    getMap().removeSuperMap();
    return this;
  }

  /**
   * Set to true if this button should be visible.
   *
   * @param visible true if this button should be visible
   * @return this
   */
  public WindowTabButtonProperties setVisible(boolean visible) {
    VISIBLE.set(getMap(), visible);
    return this;
  }

  /**
   * Returns true if this button is visible.
   *
   * @return true if this button is visible
   */
  public boolean isVisible() {
    return VISIBLE.get(getMap());
  }

  /**
   * Sets the button icon.
   *
   * @param icon the button icon
   * @return this
   */
  public WindowTabButtonProperties setIcon(Icon icon) {
    ICON.set(getMap(), icon);
    return this;
  }

  /**
   * Returns the button icon.
   *
   * @return the button icon
   */
  public Icon getIcon() {
    return ICON.get(getMap());
  }

  /**
   * Returns the button tool tip text.
   *
   * @return the button tool tip text
   * @since IDW 1.1.0
   */
  public String getToolTipText() {
    return TOOL_TIP_TEXT.get(getMap());
  }

  /**
   * Sets the button tool tip text.
   *
   * @param text the button tool tip text
   * @return this
   * @since IDW 1.1.0
   */
  public WindowTabButtonProperties setToolTipText(String text) {
    TOOL_TIP_TEXT.set(getMap(), text);
    return this;
  }

  /**
   * Gets the button factory.
   * This factory is used to create the button when it's first needed. Modifying this property will NOT cause already
   * created buttons to be replaced. The created button will be set to non-focusable and will be assigned the icon from
   * {@link #ICON} and the tool tip from {@link #TOOL_TIP_TEXT}. An action listener is also added to the button.
   *
   * @return the button factory
   * @since IDW 1.1.0
   */
  public ButtonFactory getFactory() {
    return FACTORY.get(getMap());
  }

  /**
   * Sets the button factory.
   * This factory is used to create the button when it's first needed. Modifying this property will NOT cause already
   * created buttons to be replaced. The created button will be set to non-focusable and will be assigned the icon from
   * {@link #ICON} and the tool tip from {@link #TOOL_TIP_TEXT}. An action listener is also added to the button.
   *
   * @param factory the button factory
   * @return this
   * @since IDW 1.1.0
   */
  public WindowTabButtonProperties setFactory(ButtonFactory factory) {
    FACTORY.set(getMap(), factory);
    return this;
  }

}
