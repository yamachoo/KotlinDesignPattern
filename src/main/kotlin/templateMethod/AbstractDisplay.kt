package templateMethod

abstract class AbstractDisplay {
    abstract fun open()
    abstract fun print()
    abstract fun close()
    fun display() {
        open()
        repeat(5) {
            print()
        }
        close()
    }
}
