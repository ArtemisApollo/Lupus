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
 * Handles the launching of a {@link LupusRuntime} instance. Assures that only
 * {@code one} instance is launched to avoid any race conditions.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusRuntimeLauncher {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables
	private static AtomicBoolean isLaunched = new AtomicBoolean(false);

	// Constructor

	// Public Static Methods
	/**
	 * Implementation of the {@code launchApp} method found in {@link Application}.
	 * Instances and starts a new {@link LupusRuntime}.
	 *
	 * @param appClassReference - A reference to the inheriting {@link Application}
	 *                          class
	 * @param args              - Command line arguments
	 * @throws IllegalStateException if the {@link LupusRuntimeLauncher} was invoked
	 *                               again after running {@code launchApp}
	 * @throws RuntimeException      if the {@link LupusRuntime} runs into an
	 *                               unexpected error while running
	 * @return {@link void}
	 */
	public static void launchAppImpl(final Class<? extends Application> appClassReference, final String[] args)
			throws IllegalStateException, RuntimeException {
		// Check if runtime was already launched
		if (LupusRuntimeLauncher.isLaunched.getAndSet(true) == true) {
			// Throw exception
			throw new IllegalStateException("Application was already launched and can not be launched again!");
		}

		// Create a synchronization latch
		final CountDownLatch synchronizationLatch = new CountDownLatch(1);

		// Create a new runtime thread
		Thread runtimeThread = new Thread(() -> {
			try {
				// Start the runtime
				new LupusRuntime(appClassReference, args).start();
			} catch (Exception ex) {
				// Handle any exceptions
				System.err.println("Launcher exception occurred!\n" + ex + "---");
			} finally {
				// Decrement the latch
				synchronizationLatch.countDown();
			}
		});

		// Configure the thread
		runtimeThread.setName("Lupus-Runtime");

		// Start the thread
		runtimeThread.start();

		// Try to wait for the thread to finish before returning
		try {
			// Await for the thread to exit
			synchronizationLatch.await();
		} catch (InterruptedException ex) {
			// Throw exception
			throw new RuntimeException("An unexpected exception occurred!\n" + ex + "---");
		}
	}

	// Public Inherited Methods

	// Private Static Methods

	// Private Inherited Methods
}
