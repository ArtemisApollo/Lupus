// Package Declaration
package lupus.graphics;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Canvas;
import java.awt.Graphics;
import java.lang.Runnable;
import java.lang.Override;
// ---
import lupus.graphics.Pixel;
import lupus.graphics.components.Node;
import lupus.graphics.LupusRuntimeWindow;
// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class LupusRuntimeRenderingThread extends Canvas implements Runnable {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private Pixel[][][] _frameBufferArray;

    // Constructor
    public LupusRuntimeRenderingThread(final int windowWidth, final int windowHeight) {
        // Instance a new frame buffer
        this._frameBufferArray = new Pixel[windowHeight][windowWidth][LupusRuntimeWindow._MAXIMIN_Z_LEVEL];

        // Fill the frame buffer
        this._fillFrameBufferArray(this._frameBufferArray);
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Overridden from {@link Canvas} class. Handles the drawing portion of
     * {@code Lupus}.
     *
     * @return {@link void}
     */
    @Override
    public void paint(final Graphics graphicsReference) {
        // Early return
        return;
    }

    public void run() {
        // Get a reference to the graphics object
        final Graphics graphicsReference = this.getGraphics();

        // Forever
        while (true) {
            // Iterate through the Y index
            for (int yIndex = 0; yIndex < this._frameBufferArray.length; yIndex++) {
                // Iterate through the X index
                for (int xIndex = 0; xIndex < this._frameBufferArray[yIndex].length; xIndex++) {
                    // Iterate through the Z index
                    for (int zIndex = 0; zIndex < this._frameBufferArray[yIndex][xIndex].length; zIndex++) {
                        // Get the current pixel
                        final Pixel currentPixel = this._frameBufferArray[yIndex][xIndex][zIndex];

                        // Check if the pixel is null
                        if (currentPixel == null) {
                            // Skip to the next pixel in the buffer
                            continue;
                        }

                        // Set the draw color
                        graphicsReference.setColor(currentPixel.getPixelValue());

                        // Draw
                        graphicsReference.fillRect(xIndex, yIndex, 1, 1);
                    }
                }
            }
        }
    }

    /**
     * Draws a {@code Button} by modifying the {@code PixelBufferArray}.
     *
     * @param widgetStyle - The {@link WidgetStyle}
     * @param currentNode - The current {@link Node}
     * @implNote Looking back at this code I still have no clue why I must start
     *           from Y {@code (WIDTH)} then go to X {@code (HEIGHT)}
     * @return {@link void}
     */
    public void drawButton(final WidgetStyle widgetStyle, final Node currentNode) {
        // Get the button position
        final Position buttonPosition = currentNode.getPosition();

        // Get the button size
        final Position buttonSize = currentNode.getSize();

        // Get the length on the X plane
        final int combinedX = (int) (buttonPosition.getX() + buttonSize.getX());

        // Get the length on the Y plane
        final int combinedY = (int) (buttonPosition.getY() + buttonSize.getY());

        // Create the top and bottom sides of the button
        for (int x = (int) buttonPosition.getX(); x <= combinedX && x < this._frameBufferArray[0].length; x++) {
            // Fill in the pixel buffer
            this._frameBufferArray[combinedY][x][widgetStyle.getZIndex()] = new Pixel(widgetStyle.getBorderColor());
            this._frameBufferArray[(int) buttonPosition.getY()][x][widgetStyle.getZIndex()] = new Pixel(
                    widgetStyle.getBorderColor());
        }

        // Create the left and right sides of the button
        for (int y = (int) buttonPosition.getY(); y <= combinedY && y < this._frameBufferArray.length; y++) {
            // Fill in the pixel buffer
            this._frameBufferArray[y][combinedX][widgetStyle.getZIndex()] = new Pixel(widgetStyle.getBorderColor());
            this._frameBufferArray[y][(int) buttonPosition.getX()][widgetStyle.getZIndex()] = new Pixel(
                    widgetStyle.getBorderColor());
        }

        // Fill the button
        for (int x = (int) (buttonPosition.getX() + 1); x < combinedX && x < this._frameBufferArray[0].length; x++) {
            for (int y = (int) (buttonPosition.getY() + 1); y < combinedY && y < this._frameBufferArray.length; y++) {
                // Get hovered status
                final boolean isHovered = (currentNode.getProperty("input.isHovered") == null) ? false : true;

                // Fill in the pixel buffer
                this._frameBufferArray[y][x][widgetStyle.getZIndex()] = (isHovered == false)
                        ? new Pixel(widgetStyle.getFillColor())
                        : new Pixel(widgetStyle.getHoverColor());
            }
        }
    }

    // Private Inherited Methods
    /**
     * Fills the specified {@link Pixel}BufferArray with {@code white} {@link Pixel}
     * objects.
     *
     * @param frameBuffer - The specific frame buffer to fill
     * @return {@link void}
     */
    private void _fillFrameBufferArray(final Pixel[][][] frameBuffer) {
        // Iterate through the Y index
        for (int yIndex = 0; yIndex < frameBuffer.length; yIndex++) {
            // Iterate through the X index
            for (int xIndex = 0; xIndex < frameBuffer[yIndex].length; xIndex++) {
                // Iterate through the Z index
                for (int zIndex = 0; zIndex < frameBuffer[yIndex][xIndex].length; zIndex++) {
                    // Fill with an empty pixel
                    frameBuffer[yIndex][xIndex][zIndex] = new Pixel();
                }
            }
        }
    }

    /**
     * Fills the specified {@link Pixel}BufferArray with the specified {@link Pixel}
     * object.
     *
     * @param frameBuffer - The specific frame buffer to fill
     * @param pixel       - The {@link Pixel} object to use
     * @return {@link void}
     */
    private void _fillFrameBufferArray(final Pixel[][][] frameBuffer, final Pixel pixel) {
        // Iterate through the Y index
        for (int yIndex = 0; yIndex < frameBuffer.length; yIndex++) {
            // Iterate through the X index
            for (int xIndex = 0; xIndex < frameBuffer[yIndex].length; xIndex++) {
                // Iterate through the Z index
                for (int zIndex = 0; zIndex < frameBuffer[yIndex][xIndex].length; zIndex++) {
                    // Fill with an empty pixel
                    frameBuffer[yIndex][xIndex][zIndex] = pixel;
                }
            }
        }
    }

    // Private Static Methods

    // Private Inherited Methods
}
