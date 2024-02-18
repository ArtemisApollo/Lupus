// Package Declaration
package lupus.graphics.components.buttons;

// Import Statements
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import lupus.graphics.Position;
import lupus.graphics.WidgetStyle;
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
        // Only listen for input if at the top of the tree
        if (this.getParentNode() == null) {
            // Set the event mask
            this.listenFor(BaseButton.ID_MOUSE_EVENT_MASK, BaseButton.ID_MOUSE_MOTION_EVENT_MASK);
        }
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
    }

    /**
     * Returns the {@link WidgetStyle} on how the current component should be drawn.
     *
     * @see {@link WidgetStyle}
     * @return {@link WidgetStyle}
     */
    public WidgetStyle draw() {
        return null;
    }

    // Private Static Methods

    // Private Inherited Methods
}
