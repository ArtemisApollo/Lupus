// Package Declaration
package lupus;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
import java.lang.Override;
// ---
import lupus.Application;
import lupus.core.LupusApp;
import lupus.graphics.components.buttons.Button;
// ---
import org.junit.jupiter.api.Test;
// ----------------------------------------------------------------

// File Docstring
/**
 * A basic testing class for getting a minimal window on screen.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusAbstractApplicationClassTests extends Application {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables

	// Constructor

	// Public Static Methods
	/**
	 * The {@code main} method. Use for running with VSCode's {@code Run Java}
	 * button.
	 *
	 * @param args - Command line arguments
	 * @return {@link void}
	 */
	public static void main(final String[] args) {
		// Launch the app
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, args);
	}

	// Public Inherited Methods
	/**
	 * Overridden start method.
	 */
	@Override
	public void start(final LupusApp app) {
		// Create a new Button node
		final Button myRootButton = new Button();

		// Edit some properties
		myRootButton.setSize(100, 100);
		myRootButton.setPosition(200, 250);
		myRootButton.setBorderColor(new Color(0, 0, 0));
		myRootButton.setFillColor(new Color(155, 125, 220));

		// Add it to the node tree
		app.window.addComponent(myRootButton);

		// Show the window
		app.show();
	}

	/**
	 * Test launchApp method.
	 */
	@Test
	void testLaunchAppMethod() {
		// Launch the app
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, new String[0]);
	}

	// Private Static Methods

	// Private Inherited Methods
}
