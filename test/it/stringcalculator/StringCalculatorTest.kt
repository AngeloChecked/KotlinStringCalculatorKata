package it.stringcalculator

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class StringCalculatorTest {
    @Test
    fun `should be return if contains a empty string`() {
        val sum = StringCalculator().add("")

        assertEquals(sum, 0)
    }

    @Test
    fun `should be return the number if contains only one number`() {
        val sum = StringCalculator().add("1")

        assertEquals(1, sum)
    }

    @Test
    fun `should be return the sum of number splited by a comma`() {
        val sum = StringCalculator().add("1,2")

        assertEquals(3, sum)
    }

    @Test
    fun `should be return the sum of all numbers splited by a comma`() {
        val sum = StringCalculator().add("1,2,3,4")

        assertEquals(10, sum)
    }

    @Test
    fun `should be return the sum of all numbers splitted by a comma or newline`() {
        val sum = StringCalculator().add("1\n2,3")

        assertEquals(6, sum)
    }

    @Test
    fun `should be return the sum of numbers splitted by the custom separator`() {
        val sum = StringCalculator().add("//;\n1;2;3")

        assertEquals(sum, 6)
    }

    @Test( expected = Exception::class )
    fun `should throw a exception if there is a negative number`() {
            try {
                val sum = StringCalculator().add("1,2,-1,3")
            } catch (e: Exception){

                assertEquals("negatives not allowed: -1", e.message)
                throw e
            }

        fail("no exception propagation")
    }

    @Test
    fun `should be ignore number bigger than 1000`() {
        val sum = StringCalculator().add("2,4,1011,4")

        assertEquals(10, sum)
    }
}