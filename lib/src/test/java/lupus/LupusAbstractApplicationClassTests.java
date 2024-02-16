// Package Declaration
package lupus;

// Import Statements
import java.lang.Override;
import lupus.Application;
import lupus.core.LupusApp;
import org.junit.jupiter.api.Test;

// File Docstring
/**
 * A basic testing class for getting minimal window on screen.
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
	 * The {@code Main} method. Use for running with VSCode's {@code Run Java}
	 * button.
	 *
	 * @param args - Command line arguments
	 * @return {@link void}
	 */
	public static void main(final String[] args) {
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, args);
	}

	// Public Inherited Methods
	@Override
	public void start(final LupusApp app) {
		return;
	}

	@Test
	void testLaunchAppMethod() {
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, new String[0]);
	}

	// Private Static Methods

	// Private Inherited Methods
}
