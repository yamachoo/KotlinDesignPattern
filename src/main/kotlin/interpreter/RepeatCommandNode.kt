package interpreter

import kotlin.jvm.Throws

// <repeat command> ::= repeat <number> <command list>
class RepeatCommandNode : Node() {
    private var number = 0
    private var commandListNode: Node? = null

    @Throws(ParseException::class)
    override fun parse(context: Context) {
        context.skipToken("repeat")
        number = context.currentNumber()
        context.nextToken()
        commandListNode = CommandListNode()
        commandListNode?.parse(context)
    }

    override fun toString(): String = "[repeat $number $commandListNode]"
}
