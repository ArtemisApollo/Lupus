// Package Declaration
package lupus.graphics.components;

// Import Statements
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import lupus.input.LupusEventListener;

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
