// Package Declaration
package lupus.graphics.components;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
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
    private Color _nodeFillColor = null;
    private Color _nodeBorderColor = null;
    private WidgetType _nodeWidgetType = null;
    private final Position _nodeSize = new Position(0, 0);
    private final Position _nodePosition = new Position(0, 0);
    private final ArrayList<Node> _childrenNodes = new ArrayList<Node>();

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
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     * @return {@link Node}
     */
    public Node getChildNode(final int index) throws IndexOutOfBoundsException {
        // Get get the children node at index
        return this._childrenNodes.get(index);
    }

    /**
     * Returns all the children attached to this object.
     *
     * @return {@link Node}[]
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
     * @return {@link Node}
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
        // Set the position to the new specified location
        this._nodePosition.setPosition(new Position(x, y));
    }

    /**
     * Get the current {@link Position} of the {@link Node}. If {@code null} returns
     * the {@link Position} of its' parent.
     *
     * @return {@link Position}
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
        // Set the size to the new specified size
        this._nodeSize.setPosition(new Position(x, y));
    }

    /**
     * Returns the current size of the {@link Node}. If {@code null} returns the
     * size of its' parent.
     *
     * @return {@link Position}
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
     * Get the {@link Node}'s fill {@link Color}. If {@code null} returns the fill
     * {@link Color} of its' parent.
     *
     * @return {@link Color}
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
     * @return {@link Color}
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
     * @return {@link WidgetType}
     */
    public WidgetType getWidgetType() {
        // Return the widget type
        return this._nodeWidgetType;
    }

    /**
     * Returns the {@link WidgetStyle} for the {@link Node}.
     *
     * @return {@link WidgetStyle}
     */
    public WidgetStyle getWidgetStyle() {
        // Create a new WidgetStyle
        final WidgetStyle componentWidgetStyle = new WidgetStyle(this._nodeWidgetType);

        // Populate with data
        componentWidgetStyle.setFillColor(this._nodeFillColor);
        componentWidgetStyle.setWidgetType(this._nodeWidgetType);
        componentWidgetStyle.setBorderColor(this._nodeBorderColor);
        componentWidgetStyle.setZIndex(LupusRuntimeWindow._MAXIMIN_Z_LEVEL - 1);

        // Return
        return componentWidgetStyle;
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
