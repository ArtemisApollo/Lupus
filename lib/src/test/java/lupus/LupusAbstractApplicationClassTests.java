// Package Declaration
package lupus;

// Import Statements
// ----------------------------------------------------------------
import java.awt.Color;
import java.lang.Override;
import java.awt.event.MouseEvent;
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
	 *
	 * @return {@link void}
	 */
	@Override
	public void start(final LupusApp app) {
		// Create a new Button node
		final Button myRootButton = new Button();

		// Create a new child Button node
		final Button myChildButton = new Button() {
			@Override
			public void onHovered(final MouseEvent mouseEvent) {
				System.out.println("The child was hovered!");
			}

			@Override
			public void onUnHovered(final MouseEvent mouseEvent) {
				System.out.println("The child was un-hovered!");
			}
		};

		// Edit some root properties
		myRootButton.setSize(250, 150);
		myRootButton.setPosition(475, 750);

		// Add child
		myRootButton.addChildNode(myChildButton);

		// Edit some child properties
		myChildButton.setSize((myChildButton.getSize().getX() - 100), (myChildButton.getSize().getY() - 50));
		myChildButton.setPosition((myChildButton.getPosition().getX() + 375), (myChildButton.getPosition().getY()));

		// Add it to the node tree
		app.window.addComponent(myRootButton);

		// Show the window
		app.show();
	}

	/**
	 * Test launchApp method.
	 *
	 * @return {@link void}
	 */
	@Test
	void testLaunchAppMethod() {
		// Launch the app
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, new String[0]);
	}

	// Private Static Methods

	// Private Inherited Methods
}
