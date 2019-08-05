package it.stringcalculator

import java.lang.Integer.valueOf


class StringCalculator {

    private val DEFAULT_SEPARATOR = ","
    private val SECOND_DEFAULT_SEPARATOR = "\n"
    private val NEW_SEPARATOR_AREA_START_CHARACTERS = "//"
    private val NEW_SEPARATOR_AREA_END_CHARACTER = "\n"

    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        var (separator, numbersToSum) = newDifferentDelimitersAreaCheck(input)

        return numbersToSum.split(separator).fold(0) {
            sum, numberString ->
            val number = valueOf(numberString)
            if (number < 0){ throw Exception("negatives not allowed: $number") }
            if (number > 1000) ( sum ) else ( number + sum )
        }
    }

    private fun newDifferentDelimitersAreaCheck(input: String): Pair<String, String> {
        var separator = DEFAULT_SEPARATOR
        var numbersToSum = input
        if (numbersToSum.startsWith(NEW_SEPARATOR_AREA_START_CHARACTERS)) {
            val seplitedInput = numbersToSum.split(NEW_SEPARATOR_AREA_END_CHARACTER)
            val newSeparatorArea = seplitedInput[0]
            separator = newSeparatorArea.substring(2)
            numbersToSum = input.substring(newSeparatorArea.length + 1)
        }
        numbersToSum = numbersToSum.replace(SECOND_DEFAULT_SEPARATOR, separator)
        return Pair(separator, numbersToSum)
    }
}

