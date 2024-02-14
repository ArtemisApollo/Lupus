// Package Declaration
package lupus.graphics.components;

// Import Statements
import java.util.ArrayList;

// File Docstring
/**
 * Base class for all UI components found in the Lupus framework. All UI
 * components must inherit from here first.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public abstract class Node {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private ArrayList<Node> _childrenNodes = new ArrayList<Node>();

    // Constructor

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Adds a child to the {@link Node}.
     *
     * @param childNode - The child node
     * @return {@link void}
     */
    public void addChild(final Node childNode) {
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
    public Node getChild(final int index) throws IndexOutOfBoundsException {
        return this._childrenNodes.get(index);
    }

    /**
     * Returns all the children attached to this object.
     *
     * @return {@link Node}[]
     */
    public Node[] getChildren() {
        // Create a new Node array
        Node[] returnNodes = new Node[this._childrenNodes.size()];

        // Populate with data
        returnNodes = this._childrenNodes.toArray(returnNodes);

        // Return
        return returnNodes;
    }

    // Private Static Methods

    // Private Inherited Methods
}
