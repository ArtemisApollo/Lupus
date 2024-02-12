// Package Declaration
package lupus.core;

// Import Statements
import java.lang.Thread;
import java.lang.RuntimeException;
import java.lang.InterruptedException;
import java.lang.IllegalStateException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import lupus.Application;
import lupus.core.LupusRuntime;

// File Docstring
/**
 * {@link LupusRuntimeLauncher}
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class LupusRuntimeLauncher {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables
	private static AtomicBoolean isLaunched = new AtomicBoolean(false);

	// Constructor

	// Public Static Methods
	/**
	 * Implementation of the {@link LupusRuntimeLauncher}
	 *
	 * @param appClassReference - A reference to the extending {@link Application}
	 *                          class
	 * @param args              - Command line arguments
	 * @return {@link void}
	 */
	public static void launchAppImpl(Class<? extends Application> appClassReference, String[] args) {
		// Check if runtime was already launched
		if (LupusRuntimeLauncher.isLaunched.getAndSet(true) == true) {
			// Throw exception
			throw new IllegalStateException("Application was already launched and can not be launched again!");
		}

		// Create a synchronization latch
		final CountDownLatch synchronizationLatch = new CountDownLatch(1);

		// Create a new RuntimeLauncher thread
		Thread runtimeThread = new Thread(() -> {
			try {
				// Start the Core
				new LupusRuntime(appClassReference, args).start();
			} catch (Exception ex) {
				// Handle the exception
				System.err.println(ex);
			} finally {
				// Decrement the count down
				synchronizationLatch.countDown();
			}
		});

		// Configure the thread
		runtimeThread.setName("Lupus-Runtime");

		// Start the thread
		runtimeThread.start();

		// Wait for the thread to finish before returning
		try {
			// Await for the thread to exit
			synchronizationLatch.await();
		} catch (InterruptedException ex) {
			// Throw exception
			throw new RuntimeException("An exception occurred!\n" + ex);
		}
	}

	// Public Inherited Methods

	// Private Static Methods

	// Private Inherited Methods
}
