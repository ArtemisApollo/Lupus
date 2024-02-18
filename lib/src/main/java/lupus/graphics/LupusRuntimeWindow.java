// Package Declaration
package lupus.graphics;

// Import Statements
import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;
import lupus.core.LupusApp;
import lupus.core.LupusApp.LupusWindow;
import lupus.graphics.components.Node;

// File Docstring
/**
 * Handles the visual component(s) of the framework. All requests to
 * modify the window should be done via the {@link LupusApp} class. The app
 * developer should not have to invoke methods from this class.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusRuntimeWindow extends Canvas {
    // Enums

    // Interfaces

    // Constants
    private final int _MAXIMIN_Z_LEVEL = 2;

    // Public Variables

    // Private Variables
    private int _windowWidth;
    private int _windowHeight;
    private Dimension _windowDimensions;
    private Pixel[][][] _pixelBufferArray;
    private final ArrayList<Node> _nodeTree;
    private final JFrame _runtimeWindowJFrame;

    // Constructor
    /**
     * Instances a new {@link LupusRuntimeWindow} object.
     *
     * @param windowWidth  - The width of the window
     * @param windowHeight - The height of the window
     * @return {@link void}
     */
    public LupusRuntimeWindow(final int windowWidth, final int windowHeight) {
        // Set window dimensions
        this._windowWidth = windowWidth;
        this._windowHeight = windowHeight;
        this._windowDimensions = new Dimension(this._windowWidth, this._windowHeight);

        // Instance a new PixelBufferArray and fill it
        this._pixelBufferArray = new Pixel[this._windowHeight][this._windowWidth][this._MAXIMIN_Z_LEVEL];
        this._fillPixelBufferArray();

        // Instance a new UI tree
        this._nodeTree = new ArrayList<Node>();

        // Instance a new JFrame
        this._runtimeWindowJFrame = new JFrame();

        // Set sane defaults
        this._runtimeWindowJFrame.setResizable(false);
        this._runtimeWindowJFrame.setUndecorated(false);
        this._runtimeWindowJFrame.setDefaultCloseOperation(3);
        this._runtimeWindowJFrame.setTitle("Lupus-RuntimeWindow");
        this._runtimeWindowJFrame.setPreferredSize(this._windowDimensions);

        // Add a reference to the Canvas
        this._runtimeWindowJFrame.add(this);
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Implementation of the {@code getVisibilityState} method found in the
     * {@link LupusWindow} class.
     *
     * @return {@link boolean}
     */
    public boolean getVisibilityStateImpl() {
        // Return visibility state
        return this._runtimeWindowJFrame.isVisible();
    }

    /**
     * Implementation of the {@code start} method found in the {@link LupusWindow}
     * class.
     *
     * @implNote This method will invoke {@code setWindowVisibilityImpl}
     * @return {@link void}
     */
    public void startImpl() {
        // Pack the frame
        this._runtimeWindowJFrame.pack();

        // Set location to center
        this._runtimeWindowJFrame.setLocationRelativeTo(null);

        // Set visible
        this.setWindowVisibilityImpl(true);
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

        // Update
        this._update();
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
        this._runtimeWindowJFrame.setTitle(text);
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
            this._runtimeWindowJFrame.pack();

            // Set visibility state
            this._runtimeWindowJFrame.setVisible(value);
        }

        // Check if setting to hidden
        if (value == false) {
            // Set visibility state
            this._runtimeWindowJFrame.setVisible(value);

            // Dispose of the current JFrame
            this._runtimeWindowJFrame.dispose();
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
        this._runtimeWindowJFrame.setUndecorated(!value);
    }

    @Override
    // Overridden from Canvas class. Handles the drawing.
    public void paint(final Graphics graphicsReference) {
        // Clear the screen
        graphicsReference.clearRect(0, 0, this._windowWidth, this._windowHeight);

        // Iterate through the buffer
        for (int x = 0; x < this._pixelBufferArray.length; x++) {
            for (int y = 0; y < this._pixelBufferArray[x].length; y++) {
                for (int zIndex = 0; zIndex < this._pixelBufferArray[x][y].length; zIndex++) {
                    // Get the selected pixel
                    final Pixel currentPixel = this._pixelBufferArray[x][y][zIndex];

                    // Null check
                    if (currentPixel == null) {
                        continue;
                    }

                    // Get the Pixel's color value
                    graphicsReference.setColor(currentPixel.getPixelValue());

                    // Draw the Pixel
                    graphicsReference.fillRect(y, x, 1, 1);
                }
            }
        }
    }

    // Private Static Methods

    // Private Inherited Methods
    /**
     * Fills the {@link Pixel}BufferArray with white {@link Pixel} objects.
     *
     * @return {@link void}
     */
    private void _fillPixelBufferArray() {
        for (int x = 0; x < this._pixelBufferArray.length; x++) {
            for (int y = 0; y < this._pixelBufferArray[x].length; y++) {
                for (int zIndex = 0; zIndex < this._pixelBufferArray[x][y].length; zIndex++) {
                    // Fill with an empty pixel
                    this._pixelBufferArray[x][y][zIndex] = new Pixel();
                }
            }
        }
    }

    /**
     * Fills the {@link Pixel}BufferArray with the specified {@link Pixel} object.
     *
     * @param pixel - The {@link Pixel} to use
     * @return {@link void}
     */
    private void _fillPixelBufferArray(final Pixel pixel) {
        for (int x = 0; x < this._pixelBufferArray.length; x++) {
            for (int y = 0; y < this._pixelBufferArray[x].length; y++) {
                for (int zIndex = 0; zIndex < this._pixelBufferArray[x][y].length; zIndex++) {
                    // Fill with an empty pixel
                    this._pixelBufferArray[x][y][zIndex] = pixel;
                }
            }
        }
    }

    /**
     * Updates the {@link Canvas}.
     *
     * @return {@link void}
     */
    private void _update() {
        // Iterate through the UI tree
        for (Node node : this._nodeTree) {
            Toolkit.getDefaultToolkit().addAWTEventListener(node, -1);
            System.out.println(node.getClass().getName());
        }
    }
}
