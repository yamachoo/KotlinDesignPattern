package interpreter

import kotlin.jvm.Throws

abstract class Node {
    @Throws(ParseException::class)
    abstract fun parse(context: Context)
}
