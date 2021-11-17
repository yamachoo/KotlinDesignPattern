package templateMethod

class StringDisplay(private val string: String) : AbstractDisplay() {
    private val width = string.toByteArray().size

    override fun open() = printLine()
    override fun print() = println("|$string|")
    override fun close() = printLine()
    private fun printLine() {
        print("+")
        repeat(width) {
            print("-")
        }
        println("+")
    }
}
