import org.junit.Test
import kotlin.test.assertEquals

/**
 * Mumbling Code Kata
 * https://www.codewars.com/kata/5667e8f4e3f572a8f2000039
 *
 * @author Adam Weesner
 * @since 9/15/2018
 */

fun accum(s: String): String {
    var accumulator = ""
    s.toCharArray().forEachIndexed { i, char ->
        accumulator += char.toUpperCase()
        accumulator += if (i != 0) char.toLowerCase().toString().repeat(i) else ""

        if (i != s.length - 1) accumulator += "-"
    }

    return accumulator
}

class AccumulTest {
    private fun testing(actual: String, expected: String) {
        assertEquals(expected, actual)
    }

    @Test
    fun test() {
        println("Fixed Tests accum")
        testing(accum("ZpglnRxqenU"), "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu")
        testing(accum("NyffsGeyylB"), "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb")

    }

}