package interpreter

import kotlin.jvm.Throws

// <program> ::= program <command list>
class ProgramNode : Node() {
    private var commandListNode: Node? = null

    @Throws(ParseException::class)
    override fun parse(context: Context) {
        context.skipToken("program")
        commandListNode = CommandListNode()
        commandListNode?.parse(context)
    }

    override fun toString(): String = "[program $commandListNode]"
}
