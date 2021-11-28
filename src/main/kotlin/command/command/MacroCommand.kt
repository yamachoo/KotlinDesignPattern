package command.command

class MacroCommand : Command {
    private val commands = ArrayDeque<Command>()

    override fun execute() {
        for (cmd in commands) {
            cmd.execute()
        }
    }

    fun append(cmd: Command) {
        if (cmd == this) {
            throw IllegalArgumentException("infinite loop caused by append")
        }
        commands.add(cmd)
    }

    fun undo() {
        if (commands.isEmpty()) commands.removeLast()
    }

    fun clear() {
        commands.clear()
    }
}
