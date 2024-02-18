// Package Declaration
package lupus.graphics;

// Import Statements

// File Docstring
/**
 * Represents a {@code (X, Y)} position on screen.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class Position {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private double _x;
    private double _y;

    // Constructor
    /**
     * Creates an empty {@link Position} object set at {@code (0, 0)}.
     *
     * @return {@link Position}
     */
    public Position() {
        // Set the X and Y position to (0, 0)
        this._x = 0;
        this._y = 0;
    }

    /**
     * Creates a new {@link Position} object set at the specified {@code X} and
     * {@code Y} position.
     *
     * @param x - The {@code x} position
     * @param y - The {@code y} position
     * @return {@link Position}
     */
    public Position(final double x, final double y) {
        // Set the X and Y position to the specified values
        this._x = x;
        this._y = y;
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Returns the {@code X} value.
     *
     * @return {@link double}
     */
    public double getX() {
        // Return the X coordinate
        return this._x;
    }

    /**
     * Returns the {@code Y} value.
     *
     * @return {@link double}
     */
    public double getY() {
        // Return the Y coordinate
        return this._y;
    }

    /**
     * Sets the {@code X} value to the specified value.
     *
     * @param value - The new {@code X} value
     * @return {@link void}
     */
    public void setX(final double value) {
        // Set the X value
        this._x = value;
    }

    /**
     * Sets the {@code Y} value to the specified value.
     *
     * @param value - The new {@code Y} value
     * @return {@link void}
     */
    public void setY(final double value) {
        // Set the Y value
        this._y = value;
    }

    // Private Static Methods

    // Private Inherited Methods
}
