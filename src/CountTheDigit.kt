import org.junit.Test
import kotlin.test.assertEquals

/**
 * Count The Digit Code Kata
 * https://www.codewars.com/kata/566fc12495810954b1000030
 *
 * @author Adam Weesner
 * @since 9/15/2018
 */

fun nbDig(n: Int, d: Int): Int {
    var counter = 0
    for (i in 0..n) {
        val squared = i.times(i).toString()

        if (squared.contains(d.toString())) counter += squared.replace(Regex("[^$d]"), "").length
    }

    return counter
}

class CountDigTest {
    private fun testing(actual:Int, expected:Int) {
        assertEquals(expected.toLong(), actual.toLong())
    }
    private fun randInt(min:Int, max:Int):Int {
        return min + (Math.random() * ((max - min) + 1)).toInt()
    }
    private fun nbDigSol12(n:Int, d:Int):Int {
        var k = 0
        var cnt = 0
        val c = (d).toString().get(0)
        while (k <= n)
        {
            var a = 0
            val s = (k * k).toString()
            for (i in 0 until s.length)
                if (s.get(i) == c)
                    a++
            if (a > 0)
                cnt += a
            k++
        }
        return cnt
    }
    @Test
    fun test() {
        println("Fixed Tests nbDig")
        testing(nbDig(5750, 0), 4700)
        testing(nbDig(11011, 2), 9481)
        testing(nbDig(12224, 8), 7733)
        testing(nbDig(11549, 1), 11905)
        testing(nbDig(14550, 7), 8014)
        testing(nbDig(8304, 7), 3927)
        testing(nbDig(10576, 9), 7860)
        testing(nbDig(12526, 1), 13558)
        testing(nbDig(7856, 4), 7132)
        testing(nbDig(14956, 1), 17267)
    }
    @Test
    fun test1() {
        println("100 Random Tests")
        for (i in 0..99)
        {
            val n = randInt(2000, 15000)
            val d = randInt(0, 9)
            val r = nbDigSol12(n, d)
            //println("n " + n + " d " + d + " --> " + r);
            //println("****");
            testing(nbDig(n, d), r)
        }
    }
}