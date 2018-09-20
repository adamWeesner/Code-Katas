import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Encrypt This Code Kata
 * https://www.codewars.com/kata/5848565e273af816fb000449
 *
 * @author Adam Weesner
 * @since 9/20/2018
 */

fun encryptThis(text: String): String {
    val items = text.split(" ")
    val encrypted = arrayListOf<String>()

    items.forEach {
        val item = it.toCharArray()
        val tempItem = arrayListOf<String>()
        item.forEachIndexed { i, char ->
            when (i) {
                0 -> tempItem.add(0, char.toInt().toString())
                1 -> tempItem.add(1, item[item.lastIndex].toString())
                item.lastIndex -> tempItem.add(item.lastIndex, item[1].toString())
                else -> tempItem.add(i, char.toString())
            }
        }
        encrypted.add(tempItem.joinToString(separator = "") { it })
    }

    return encrypted.joinToString(separator = " ") { it }
}

class EncryptThisTests {
    @Test
    fun testSample() {
        // Example Test Cases
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"))
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", encryptThis("The more he saw the less he spoke"))
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", encryptThis("The less he spoke the more he heard"))
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", encryptThis("Why can we not all be like that wise old bird"))
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"))
    }

}