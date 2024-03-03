// Package Declaration
package lupus.graphics.components;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
import java.lang.Object;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
// ---
import lupus.graphics.Position;
import lupus.graphics.WidgetStyle;
import lupus.input.LupusEventListener;
import lupus.graphics.LupusRuntimeWindow;
import lupus.graphics.WidgetStyle.WidgetType;
// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * Base class for all UI components found in the Lupus framework. All UI
 * components must inherit from here first.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public abstract class Node extends LupusEventListener {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private Node _parentNode = null;
    private Position _nodeSize = null;
    private Color _nodeFillColor = null;
    private Color _nodeHoverColor = null;
    private Color _nodeBorderColor = null;
    private Position _nodePosition = null;
    private WidgetType _nodeWidgetType = null;
    private final ArrayList<Node> _childrenNodes = new ArrayList<Node>();
    private final HashMap<String, Object> _propertyMap = new HashMap<String, Object>();

    // Constructor

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Adds a child to the {@link Node}.
     *
     * @param childNode - The child node
     * @return {@link void}
     */
    public void addChildNode(final Node childNode) {
        // Set the parent node
        childNode._setParentNode(this);

        // Add to list
        this._childrenNodes.add(childNode);
    }

    /**
     * Returns the child {@link Node} at the given index.
     *
     * @param index - The index of the child
     * @throws IndexOutOfBoundsException If the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     * @return {@link Node} - The child {@link Node} at {@code index}
     */
    public Node getChildNode(final int index) throws IndexOutOfBoundsException {
        // Get get the children node at index
        return this._childrenNodes.get(index);
    }

    /**
     * Returns all the children attached to this object.
     *
     * @return {@link Node}[] - All the children {@link Node}s attached to
     *         {@code this} object
     */
    public Node[] getChildrenNodes() {
        // Create a new Node array
        Node[] returnNodes = new Node[this._childrenNodes.size()];

        // Populate with data
        returnNodes = this._childrenNodes.toArray(returnNodes);

        // Return
        return returnNodes;
    }

    /**
     * Returns the parent {@link Node} of the current {@link Node}, or {@code null}
     * if the {@link Node} lacks a parent.
     *
     * @return {@link Node} - The parent {@link Node} of {@code this} object
     */
    public Node getParentNode() {
        // Return the parent node
        return this._parentNode;
    }

    /**
     * Set the {@link Position} of the {@link Node} with the specified
     * {@link Position} object.
     *
     * @param newPosition - The new {@link Position}
     * @return {@link void}
     */
    public void setPosition(final Position newPosition) {
        // Null check
        if (this._nodePosition == null) {
            // Set position as new position
            this._nodePosition = newPosition;
        }

        // Set the position to the new position object
        this._nodePosition.setPosition(newPosition);
    }

    /**
     * Set the {@link Position} of the {@link Node} with the specified {@code X} and
     * {@code Y} values.
     *
     * @param x - The {@code X} value
     * @param y - The {@code Y} value
     * @return {@link void}
     */
    public void setPosition(final double x, final double y) {
        // Null check
        if (this._nodePosition == null) {
            // Instance a new position object
            this._nodePosition = new Position(x, y);
        }

        // Set the position to the new specified location
        this._nodePosition.setPosition(new Position(x, y));
    }

    /**
     * Get the current {@link Position} of the {@link Node}. If {@code null} returns
     * the {@link Position} of its' parent.
     *
     * @return {@link Position} - The position of this {@link Node} on the screen
     */
    public Position getPosition() {
        // Null check
        if (this._nodePosition == null && this.getParentNode() != null) {
            // Return the position of the parent node
            return this.getParentNode().getPosition();
        }

        // Return the current node position
        return this._nodePosition;
    }

    /**
     * Set the size of the {@link Node} to the new specified size.
     *
     * @param newSize - The new size
     * @return {@link void}
     */
    public void setSize(final Position newSize) {
        // Null check
        if (this._nodeSize == null) {
            // Set size as new size
            this._nodeSize = newSize;
        }

        // Set the size to the new specified size
        this._nodeSize.setPosition(newSize);
    }

    /**
     * Set the size of the {@link Node} to the specified size values.
     *
     * @param x - The size in {@code X}
     * @param y - The size in {@code Y}
     * @return {@link void}
     */
    public void setSize(final double x, final double y) {
        // Null check
        if (this._nodeSize == null) {
            // Instance a new position object
            this._nodeSize = new Position(x, y);
        }

        // Set the size to the new specified size
        this._nodeSize.setPosition(new Position(x, y));
    }

    /**
     * Returns the current size of the {@link Node}. If {@code null} returns the
     * size of its' parent.
     *
     * @return {@link Position} - The size of this {@link Node}
     */
    public Position getSize() {
        // Null check
        if (this._nodeSize == null && this.getParentNode() != null) {
            // Return the size of the parent
            return this.getParentNode().getSize();
        }

        // Return the current node size
        return this._nodeSize;
    }

    /**
     * Sets the fill {@link Color} for the {@link Node}.
     *
     * @param color - The fill {@link Color}
     * @return {@link void}
     */
    public void setFillColor(final Color color) {
        // Set the fill color
        this._nodeFillColor = color;
    }

    /**
     * Set the border {@link Color} for the {@link Node}.
     *
     * @param color - The border {@link Color}
     * @return {@link void}
     */
    public void setBorderColor(final Color color) {
        // Set the border color
        this._nodeBorderColor = color;
    }

    /**
     * Set the hover {@link Color} for the {@link Node}.
     *
     * @param color - The hover {@link Color}
     * @return {@link void}
     */
    public void setHoverColor(final Color color) {
        // Set the hover color
        this._nodeHoverColor = color;
    }

    /**
     * Get the {@link Node}'s fill {@link Color}. If {@code null} returns the fill
     * {@link Color} of its' parent.
     *
     * @return {@link Color} - The {@code fill} {@link Color} of {@code this}
     *         {@link Node}
     */
    public Color getFillColor() {
        // Null check
        if (this._nodeFillColor == null && this.getParentNode() != null) {
            // Return the fill color of the parent node
            return this.getParentNode().getFillColor();
        }

        // Return the fill color
        return this._nodeFillColor;
    }

    /**
     * Get the {@link Node}'s border {@link Color}. If {@code null} returns the
     * border {@link Color} of its' parent.
     *
     * @return {@link Color} - The {@code border} {@link Color} of {@code this}
     *         {@link Node}
     */
    public Color getBorderColor() {
        // Null check
        if (this._nodeBorderColor == null && this.getParentNode() != null) {
            // Return the border color of the parent node
            return this.getParentNode().getBorderColor();
        }

        // Return the border color
        return this._nodeBorderColor;
    }

    /**
     * Get the {@link Node}'s hover {@link Color}. If {@code null} returns the
     * hover {@link Color} of its' parent.
     *
     * @return {@link Color} - The {@code hover} {@link Color} of {@code this}
     *         {@link Node}
     */
    public Color getHoverColor() {
        // Null check
        if (this._nodeHoverColor == null && this.getParentNode() != null) {
            // Return the hover color of the parent node
            return this.getParentNode().getHoverColor();
        }

        // Return the hover color
        return this._nodeHoverColor;
    }

    /**
     * Set the {@link Node}'s {@link WidgetType}.
     *
     * @param widgetType - The widget type
     * @return {@link void}
     */
    public void setWidgetType(final WidgetType widgetType) {
        // Set the widget type
        this._nodeWidgetType = widgetType;
    }

    /**
     * Get the {@link Node}'s {@link WidgetType}.
     *
     * @return {@link WidgetType} - The {@link WidgetType} of {@code this}
     *         {@link Node}
     */
    public WidgetType getWidgetType() {
        // Return the widget type
        return this._nodeWidgetType;
    }

    /**
     * Returns the {@link WidgetStyle} for the {@link Node}.
     *
     * @return {@link WidgetStyle} - The {@link WidgetStyle} of {@code this}
     *         {@link Node}
     */
    public WidgetStyle getWidgetStyle() {
        // Create a new WidgetStyle
        final WidgetStyle componentWidgetStyle = new WidgetStyle(this._nodeWidgetType);

        // Populate with data
        componentWidgetStyle.setFillColor(this.getFillColor());
        componentWidgetStyle.setWidgetType(this.getWidgetType());
        componentWidgetStyle.setHoverColor(this.getHoverColor());
        componentWidgetStyle.setBorderColor(this.getBorderColor());
        componentWidgetStyle.setZIndex(LupusRuntimeWindow._MAXIMIN_Z_LEVEL - 1);

        // Return
        return componentWidgetStyle;
    }

    /**
     * Set a property value that can be shared and access between abstractions.
     *
     * @param key   - The key value
     * @param value - The value
     * @return {@link void}
     */
    public void setProperty(final String key, final Object value) {
        // Set key-value property
        this._propertyMap.put(key, value);
    }

    /**
     * Returns the value at the specified key value or {@code null} if not found.
     *
     * @param key - The key
     * @return {@link Object} - The {@code value} at the specified {@code key}
     */
    public Object getProperty(final String key) {
        // Return value at key
        return this._propertyMap.get(key);
    }

    // Private Static Methods

    // Private Inherited Methods
    /**
     * Sets the parent {@link Node} for the current {@link Node}.
     *
     * @param parentNode - The parent node
     * @return {@link void}
     */
    private void _setParentNode(final Node parentNode) {
        // Set the parent node
        this._parentNode = parentNode;
    }
}
