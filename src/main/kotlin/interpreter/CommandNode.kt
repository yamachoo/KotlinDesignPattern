package interpreter

import kotlin.jvm.Throws

// <command> ::= <repeat command> | <primitive command>
class CommandNode : Node() {
    private var node: Node? = null

    @Throws(ParseException::class)
    override fun parse(context: Context) {
        if (context.currentToken() == "repeat") {
            node = RepeatCommandNode()
            node?.parse(context)
        } else {
            node = PrimitiveCommandNode()
            node?.parse(context)
        }
    }

    override fun toString(): String = node.toString()
}
