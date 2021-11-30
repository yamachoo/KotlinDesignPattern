package interpreter

import kotlin.jvm.Throws

// <primitive command> ::= go | right | left
class PrimitiveCommandNode : Node() {
    private var name: String? = ""

    @Throws(ParseException::class)
    override fun parse(context: Context) {
        name = context.currentToken()
        if (name == null) {
            throw ParseException("Error: Missing <primitive command>")
        } else if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw ParseException("Error: Unknown <primitive command>: '$name'")
        }
        context.skipToken(name!!)
    }

    override fun toString(): String = name!!
}
