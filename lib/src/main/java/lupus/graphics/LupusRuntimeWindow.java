// Package Declaration
package lupus.graphics;

// Import Statements
// ----------------------------------------------------------------
import java.lang.Thread;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;
// ---
import lupus.core.LupusApp;
import lupus.graphics.components.Node;
import lupus.core.LupusApp.LupusWindow;
import lupus.graphics.LupusRuntimeRenderingThread;
// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * Handles the creation of the runtime window and {@link Node} tree.
 * All requests to modify the window should be done via the {@link LupusApp}
 * object. The app developer should not have to invoke methods from this class.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusRuntimeWindow extends JFrame {
    // Enums

    // Interfaces

    // Constants
    public final static int _MAXIMIN_Z_LEVEL = 2;

    // Public Variables

    // Private Variables
    private int _windowWidth;
    private int _windowHeight;
    private Dimension _windowDimensions;
    private Thread _lupusRuntimeRenderingThread;
    private LupusRuntimeRenderingThread _renderingRuntime;
    private final ArrayList<Node> _nodeTree;

    // Constructor
    /**
     * Instances a new {@link LupusRuntimeWindow} object.
     *
     * @param windowWidth  - The width of the window
     * @param windowHeight - The height of the window
     * @return {@link LupusRuntimeWindow} - A new {@link LupusRuntimeWindow} object
     */
    public LupusRuntimeWindow(final int windowWidth, final int windowHeight) {
        // Set window dimensions
        this._windowWidth = windowWidth;
        this._windowHeight = windowHeight;
        this._windowDimensions = new Dimension(this._windowWidth, this._windowHeight);

        // Instance a new node tree
        this._nodeTree = new ArrayList<Node>();

        // TODO: Fix this god awful naming
        // Instance a new lupus renderer
        this._renderingRuntime = new LupusRuntimeRenderingThread(windowWidth, windowHeight);

        // Instance a new thread
        this._lupusRuntimeRenderingThread = new Thread(this._renderingRuntime);

        // Configure the thread
        this._lupusRuntimeRenderingThread.setName("LupusRuntimeWindow-RenderingThread");

        // Testing
        final Thread updateThread = new Thread(){
            public void run() {
                while(true) {
                    _updateNodeTree();
                }
            }
        };

        updateThread.start();


        // Set sane window defaults
        this.setResizable(false);
        this.setUndecorated(false);
        this.setDefaultCloseOperation(3);
        this.setTitle("Lupus-RuntimeWindow");
        this.setPreferredSize(this._windowDimensions);

        // Add render to window
        this.add(this._renderingRuntime);
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Implementation of the {@code getVisibilityState} method found in the
     * {@link LupusWindow} class.
     *
     * @return {@link boolean} - {@link LupusRuntimeWindow}'s current visibility
     *         status
     */
    public boolean getVisibilityStateImpl() {
        // Return visibility state
        return this.isVisible();
    }

    /**
     * Implementation of the {@code start} method found in the {@link LupusWindow}
     * class.
     *
     * @implNote This method will invoke internally {@code setWindowVisibilityImpl}
     * @return {@link void}
     */
    public void startImpl() {
        // Pack the frame
        this.pack();

        // Set location to center
        this.setLocationRelativeTo(null);

        // Set visible
        this.setWindowVisibilityImpl(true);

        // Start rendering
        this._lupusRuntimeRenderingThread.start();
    }

    /**
     * Implementation of the {@code addComponent} method found in the
     * {@link LupusWindow} class.
     *
     * @param component - The component to add
     * @return {@link void}
     */
    public void addComponentImpl(final Node component) {
        // Add the component
        this._nodeTree.add(component);

        // Register with the event queue
        component.attachToEventQueue();

        // Update the node tree
        this._updateNodeTree();
    }

    /**
     * Implementation of the {@code setWindowTitle} method found in the
     * {@link LupusWindow} class.
     *
     * @param text - The new window title
     * @return {@link void}
     */
    public void setWindowTitleImpl(final String text) {
        // Set the title
        this.setTitle(text);
    }

    /**
     * Implementation of the {@code setWindowVisibility} method found in the
     * {@link LupusWindow} class.
     *
     * @param value - The new window visibility state
     * @return {@link void}
     */
    public void setWindowVisibilityImpl(final boolean value) {
        // Check if setting to visible
        if (value == true) {
            // Pack the frame
            this.pack();

            // Set visibility state
            this.setVisible(value);
        }

        // Check if setting to hidden
        if (value == false) {
            // Set visibility state
            this.setVisible(value);

            // Dispose of the current JFrame
            this.dispose();
        }
    }

    /**
     * Implementation of the {@code setDecorated} method found in the
     * {@link LupusWindow} class.
     *
     * @param value - The new decorated state
     * @return {@link void}
     */
    public void setDecoratedImpl(final boolean value) {
        // Set decorated state
        this.setUndecorated(!value);
    }

    // Private Static Methods

    // Private Inherited Methods
    /**
     * Iterates through the {@link Node} tree and calls {@code _updateNode}.
     *
     * @return {@link void}
     */
    private void _updateNodeTree() {
        // Iterate through the node tree
        for (Node node : this._nodeTree) {
            // Call _updateNode
            this._updateNode(node);
        }
    }

    /**
     * Recursively traverses through the {@code currentNode}'s {@link Node} tree
     * updating and drawing each component.
     *
     * @param currentNode - The current node of the recursive method
     * @return {@link void}
     */
    private void _updateNode(final Node currentNode) {
        // Get current node's children
        final Node[] childrenNodes = currentNode.getChildrenNodes();

        // Retrieve the current node's widget style
        final WidgetStyle widgetStyle = currentNode.getWidgetStyle();

        // Draw the node's children
        for (Node childNode : childrenNodes) {
            // Call the update method
            this._updateNode(childNode);
        }

        // Draw the component based on its widget type
        switch (widgetStyle.getWidgetType().getStringValue()) {
            case "BUTTON":
                // Draw button
                this._renderingRuntime.drawButton(widgetStyle, currentNode);

                // Break from case
                break;
            default:
                // Break from case
                break;
        }

        // Debug
        System.out.println("Component drawn!");
    }
}
