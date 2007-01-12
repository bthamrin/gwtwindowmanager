/**
 * 
 */
package org.gwm.client.impl;

import java.util.*;

import org.gwm.client.GDesktopPane;
import org.gwm.client.GInternalFrame;
import org.gwm.client.event.GInternalFrameAdapter;
import org.gwm.client.event.GInternalFrameEvent;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.*;

/**
 * @author Marcelo Emanoel
 * @since 18/12/2006
 */
public class DefaultGDesktopPane extends DockPanel implements WindowResizeListener, GDesktopPane {

    private HTML centerWidget;
    private IconBar buttonBar;

    private GInternalFrameAdapter adapter = new GInternalFrameAdapter() {
        public void internalFrameIconified(GInternalFrameEvent evt) {
            minimize(evt.getGInternalFrame());
        }
    };

    private List frames;

    public DefaultGDesktopPane() {
        initialize();
        setupUI();
        setupListeners();
    }

    private void initialize() {
        centerWidget = new HTML();
        buttonBar = new IconBar (this);
        this.frames = new ArrayList();
    }

    private void setupUI() {
        setSize("100%", "90%");
        add(centerWidget, DockPanel.CENTER);

        add(buttonBar, DockPanel.SOUTH);
        setCellHeight(buttonBar, "30px");

        
        setStyleName("org-gwm-GDesktopPane");
    }

    private void setupListeners() {

    }

    /**
     * Create a button from the window and add it the minimized windows bar.
     * 
     * @param theWindow
     */
    private void minimize(GInternalFrame theWindow) {
        buttonBar.addWindow(theWindow);

    }

    public void maximize (GInternalFrame theWindow) {
        //TODO Auto-generated method stub
    }

        
    public void iconify(GInternalFrame theWindow) {
        theWindow.setVisible(false);
        buttonBar.addWindow(theWindow);
    }

    public void deIconify (GInternalFrame theWindow) {
        theWindow.setVisible (true);
    }

    /**
     * Add a GInternalFrame to this GDesktopPane.
     * 
     * @param internalFrame
     */
    public void addFrame(GInternalFrame internalFrame) {
        internalFrame.setParentDesktop (this);
        int spos = (frames.size() + 1) * 30;
        internalFrame.setLocation (spos, spos);
        internalFrame.addInternalFrameListener(adapter);
        frames.add (internalFrame);
    }

    /**
     * Closes all GInternalFrames contained in this GDesktopPane.
     */
    public void closeAllFrames() {
        for (int i = 0; i < frames.size(); i++) {
            ((GInternalFrame) frames.get(i)).close();
        }
    }

    /*
     * Returns a list of all frames maintained by this desktop
     * 
     */
    public List getAllFrames() {
        return frames;
    }

    public void onWindowResized(int width, int height) {
        buttonBar.adjustSize();
    }


    public GInternalFrame getSelectedFrame() {
        // TODO Auto-generated method stub
        return null;
    }

    public void removeFrame(GInternalFrame internalFrame) {
        // TODO Auto-generated method stub
        
    }

    public void setSelectedFrame(GInternalFrame newSelectedFrame) {
        // TODO Auto-generated method stub
        
    }

}
