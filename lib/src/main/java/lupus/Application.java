// Package Declaration
package lupus;

// Import Statements
// ----------------------------------------------------------------
import java.lang.RuntimeException;
import java.lang.IllegalStateException;
// ---
import lupus.core.LupusApp;
import lupus.core.LupusRuntime;
import lupus.core.LupusRuntimeLauncher;
// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * An abstract {@link Application} class. Must be inherited by your
 * application's {@code Main} class.
 *
 * <pre>
 * // Example usage
 * public class MyClass extends Application { ... }
 * </pre>
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public abstract class Application {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables

    // Constructor

    // Public Static Methods
    /**
     * Launches a new {@link LupusRuntime} instance.
     *
     * <pre>
     * // Example usage
     * public static void main(String[] args) {
     *     MyClass.launchApp(MyClass.class, args);
     * }
     * </pre>
     *
     * @param appClassReference - A reference to the inheriting {@link Application}
     *                          class
     * @param args              - Command line arguments
     * @throws IllegalStateException if the {@link LupusRuntimeLauncher} was invoked
     *                               again after running {@code launchApp}
     *
     * @throws RuntimeException      if the {@link LupusRuntime} runs into an
     *                               unexpected error while running
     * @return {@link void}
     */
    public static void launchApp(final Class<? extends Application> appClassReference, final String[] args)
            throws IllegalStateException, RuntimeException {
        // Launch the Application
        LupusRuntimeLauncher.launchAppImpl(appClassReference, args);
    }

    // Public Inherited Methods
    /**
     * The {@code main} method for your application.
     *
     * @param app - Lupus API object
     * @return {@link void}
     */
    public void start(final LupusApp app) {
        // Early return
        return;
    }

    // Private Static Methods

    // Private Inherited Methods
}
