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


// $Id: TabWindowMover.java,v 1.8 2004/09/15 15:20:51 jesper Exp $
package net.infonode.docking;

import net.infonode.tabbedpanel.TabAdapter;
import net.infonode.tabbedpanel.TabDragEvent;
import net.infonode.tabbedpanel.TabEvent;
import net.infonode.tabbedpanel.TabbedPanel;

import javax.swing.*;

/**
 * @author $Author: jesper $
 * @version $Revision: 1.8 $
 */
class TabWindowMover extends TabAdapter {
  private DockingWindow window;
  private TabbedPanel tabbedPanel;
  private WindowDragger dragger;

  TabWindowMover(DockingWindow window, TabbedPanel tabbedPanel) {
    this.window = window;
    this.tabbedPanel = tabbedPanel;
  }

  public void tabDragged(TabDragEvent event) {
    if (dragger == null)
      dragger = new WindowDragger(((WindowTab) event.getTab()).getWindow());

    if (tabbedPanel.tabAreaContainsPoint(SwingUtilities.convertPoint(event.getTab(), event.getPoint(), tabbedPanel)))
      dragger.abort();
    else
      dragger.dragTo(SwingUtilities.convertPoint(event.getTab(), event.getPoint(), window.getRootWindow()));
  }

  public void tabDropped(TabDragEvent event) {
    if (dragger != null) {
      dragger.drop(SwingUtilities.convertPoint(event.getTab(), event.getPoint(), window.getRootWindow()));
      dragger = null;
    }
  }

  public void tabDragAborted(TabEvent event) {
    if (dragger != null) {
      dragger.abort();
      dragger = null;
    }
  }

}
