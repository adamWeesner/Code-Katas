import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Reduce But Grow Code Kata
 * https://www.codewars.com/kata/57f780909f7e8e3183000078
 *
 * @author Adam Weesner
 * @since 9/20/2018
 */

fun grow(arr: IntArray): Int = arr.reduce { total, value -> total * value }

class ReduceButGrowTests {
    @Test
    fun exampleTests() {
        assertEquals(6, grow(intArrayOf(1, 2, 3)))
        assertEquals(16, grow(intArrayOf(4, 1, 1, 1, 4)))
        assertEquals(64, grow(intArrayOf(2, 2, 2, 2, 2, 2)))
    }
}