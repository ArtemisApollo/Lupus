// Package Declaration
package lupus.graphics;

// Import Statements
// ----------------------------------------------------------------

// ---
import lupus.graphics.Position;
// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * Similar to StyleSheets in Godot, this handles the styling and look of UI
 * components.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class WidgetStyle {
    // Enums
    public enum WidgetType {
        // Enums
        BUTTON(0, "BUTTON");

        // Interfaces

        // Constants

        // Public Variables

        // Private Variables
        private int _intValue;
        private String _stringValue;

        // Constructor
        /**
         * Instances a new {@link WidgetType} object.
         *
         * @param intValue    - The {@link int} representation
         * @param stringValue - The {@link String} representation
         * @see {@link WidgetStyle}
         * @return {@link WidgetType}
         */
        private WidgetType(final int intValue, final String stringValue) {
            // Set values
            this._intValue = intValue;
            this._stringValue = stringValue;
        }

        // Public Static Methods

        // Public Inherited Methods
        /**
         * Returns the {@link int} value of the {@link WidgetType} enum.
         *
         * @return {@link int}
         */
        public int getValue() {
            // Return int value
            return this._intValue;
        }

        /**
         * Returns the {@link String} value of the {@link WidgetType} enum.
         *
         * @return {@link String}
         */
        public String getStringValue() {
            // Return string value
            return this._stringValue;
        }

        // Private Static Methods

        // Private Inherited Methods
    }

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private Position _size;
    private Position _position;
    private WidgetType _widgetType;

    // Constructor
    /**
     * Instances a new {@link WidgetStyle} object.
     *
     * @param widgetType - The {@link WidgetType}
     * @param position   - The {@link Node}'s {@link Position}
     * @param size       - The {@link Node}'s size
     * @return {@link WidgetStyle}
     */
    public WidgetStyle(final WidgetType widgetType, final Position position, final Position size) {
        // Set data
        this._size = size;
        this._position = position;
        this._widgetType = widgetType;
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Returns the {@link Node}'s {@link WidgetType}.
     *
     * @return {@link WidgetType}
     */
    public WidgetType getWidgetType() {
        // Return the widget type
        return this._widgetType;
    }

    /**
     * Returns the {@link Node}'s {@link Position}.
     *
     * @return {@link Position}
     */
    public Position getPosition() {
        // Return node position
        return this._position;
    }

    /**
     * Returns the {@link Node}'s size.
     *
     * @return {@link Position}
     */
    public Position getSize() {
        // Return node size
        return this._size;
    }

    // Private Static Methods

    // Private Inherited Methods
}
