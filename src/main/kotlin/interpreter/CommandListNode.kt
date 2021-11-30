package interpreter

import kotlin.jvm.Throws

// <command list> ::= <command>* end
class CommandListNode : Node() {
    private val list = mutableListOf<Node>()

    @Throws(ParseException::class)
    override fun parse(context: Context) {
        while (true) {
            if (context.currentToken() == null) {
                throw ParseException("Error: Missing 'end'")
            } else if (context.currentToken() == "end") {
                context.skipToken("end")
                break
            } else {
                val commandNode = CommandNode()
                commandNode.parse(context)
                list.add(commandNode)
            }
        }
    }

    override fun toString(): String = list.toString()
}
