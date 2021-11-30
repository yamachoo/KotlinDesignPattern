package interpreter

import kotlin.jvm.Throws

class Context(text: String) {
    private val tokens = text.split("\\s+".toRegex())
    private var lastToken: String? = null
    private var index = 0

    init {
        nextToken()
    }

    fun nextToken(): String? {
        lastToken = if (index < tokens.size) {
            tokens[index++]
        } else {
            null
        }
        return lastToken
    }

    fun currentToken(): String? = lastToken

    @Throws(ParseException::class)
    fun skipToken(token: String) {
        if (currentToken() == null) {
            throw ParseException("Error: '$token' is expected, but no more token is found.")
        } else if (token != currentToken()) {
            throw ParseException("Error: '$token' is expected, but '${currentToken()}' is found.")
        }
        nextToken()
    }

    @Throws(ParseException::class)
    fun currentNumber(): Int {
        if (currentToken() == null) {
            throw ParseException("Error: No more token.")
        }
        val number: Int
        try {
            number = currentToken()!!.toInt()
        } catch (e: NumberFormatException) {
            throw ParseException("Error: $e")
        }
        return number
    }
}
