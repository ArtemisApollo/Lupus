// Package Declaration
package lupus.input;

// Import Statements
import java.awt.AWTEvent;
import java.util.HashMap;
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
    private static final HashMap<Long, Integer> _MASK_TO_ID = new HashMap<Long, Integer>();

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
        // Set the listen ID(s)
        this._listenIDs = eventID;

        // Populate hashmap
        this._populateMaskToID();
    }

    /**
     * Handles the receiving of queued {@link AWTEvent}s based on the current value
     * of {@code listenID(s)}.
     *
     * @return {@link void}
     */
    public void eventDispatched(final AWTEvent dispatchedEvent) {
        // Get the event ID
        final int dispatchedEventID = dispatchedEvent.getID();

        // Debugging
        System.out.println(dispatchedEventID);

        // Iterate through all "listening for" IDs
        for (long id : this._listenIDs) {
            // Check if the current ID matches the dispatchedEvent ID
            if (this._maskToID(id) == dispatchedEventID) {
                // Call .input
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
        // Early return
        return;
    }

    // Private Static Methods

    // Private Inherited Methods
    /**
     * Contains an internal mapping of event masks to IDs. Returns the corresponding
     * ID based off the mask or {@code null} if not found.
     *
     * @param id - The event mask
     * @see {@link AWTEvent}
     * @return {@link int}
     */
    private int _maskToID(final long id) {
        return LupusEventListener._MASK_TO_ID.get(id);
    }

    /**
     * Populates the deciphering {@link HashMap} with data.
     *
     * @return {@link void}
     */
    private void _populateMaskToID() {
        // Populate
        LupusEventListener._MASK_TO_ID.put(LupusEventListener.ID_KEY_EVENT_MASK, 1);
        LupusEventListener._MASK_TO_ID.put(LupusEventListener.ID_MOUSE_EVENT_MASK, 1);
        LupusEventListener._MASK_TO_ID.put(LupusEventListener.ID_MOUSE_MOTION_EVENT_MASK, 1);
    }
}
