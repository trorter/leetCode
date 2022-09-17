class Solution804 {

    val morzeCodeMap = mapOf<String, String>(
            "a" to ".-",
            "b" to "-...",
            "c" to "-.-.",
            "d" to "-..",
            "e" to ".",
            "f" to "..-.",
            "g" to "--.",
            "h" to "....",
            "i" to "..",
            "j" to ".---",
            "k" to "-.-",
            "l" to ".-..",
            "m" to "--",
            "n" to "-.",
            "o" to "---",
            "p" to ".--.",
            "q" to "--.-",
            "r" to ".-.",
            "s" to "...",
            "t" to "-",
            "u" to "..-",
            "v" to "...-",
            "w" to ".--",
            "x" to "-..-",
            "y" to "-.--",
            "z" to "--.."
    )

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val setOfWords = HashSet<String>()

        words.forEach { word -> setOfWords.add(codeWord(word)) }

        return setOfWords.size
    }

    fun codeWord(word: String): String {
        val stringBuffer = StringBuffer()

        word.forEach { char -> stringBuffer.append(morzeCodeMap[char.toString()]) }

        return stringBuffer.toString()
    }

}
