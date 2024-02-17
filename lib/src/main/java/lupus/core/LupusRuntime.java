// Package Declaration
package lupus.core;

// Import Statements
import java.awt.Toolkit;
import java.awt.AWTEvent;
import java.lang.Exception;
import lupus.Application;
import lupus.core.LupusApp;
import lupus.input.LupusEventListener;
import lupus.graphics.LupusRuntimeWindow;

// File Docstring
/**
 * The "Core" of the Lupus framework.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusRuntime {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private String[] _commandLineArguments;
    private Application _instancedApplicationReference;
    private Class<? extends Application> _applicationClassReference;

    // Constructor
    /**
     * Instances a new {@link LupusRuntime} object.
     *
     * @param appClassReference - A reference to the inheriting {@link Application}
     *                          class
     * @param args              - Command line arguments
     * @return {@link void}
     */
    public LupusRuntime(final Class<? extends Application> appClassReference, final String[] args) {
        // Set runtime data
        this._applicationClassReference = appClassReference;
        this._commandLineArguments = args;

        // Try to create a reference to an instanced Application class
        try {
            // Instance a new Application class
            this._instancedApplicationReference = this._applicationClassReference.getConstructor((Class<?>[]) null)
                    .newInstance((Object[]) null);
        } catch (Exception ex) {
            // Handle any exceptions
            System.err.println("Runtime exception occurred!\n" + ex + "---");

            // Early return
            return;
        }
    }

    // Public Static Methods

    // Public Inherited Methods
    /**
     * Handles the starting and instancing of required components in Lupus.
     *
     * @return {@link void}
     */
    public void start() {
        // Instance the required components
        final LupusEventListener lupusEventListener = new LupusEventListener();
        final LupusRuntimeWindow lupusRuntimeWindow = new LupusRuntimeWindow(1920, 1080);

        // Create a new LupusApp object
        final LupusApp lupusApp = new LupusApp();

        // Register components
        lupusApp.registerWindowComponent(lupusRuntimeWindow);

        // Listen to ALL events
        Toolkit.getDefaultToolkit().addAWTEventListener(lupusEventListener, -1);

        // Start the required components
        // lupusRuntimeWindow.start();

        // Call the start method
        this._instancedApplicationReference.start(lupusApp);
    }

    // Private Static Methods

    // Private Inherited Methods
}
