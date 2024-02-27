// Package Declaration
package lupus.utils;

// Import Statements
// ----------------------------------------------------------------

// ---

// ---

// ----------------------------------------------------------------

// File Docstring
/**
 * A utility class that provides standard/custom math operations.
 *
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public final class LupusMath {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables

    // Constructor

    // Public Static Methods
    /**
     * Clamps a given value between the minimum and maximum values inclusive.
     *
     * @param value        - The value to clamp
     * @param minimumValue - The minimum allowed value
     * @param maximumValue - The maximum allowed value
     * @return {@link float}
     */
    public static float clamp(float value, float minimumValue, float maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }

    // Public Inherited Methods

    // Private Static Methods

    // Private Inherited Methods
}
