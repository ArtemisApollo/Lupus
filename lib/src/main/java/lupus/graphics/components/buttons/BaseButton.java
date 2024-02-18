// Package Declaration
package lupus.graphics.components.buttons;

// Import Statements
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import lupus.graphics.Position;
import lupus.graphics.components.Node;

// File Docstring
/**
 * Base class for all {@code Button} like components.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public abstract class BaseButton extends Node {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables

    // Constructor
    public BaseButton() {
        // Only listen if its the root parent
        if (this.getParentNode() != null) {
            return;
        }

        // Set the event mask
        this.listenFor(BaseButton.ID_MOUSE_EVENT_MASK, BaseButton.ID_MOUSE_MOTION_EVENT_MASK);
    }

    // Public Static Methods

    // Public Inherited Methods
    public void onPressed() {

    }

    public void onHovered() {

    }

    public void onClicked() {

    }

    public void onReleased() {

    }

    @Override
    public void input(final AWTEvent event) {
        // Convert to MouseEvent
        final MouseEvent mouseEvent = (MouseEvent) event;

        // Retrieve data
        final Position mousePosition = new Position(mouseEvent.getX(), mouseEvent.getY());

        // Log
        System.out.println(mousePosition.getX() + ", " + mousePosition.getY());
    }

    public void draw() {

    }

    // Private Static Methods

    // Private Inherited Methods
}
