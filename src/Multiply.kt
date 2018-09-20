import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Multiply Code Kata
 * https://www.codewars.com/kata/50654ddff44f800200000004
 *
 * @author Adam Weesner
 * @since 9/13/2018
 */

fun multiply(x: Double, y: Double): Double = x * y

class Multiplication_Test {
    @Test
    @Throws(Exception::class)
    fun test_Associativity_Of_Multiplication() {
        for (i in 0..99) {
            val a = Math.random()
            val b = Math.random()
            val c = Math.random()
            val message = String.format("(%g * %g) * %g == %g * (%g * %g)", a, b, c, a, b, c)
            assertEquals(message,
                    multiply(multiply(a, b), c),
                    multiply(a, multiply(b, c)),
                    1E-14)
        }
    }
}