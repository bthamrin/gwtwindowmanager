/**
 * 
 */
package org.gwm.client.impl;

import java.util.List;

import org.gwm.client.GDesktopManager;
import org.gwm.client.GInternalFrame;
import org.gwm.client.event.GInternalFrameAdapter;
import org.gwm.client.event.GInternalFrameEvent;

import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.*;

/**
 * @author Marcelo Emanoel
 * @since 18/12/2006
 */
public class GDesktopPane extends Composite implements WindowResizeListener {

    /**
     * Indicates that the entire contents of the item being dragged should
     * appear inside the desktop pane.
     */
    public static final int LIVE_DRAG_MODE = 0;

    /**
     * Indicates that an outline only of the item being dragged should appear
     * inside the desktop pane.
     */
    public static final int OUTLINE_DRAG_MODE = 1;

    private GDesktopManager desktopManager;

    private HTML centerWidget;

    private DockPanel layout;

    private MinimizedButtonBar buttonBar;
    private HorizontalPanel iconBar;

    private GInternalFrameAdapter adapter = new GInternalFrameAdapter() {
        public void internalFrameIconified(GInternalFrameEvent evt) {
            minimize(evt.getGInternalFrame());
        }
    };

    private int dragStyle;

    private GInternalFrame selectedFrame;

    public GDesktopPane() {
        initialize();
        setupUI();
        setupListeners();
    }

    private void initialize() {
        setDesktopManager(new DefaultGDesktopManager(this));
        centerWidget = new HTML();
        layout = new DockPanel();
        buttonBar = new MinimizedButtonBar(this);
        iconBar = new HorizontalPanel ();
        this.initWidget(layout);

    }

    private void setupUI() {
        this.setSize("100%", "100%");
        layout.setSize("100%", "100%");

        layout.add(centerWidget, DockPanel.CENTER);
        layout.setSize("100%", "100%");

        layout.add(buttonBar, DockPanel.SOUTH);
        layout.setCellHeight(buttonBar, "30px");

        
        layout.setStyleName("org-gwm-GDesktopPane");
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
        Icon icon = new Icon (theWindow);
        iconBar.add (icon);
        // icon.addClickListener (new ClickListener() {
            // public void onClick(Widget sender) {
            // }
        // });
        // Button theButton = makeAButtonFromAWindow(theWindow);
        // minimizedWindows.add(theButton);

    }
    
    public void iconify(GInternalFrame theWindow) {
        theWindow.hide();
        buttonBar.addWindow(theWindow);
        // Button theButton = makeAButtonFromAWindow(theWindow);
        // minimizedWindows.add(theButton);

    }

    /**
     * @return the manager
     */
    public GDesktopManager getDesktopManager() {
        return desktopManager;
    }

    /**
     * @param manager
     *            the manager to set
     */
    public void setDesktopManager(GDesktopManager manager) {
        this.desktopManager = manager;
    }

    /**
     * Add a GInternalFrame to this GDesktopPane.
     * 
     * @param internalFrame
     */
    public void addFrame(GInternalFrame internalFrame) {
        internalFrame.setParentDesktop (this);
        internalFrame.addInternalFrameListener(adapter);
        desktopManager.addGInternalFrame(internalFrame);
    }

    /**
     * Closes all GInternalFrames contained in this GDesktopPane.
     */
    public void closeAllFrames() {
        desktopManager.closeAllGInternalFrames();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gwm.client.GDesktopManager#getAllGInternalFrames()
     */
    public List getAllFrames() {
        // return desktopManager.getAllGInternalFrames();
return null;
    }

    /**
     * Gets the current "dragging style" used by the desktop pane.
     */
    public int getDragMode() {
        return this.dragStyle;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gwm.client.GDesktopManager#getSelectedFrame()
     */
    public GInternalFrame getSelectedFrame() {
        return selectedFrame;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gwm.client.GDesktopManager#setDragMode(int)
     */
    public void setDragMode(int dragMode) {
        this.dragStyle = dragMode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gwm.client.GDesktopManager#setSelectedGInternalFrame(org.gwm.client.GInternalFrame)
     */
    public void setSelectedGInternalFrame(GInternalFrame newSelectedFrame) {
        desktopManager.setSelectedGInternalFrame(newSelectedFrame);
    }

    public void onWindowResized(int width, int height) {
        buttonBar.adjustSize();
    }

    public void addInTaskBar(GInternalFrame internalFrame) {
       buttonBar.addWindow(internalFrame);
    }

    class Icon extends HorizontalPanel {

        private GInternalFrame parent;

        Icon (GInternalFrame f) {
            parent = f;
            Label l = new Label (parent.getCaption());
            Label i = new Label ("");
            i.addStyleName("icon_button");
            l.addStyleName("icon_title");
            i.addClickListener(new ClickListener() {
                public void onClick(Widget sender) {
                    // buildGui();
                }
            });
            add (i);
            add (l);
       }

       GInternalFrame getFrame() {
         return parent;
       }

    }

}
