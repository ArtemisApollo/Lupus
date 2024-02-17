// Package Declaration
package lupus.input;

// Import Statements
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;

// File Docstring
/**
 * A wrapping class for the {@link AWTEventListener} interface. Provides a very
 * simplified method set to handle a variety of inputs.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class LupusEventListener implements AWTEventListener {
    // Enums

    // Interfaces

    // Constants
    public static final long ID_KEY_EVENT_MASK = AWTEvent.KEY_EVENT_MASK;
    public static final long ID_MOUSE_EVENT_MASK = AWTEvent.MOUSE_EVENT_MASK;
    public static final long ID_MOUSE_MOTION_EVENT_MASK = AWTEvent.MOUSE_MOTION_EVENT_MASK;

    // Public Variables

    // Private Variables
    private long[] _listenIDs;

    // Constructor

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Registers the listener to listen for a specified event ID(s).
     *
     * @param eventID - The event ID(s) to listen for
     * @see {@link AWTEvent}
     * @return {@link void}
     */
    public void listenFor(final long... eventID) {
        // Set the listen ID
        this._listenIDs = eventID;
    }

    /**
     * Handles the receiving of queued {@link AWTEvent}s based on the current value
     * of {@code listenIDs}.
     *
     * @return {@link void}
     */
    public void eventDispatched(final AWTEvent dispatchedEvent) {
        // Get the event ID
        final long dispatchedEventID = dispatchedEvent.getID();

        // Iterate
        for (long id : this._listenIDs) {
            // Check
            if (id == dispatchedEventID) {
                // Call
                this.input(dispatchedEvent);
            }
        }
    }

    /**
     * An override able method. Called after the {@link AWTEvent} was filtered.
     *
     * @param event - The event
     * @return {@link void}
     */
    public void input(final AWTEvent event) {
        return;
    }

    // Private Static Methods

    // Private Inherited Methods
}
