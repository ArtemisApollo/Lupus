// Package Declaration
package lupus;

// Import Statements
import lupus.Application;
import lupus.core.LupusApp;

import org.junit.jupiter.api.Test;

// File Docstring
/**
 * Testing class.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class LupusAbstractApplicationClassTests extends Application {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables

	// Constructor

	// Public Static Methods
	public static void main(String[] args) {
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, args);
	}

	// Public Inherited Methods
	@Test
	void testLaunchAppMethod() {
		LupusAbstractApplicationClassTests.launchApp(LupusAbstractApplicationClassTests.class, new String[0]);
	}

	// Private Static Methods

	// Private Inherited Methods
}
