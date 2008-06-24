/*
 * Copyright (c) 2006-2007 Luciano Broussal <luciano.broussal AT gmail.com>
 * (http://www.gwtwindowmanager.org)
 * 
 * Main Contributors :
 *      Johan Vos,Andy Scholz,Marcelo Emanoel  
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwm.client.impl;

import java.util.List;

import org.gwm.client.GFrame;

import com.google.gwt.user.client.ui.Widget;

public abstract interface IconBar {

    public void addMinimizedWindow(Widget minimizedWindow);

    public void removeMinimizedWindow(Widget minimizedWindow);

    public String getTheme(String theme);

    public Widget getUI();

    public void addFrame(GFrame gframe);

    public void removeFrame(GFrame frame);
    
    public void adjustSize();
    
    public List getGFrames();
}