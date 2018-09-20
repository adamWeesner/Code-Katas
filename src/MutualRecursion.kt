import org.junit.Test
import kotlin.test.assertEquals

/**
 * Mutual Recursion Code Kata
 * https://www.codewars.com/kata/mutual-recursion/train/kotlin/5b9c1cee1d5ed28ac80002d7
 *
 * @author Adam Weesner
 * @since 9/15/2018
 */

fun f(n: Int): Int = if (n == 0) 1 else n - m(f(n - 1))
fun m(n: Int): Int = if (n == 0) 0 else n - f(m(n - 1))

class TestExample {
    fun checkF(input: Int, shouldBe: Int) = assertEquals(f(input), shouldBe)
    fun checkM(input: Int, shouldBe: Int) = assertEquals(m(input), shouldBe)

    @Test
    fun basicTests() {
        checkF(0, 1)
        checkF(5, 3)
        checkF(10, 6)
        checkF(15, 9)
        checkF(25, 16)
        checkM(0, 0)
        checkM(5, 3)
        checkM(10, 6)
        checkM(15, 9)
        checkM(25, 16)
    }
}