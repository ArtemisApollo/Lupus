// Package Declaration\
package lupus;

// Import Statements
import java.lang.Exception;

import lupus.Application;
import lupus.core.LupusApp;

// File Docstring
/**
 * Testing class
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class Main extends Application {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables

    // Constructor

    // Public Static Methods
    public static void main(final String[] args) throws Exception {
        launchApp(Main.class, args);
    }

    // Public Inherited Methods
    @Override
    public void start(final LupusApp app) {
        app.window.setWindowTitle("Testing Title Function");
        // app.window.setDecorated(false);
    }

    // Private Static Methods

    // Private Inherited Methods
}
