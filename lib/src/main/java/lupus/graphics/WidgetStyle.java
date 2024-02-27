// Package Declaration
package lupus.graphics;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
// ---

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
    private int _zIndex;
    private Color _fillColor;
    private Color _hoverColor;
    private Color _borderColor;
    private WidgetType _widgetType;

    // Constructor
    /**
     * Instances a new {@link WidgetStyle} object.
     *
     * @return {@link WidgetStyle}
     */
    public WidgetStyle() {
        // Early return
        return;
    }

    /**
     * Instances a new {@link WidgetStyle} object of the specified
     * {@link WidgetType}.
     *
     * @param widgetType - The {@link WidgetType}
     * @return {@link WidgetStyle}
     */
    public WidgetStyle(final WidgetType widgetType) {
        // Set the widget type
        this._widgetType = widgetType;
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Sets the fill {@link Color} property.
     *
     * @param color - The fill {@link Color}
     * @return {@link void}
     */
    public void setFillColor(final Color color) {
        // Set fill color
        this._fillColor = color;
    }

    /**
     * Sets the border {@link Color} property.
     *
     * @param color - The border {@link Color}
     * @return {@link void}
     */
    public void setBorderColor(final Color color) {
        // Set border color
        this._borderColor = color;
    }

    /**
     * Sets the hover {@link Color} property.
     *
     * @param color - The hover {@link Color}
     * @return {@link void}
     */
    public void setHoverColor(final Color color) {
        // Set hover color
        this._hoverColor = color;
    }

    /**
     * Sets the {@link WidgetType}.
     *
     * @param widgetType - The {@link WidgetType}
     * @return {@link void}
     */
    public void setWidgetType(final WidgetType widgetType) {
        // Set widget type
        this._widgetType = widgetType;
    }

    /**
     * Returns the fill {@link Color} property.
     *
     * @return {@link Color}
     */
    public Color getFillColor() {
        // Return the fill color
        return this._fillColor;
    }

    /**
     * Returns the border {@link Color} property.
     *
     * @return {@link Color}
     */
    public Color getBorderColor() {
        // Return the border color
        return this._borderColor;
    }

    /**
     * Returns the hover {@link Color} property.
     *
     * @return {@link Color}
     */
    public Color getHoverColor() {
        // Return the hover color
        return this._hoverColor;
    }

    /**
     * Returns the {@link WidgetType}.
     *
     * @return {@link WidgetType}
     */
    public WidgetType getWidgetType() {
        // Return the widget tYpe
        return this._widgetType;
    }

    /**
     * Set the Z index property.
     *
     * @param index - The index
     * @return {@link void}
     */
    public void setZIndex(final int index) {
        // Set the Z index
        this._zIndex = index;
    }

    /**
     * Returns the Z index property.
     *
     * @return {@link int}
     */
    public int getZIndex() {
        // Return the Z index
        return this._zIndex;
    }
    // Private Static Methods

    // Private Inherited Methods
}
