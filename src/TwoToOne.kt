import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * Two To One Code Kata
 * https://www.codewars.com/kata/5656b6906de340bd1b0000ac
 *
 * @author Adam Weesner
 * @since 9/15/2018
 */
fun longest(s1: String, s2: String): String = (s1 + s2).split("").sorted().distinct().joinToString("", "", "")

class TwoToOneTest {
    //.........................
    @Test
    fun test() {
        println("longest Fixed Tests")
        assertEquals("aehrsty", longest("aretheyhere", "yestheyarehere"))
        assertEquals("abcdefghilnoprstu", longest("loopingisfunbutdangerous", "lessdangerousthancoding"))
        assertEquals("acefghilmnoprstuy", longest("inmanylanguages", "theresapairoffunctions"))
        assertEquals("adefghklmnorstu", longest("lordsofthefallen", "gamekult"))
        assertEquals("acdeorsw", longest("codewars", "codewars"))
        assertEquals("acdefghilmnorstuw", longest("agenerationmustconfrontthelooming", "codewarrs"))
    }

    @Test
    fun test1() {
        println("Random Tests")
        for (i in 0..149) {
            val s1 = doEx(randInt(1, 10))
            val s2 = doEx(randInt(1, 8))
            //println(s1);
            //println(s2);
            //println(longestSol(s1, s2));
            //println("****");
            assertEquals(longestSol18(s1, s2), longest(s1, s2))
        }
    }

    companion object {
        fun randInt(min: Int, max: Int): Int {
            return min + (Math.random() * ((max - min) + 1)).toInt()
        }

        fun doEx(k: Int): String {
            var res = ""
            var n = -1
            for (i in 0..14) {
                n = randInt(97 + k, 122)
                for (j in 0 until randInt(1, 5))
                    res += n.toChar()
            }
            return res
        }

        fun longestSol18(s1: String, s2: String): String {
            var alpha1 = IntArray(26)
            for (i in alpha1.indices) alpha1[i] = 0
            var alpha2 = IntArray(26)
            for (i in alpha2.indices) alpha2[i] = 0
            for (i in 0 until s1.length) {
                val c = s1.get(i).toInt()
                if (c >= 97 && c <= 122)
                    alpha1[c - 97]++
            }
            for (i in 0 until s2.length) {
                val c = s2.get(i).toInt()
                if (c >= 97 && c <= 122)
                    alpha2[c - 97]++
            }
            var res = ""
            for (i in 0..25) {
                if (alpha1[i] != 0) {
                    res += (i + 97).toChar()
                    alpha2[i] = 0
                }
            }
            for (i in 0..25) {
                if (alpha2[i] != 0)
                    res += (i + 97).toChar()
            }
            val lstr = res.split(("").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            Arrays.sort(lstr)
            res = lstr.joinToString("")
            return res
        }
    }
}