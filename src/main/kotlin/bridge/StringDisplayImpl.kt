package bridge

class StringDisplayImpl(private val string: String) : DisprayImpl() {
    private val width = string.length

    override fun rawOpen() {
        printLine()
    }
    override fun rawPrint() {
        println("|$string|")
    }
    override fun rawClose() {
        printLine()
    }
    private fun printLine() {
        print("+")
        repeat(width) {
            print("-")
        }
        println("+")
    }
}
