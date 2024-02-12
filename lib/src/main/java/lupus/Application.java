// Package Declaration
package lupus;

// Import Statements
import lupus.core.LupusRuntimeLauncher;

// File Docstring
/**
 * Abstract {@link Application} class
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
     * public static void main(String[] args) {
     *     MyClass.launchApp(MyClass.class, args);
     * }
     * </pre>
     *
     * @param appClassReference - A reference to the extending {@link Application}
     *                          class
     * @param args              - Command lime arguments
     * @return {@link void}
     */
    public static void launchApp(Class<? extends Application> appClassReference, String[] args) {
        // Launch the Application
        LupusRuntimeLauncher.launchAppImpl(appClassReference, args);
    }

    // Public Inherited Methods
    public void start() {
        // Code
        return;
    }

    // Private Static Methods

    // Private Inherited Methods
}
