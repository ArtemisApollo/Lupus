// Package Declaration
package lupus.graphics;

// Import Statements
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JFrame;

import lupus.core.LupusApp;
import lupus.graphics.Pixel;
import lupus.graphics.components.Node;
import lupus.core.LupusApp.LupusWindow;

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
    final int MAXIMIN_Z_LEVEL = 2;

    // Public Variables

    // Private Variables
    private int _windowWidth;
    private int _windowHeight;
    private JFrame _runtimeWindowJFrame;
    private Dimension _windowDimensions;
    private Pixel[][][] _pixelBufferArray;

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
        this._pixelBufferArray = new Pixel[this._windowHeight][this._windowWidth][this.MAXIMIN_Z_LEVEL];
        this._fillPixelBufferArray();

        // Instance a new JFrame
        this._runtimeWindowJFrame = new JFrame();

        // Set sane defaults
        this._runtimeWindowJFrame.setResizable(false);
        this._runtimeWindowJFrame.setUndecorated(false);
        this._runtimeWindowJFrame.setDefaultCloseOperation(3);
        this._runtimeWindowJFrame.setTitle("Lupus-RuntimeWindow");
        this._runtimeWindowJFrame.setPreferredSize(this._windowDimensions);

        // Add a reference to the canvas
        this._runtimeWindowJFrame.add(this);

        // Pack the frame
        this._runtimeWindowJFrame.pack();

        // Set location to center
        this._runtimeWindowJFrame.setLocationRelativeTo(null);
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Internally invokes {@code setWindowVisibilityImpl} to show the
     * {@link LupusRuntimeWindow}.
     *
     * @return {@link void}
     */
    public void start() {
        this.setWindowVisibilityImpl(true);
    }

    /**
     * Adds a given component to the UI tree.
     *
     * @param component - The component to add
     * @return {@link void}
     */
    public void addComponent(final Node component) {
        return;
    }

    /**
     * Implementation of the {@code setWindowTitle} method found in the
     * {@link LupusWindow} class.
     *
     * @param text - The new window title
     * @return {@link void}
     */
    public void setWindowTitleImpl(final String text) {
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
        this._runtimeWindowJFrame.setVisible(value);
    }

    /**
     * Implementation of the {@code setDecorated} method found in the
     * {@link LupusWindow} class.
     *
     * @param value - The new decorated state
     * @return {@link void}
     */
    public void setDecoratedImpl(final boolean value) {
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
}
