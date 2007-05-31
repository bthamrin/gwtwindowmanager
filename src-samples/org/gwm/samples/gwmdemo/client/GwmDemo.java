/*
 * Copyright (c) 2006-2007 Luciano Broussal <luciano.broussal AT gmail.com>
 * (http://www.gwtwindowmanager.org)
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

package org.gwm.samples.gwmdemo.client;

import org.gwm.client.GDesktopPane;
import org.gwm.client.GFrame;
import org.gwm.client.GInternalFrame;
import org.gwm.client.impl.DefaultGDesktopPane;
import org.gwm.client.impl.DefaultGDialog;
import org.gwm.client.impl.DefaultGFrame;
import org.gwm.client.impl.DefaultGInternalFrame;
import org.gwm.client.util.Gwm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwmDemo implements EntryPoint {

    private static GDesktopPane desktop;

    private DefaultGInternalFrame menuFrame;

    private static GwmDemo instance;

    static VerticalPanel debugContent = new VerticalPanel();

    public static DefaultGFrame debug = new DefaultGFrame();

    public void onModuleLoad() {
//        GInternalFrame frame = new DefaultGInternalFrame();
//        Button button = new Button("click me");
//        button.addClickListener(new ClickListener(){
//
//            public void onClick(Widget arg0) {
//                Window.alert("clicked");
//                
//            }
//            
//        });
//        frame.setContent(button);
//        
//        //frame.setOutlineDragMode(false);
//        
//        desktop = new DefaultGDesktopPane();
//        desktop.addFrame(frame);
//        frame.setVisible(true);
//        frame.setLocation(100, 100);
//        
//        RootPanel.get().add((Widget)desktop);
//        
//        if(true){
//            return;
//        }
        
       // Gwm.setAppletCompliant(true);
        
//        if(true)
//        return;
        
        //Gwm.setDefaultTheme("sky");
        instance = this;
        buildUI();
        menuFrame.setSize(150, 300);
        DefaultGDialog.setDefaultTheme(Gwm.getDefaultTheme());
        Window.enableScrolling(false);
    }

    private void buildUI() {
        desktop = new DefaultGDesktopPane();
        RootPanel.get().add((Widget) desktop);
        GInternalFrame ftest = new DefaultGInternalFrame("Gwm Demo");
        ftest.setUrl("wintest.html");
        ftest.setMinimizable(false);
        ftest.setMaximizable(false);
        ftest.setClosable(false);
        ftest.setResizable(false);
        ftest.setSize(160, 700);
        desktop.addFrame(ftest);
        ftest.setLocation(0, Window.getClientWidth() - 160);
        ftest.setVisible(true);
        buildMenu();
//        GInternalFrame f = new DefaultGInternalFrame("Applet1" , true);
//        f.setContent(new HTML("<applet code='HelloWorldApplet' width='150' height='50' style='background-color:green' ><param name='bg' value='blue'></applet>"));
//        f.setContent(new HTML("<iframe src=edito.html></iframe>"));
//        f.setUrl("edito1.html");
//        desktop.addFrame(f);
//        f.setVisible(true);
//        f.setLocation(0, 0);
//        GwmUtilities.diplayAtScreenCenter(f);
//        GInternalFrame f1 = new DefaultGInternalFrame("Applet2");
//        f1.setContent(new HTML("<iframe src=edito1.html></iframe>"));
//        f1.setContent(new HTML("<applet code='HelloWorldApplet' width='150' height='50' style='background-color:green' ><param name='bg' value='blue'></applet>"));
//      f1.setUrl("edito1.html");
//        f1.setLocation(100, 200);
//        f1.setContent(new HTML("<applet code='Circle.class' width=320 height=240><param name=sleeptime value=50></applet>"));
//        desktop.addFrame(f1);
//        f1.setVisible(true);

    }

    private void buildMenu() {

        menuFrame = new DefaultGInternalFrame("Samples");
        menuFrame.setTheme("citrus");
        menuFrame.setClosable(false);
        menuFrame.setMaximizable(false);
        desktop.addFrame(menuFrame);
        menuFrame.setLocation(5, 5);
        VerticalPanel menuLayout = new VerticalPanel();
        menuLayout.setStyleName("gwmdemo-Menu");
        menuLayout.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        menuLayout.add(buildMenu("Frames"));
        menuLayout.add(buildMenuItem(new SimpleWindowWithURLScenarii()));
        menuLayout.add(buildMenuItem(new SimpleWindowWithHTMLScenarii()));
        menuLayout.add(buildMenuItem(new SimpleWindowWithWidgetScenarii()));
        menuLayout.add(buildMenu("Frame Listener"));
        menuLayout.add(buildMenuItem(new EventScenarii()));
        menuLayout.add(buildMenu("Themes"));
        menuLayout.add(buildMenuItem(new ChangingThemeInLiveScenarii()));
        menuLayout.add(buildMenu("Desktop"));
        menuLayout.add(buildMenuItem(new DesktopScenarii(desktop)));
        menuLayout.add(buildMenuItem(new MultiDesktopsScenarii()));
        menuLayout.add(buildMenu("Dialog"));
        menuLayout.add(buildMenuItem(new WarningDialogScenarii()));
        menuLayout.add(buildMenuItem(new ErrorDialogScenarii()));
        menuLayout.add(buildMenuItem(new ConfirmDialogScenarii()));
        menuLayout.add(buildMenuItem(new InputDialogScenarii()));
        menuLayout.add(buildMenuItem(new ListBoxInputDialogScenarii()));
        menuLayout.add(buildMenuItem(new CustomizedDialogScenarii()));
        menuLayout.add(buildMenu("Tools"));
        menuLayout.add(buildMenuItem(new WindowEditorScenarii()));
        menuFrame.setContent(menuLayout);
        menuFrame.setVisible(true);
    }

    private Widget buildMenu(String name) {
        HorizontalPanel menuLayout = new HorizontalPanel();
        menuLayout.setSpacing(3);
        menuLayout.add(new Label(name));
        menuLayout.setStyleName("gwmdemo-MenuSection");
        return menuLayout;
    }

    private Widget buildMenuItem(Scenarii scenarii) {
        HorizontalPanel menuItemLayout = new HorizontalPanel();
        menuItemLayout.setSpacing(2);
        menuItemLayout.add(scenarii.getLink());
        menuItemLayout.setStyleName("gwmdemo-MenuItem");
        return menuItemLayout;
    }

    public static GDesktopPane getDesktop() {
        return desktop;
    }

    public static void reset() {
        instance = null;
        RootPanel.get().clear();
        instance = new GwmDemo();
        instance.onModuleLoad();
    }

}
