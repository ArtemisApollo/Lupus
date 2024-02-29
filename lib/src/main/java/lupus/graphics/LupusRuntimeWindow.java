// Package Declaration
package lupus.graphics;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;
// ---
import lupus.core.LupusApp;
import lupus.utils.LupusMath;
import lupus.graphics.Position;
import lupus.graphics.WidgetStyle;
import lupus.graphics.components.Node;
import lupus.core.LupusApp.LupusWindow;
// ---

// ----------------------------------------------------------------

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
    public static final int _MAXIMIN_Z_LEVEL = 2;

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

        // Instance a new PixelBufferArray
        this._pixelBufferArray = new Pixel[this._windowHeight][this._windowWidth][LupusRuntimeWindow._MAXIMIN_Z_LEVEL];

        // Debugging: Fill buffer with specific pixel
        // this._fillPixelBufferArray(new Pixel(125, 125, 220));

        // Fill with empty white pixels
        this._fillPixelBufferArray();

        // Instance a new node tree
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
     * @implNote This method will invoke {@code setWindowVisibilityImpl}.
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

        // Register with the event queue
        component.attachToEventQueue();

        // Update the node tree
        this._updateTree();
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

    /**
     * Overridden from {@link Canvas} class. Handles the drawing portion of
     * {@code Lupus}.
     *
     * @return {@link void}
     */
    @Override
    public void paint(final Graphics graphicsReference) {
        // Debugging
        System.out.println("Clearing screen!");

        // Clear the screen
        graphicsReference.clearRect(0, 0, this._windowWidth, this._windowHeight);

        // Debugging
        System.out.println("Update node tree");

        // Update the node tree
        this._updateTree();

        // Debugging
        System.out.println("Drawing...");

        // Iterate through the Z buffer starting at 0
        for (int zIndex = 0; zIndex < this._getZBufferLength(); zIndex++) {
            // Declare and set pixel difference
            int pixelDifferenceX = -1;
            int pixelDifferenceY = -1;

            // Declare and set start positions
            int startPositionX = 1;
            int startPositionY = 0;

            // Iterate through the Y buffer starting at 0
            for (int yIndex = startPositionY; yIndex < this._getYBufferLength(); yIndex++) {

                // Iterate through the X buffer starting at 1
                for (int xIndex = startPositionX; xIndex < this._getXBufferLength(); xIndex++) {
                    // Get the current pixel at xIndex
                    final Pixel currentPixel = this._pixelBufferArray[yIndex][xIndex][zIndex];

                    // Get the previous pixel at xIndex - 1
                    final Pixel previousPixel = this._pixelBufferArray[yIndex][(xIndex - 1)][zIndex];

                    // Check if either pixel is null
                    if (currentPixel == null || previousPixel == null) {
                        // Skip to next pixel
                        continue;
                    }

                    // Conditionals
                    final boolean isCurrentPixelEqualToPreviousPixel = currentPixel.equals(previousPixel);
                    final boolean isGreaterThanOrEqualToXDifference = (pixelDifferenceX == -1) ? false
                            : (xIndex >= pixelDifferenceX);
                    final boolean isLessThanXDifference = (pixelDifferenceX == -1) ? false
                            : (xIndex < pixelDifferenceX);

                    // Check conditional
                    if (isCurrentPixelEqualToPreviousPixel == true && isGreaterThanOrEqualToXDifference == false) {
                        // Skip to next pixel
                        continue;
                    }

                    // Set the new pixel deference position
                    pixelDifferenceX = (pixelDifferenceX == -1) ? xIndex : pixelDifferenceX;
                    pixelDifferenceY = (pixelDifferenceY == -1) ? yIndex : pixelDifferenceY;

                    // Check if the current xIndex is less than the pixel difference
                    if (isGreaterThanOrEqualToXDifference == true) {
                        // Change the Y
                        yIndex = (int) LupusMath.clamp(yIndex + 1, 0, (this._getYBufferLength() - 1));

                        // Reset the X
                        xIndex = 0;

                        // Next iteration
                        continue;
                    }

                    // Check if the current xIndex is less than the pixel difference
                    if (isLessThanXDifference == true) {
                        // Get the pixel value
                        final Color pixelValue = previousPixel.getPixelValue();

                        // Set draw color
                        graphicsReference.setColor(pixelValue);

                        // Draw
                        graphicsReference.fillRect(startPositionX, startPositionY, pixelDifferenceX, yIndex);

                        // Set the new start position
                        startPositionX = pixelDifferenceX;
                        startPositionY = pixelDifferenceY;

                        // Set the new index
                        xIndex = startPositionX;
                        yIndex = startPositionY;

                        // Reset the difference
                        pixelDifferenceX = -1;
                        pixelDifferenceY = -1;

                        // Next iteration
                        continue;
                    }
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
     * Iterates through the node tree and calls {@code _updateNode}.
     *
     * @return {@link void}
     */
    private void _updateTree() {
        // Iterate through the node tree
        for (Node node : this._nodeTree) {
            // Call _updateNode
            this._updateNode(node);
        }
    }

    /**
     * Recursively traverses through the {@code currentNode}'s node tree updating
     * and drawing each component.
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
                // Draw the button
                this._drawButton(widgetStyle, currentNode);

                // Break from case
                break;
            default:
                // Break from case by default
                break;
        }

        // Debug
        System.out.println("Component drawn!");
    }

    /**
     * Draws a {@code Button} by modifying the {@code PixelBufferArray}.
     *
     * @param widgetStyle - The {@link WidgetStyle}
     * @param currentNode - The current {@link Node}
     * @implNote Looking back at this code I still have no clue why I must start
     *           from Y {@code (WIDTH)} then go to X {@code (HEIGHT)}.
     * @return {@link void}
     */
    private void _drawButton(final WidgetStyle widgetStyle, final Node currentNode) {
        // Get the button position
        final Position buttonPosition = currentNode.getPosition();

        // Get the button size
        final Position buttonSize = currentNode.getSize();

        // Get the length on the X plane
        final int combinedX = (int) (buttonPosition.getX() + buttonSize.getX());

        // Get the length on the Y plane
        final int combinedY = (int) (buttonPosition.getY() + buttonSize.getY());

        // Create the top and bottom sides of the button
        for (int x = (int) buttonPosition.getX(); x <= combinedX && x < this._pixelBufferArray[0].length; x++) {
            // Fill in the pixel buffer
            this._pixelBufferArray[combinedY][x][widgetStyle.getZIndex()] = new Pixel(widgetStyle.getBorderColor());
            this._pixelBufferArray[(int) buttonPosition.getY()][x][widgetStyle.getZIndex()] = new Pixel(
                    widgetStyle.getBorderColor());
        }

        // Create the left and right sides of the button
        for (int y = (int) buttonPosition.getY(); y <= combinedY && y < this._pixelBufferArray.length; y++) {
            // Fill in the pixel buffer
            this._pixelBufferArray[y][combinedX][widgetStyle.getZIndex()] = new Pixel(widgetStyle.getBorderColor());
            this._pixelBufferArray[y][(int) buttonPosition.getX()][widgetStyle.getZIndex()] = new Pixel(
                    widgetStyle.getBorderColor());
        }

        // Fill the button
        for (int x = (int) (buttonPosition.getX() + 1); x < combinedX && x < this._pixelBufferArray[0].length; x++) {
            for (int y = (int) (buttonPosition.getY() + 1); y < combinedY && y < this._pixelBufferArray.length; y++) {
                // Get hovered status
                final boolean isHovered = (currentNode.getProperty("input.isHovered") == null) ? false : true;

                // Fill in the pixel buffer
                this._pixelBufferArray[y][x][widgetStyle.getZIndex()] = (isHovered == false)
                        ? new Pixel(widgetStyle.getFillColor())
                        : new Pixel(widgetStyle.getHoverColor());
            }
        }
    }

    /**
     * Returns the length of the {@code Y} buffer in the {@code pixelBufferArray}.
     *
     * @return {@link int}
     */
    private int _getYBufferLength() {
        return this._pixelBufferArray.length;
    }

    /**
     * Returns the length of the {@code X} buffer in the {@code pixelBufferArray}.
     *
     * @return {@link int}
     */
    private int _getXBufferLength() {
        return this._pixelBufferArray[0].length;
    }

    /**
     * Returns the length of the {@code Z} buffer in the {@code pixelBufferArray}.
     *
     * @return {@link int}
     */
    private int _getZBufferLength() {
        return this._pixelBufferArray[0][0].length;
    }
}
