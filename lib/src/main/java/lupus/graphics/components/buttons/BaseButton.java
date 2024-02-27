// Package Declaration
package lupus.graphics.components.buttons;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
// ---
import lupus.graphics.Position;
import lupus.graphics.components.Node;
import lupus.graphics.WidgetStyle.WidgetType;
// ---

// ----------------------------------------------------------------

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
    private boolean _isHovered = (this.getProperty("input.isHovered") == null) ? false : true;

    // Constructor
    public BaseButton() {
        // Only listen for input if at the top of the tree
        if (this.getParentNode() == null) {
            // Set the event mask
            this.listenFor(BaseButton.ID_MOUSE_EVENT_MASK, BaseButton.ID_MOUSE_MOTION_EVENT_MASK);
        }

        // Set style info
        this.setWidgetType(WidgetType.BUTTON);

        // Set default colors
        this.setBorderColor(new Color(0, 0, 0));
        this.setFillColor(new Color(145, 150, 150));
        this.setHoverColor(new Color(175, 180, 180));
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Triggered when the button is {@code pressed}.
     *
     * @param event - The {@link MouseEvent} object
     * @see {@link MouseEvent}
     * @return {@link void}
     */
    public void onPressed(final MouseEvent event) {
        // Early return
        return;
    }

    /**
     * Triggered when the button is {@code hovered}.
     *
     * @param event - The {@link MouseEvent} object
     * @see {@link MouseEvent}
     * @return {@link void}
     */
    public void onHovered(final MouseEvent event) {
        // Early return
        return;
    }

    /**
     * Triggered when the button is {@code un-hovered}.
     *
     * @param event - The {@link MouseEvent} object
     * @see {@link MouseEvent}
     * @return {@link void}
     */
    public void onUnHovered(final MouseEvent event) {
        // Early return
        return;
    }

    /**
     * Triggered when the button is {@code clicked}.
     *
     * @param event - The {@link MouseEvent} object
     * @see {@link MouseEvent}
     * @return {@link void}
     */
    public void onClicked(final MouseEvent event) {
        // Early return
        return;
    }

    /**
     * Triggered when the button is {@code released}.
     *
     * @param event - The {@link MouseEvent} object
     * @see {@link MouseEvent}
     * @return {@link void}
     */
    public void onReleased(final MouseEvent event) {
        // Early return
        return;
    }

    /**
     * Overridden input event. Used to call individual {@code onXYZ( ... )} events.
     *
     * @return {@link void}
     */
    @Override
    public void input(final AWTEvent event) {
        // Convert to MouseEvent
        final MouseEvent mouseEvent = (MouseEvent) event;

        // Get the mouse position
        final Position mousePosition = new Position(mouseEvent.getX(), mouseEvent.getY());

        // Bounds checking
        final boolean withinXBounds = ((mousePosition.getX() >= this.getPosition().getX())
                && (mousePosition.getX() <= (this.getPosition().getX() + this.getSize().getX())));
        final boolean withinYBounds = ((mousePosition.getY() >= this.getPosition().getY())
                && (mousePosition.getY() <= (this.getPosition().getY() + this.getSize().getY())));
        final boolean withinXYBounds = (withinXBounds && withinYBounds);

        // Pass the input to its' child nodes
        for (Node node : this.getChildrenNodes()) {
            // Call input
            node.input(mouseEvent);
        }

        // Check if the mouse is within the bounds
        if (withinXYBounds == true) {
            // Set hovered value
            this._isHovered = true;

            // Set hovered property
            this.setProperty("input.isHovered", this._isHovered);

            // Call hovered
            this.onHovered(mouseEvent);
        }

        if (withinXYBounds == false && this._isHovered == true) {
            // Set hovered value
            this._isHovered = false;

            // Set hovered property
            this.setProperty("input.isHovered", this._isHovered);

            // Call unHovered
            this.onUnHovered(mouseEvent);
        }
    }

    // Private Static Methods

    // Private Inherited Methods
}
