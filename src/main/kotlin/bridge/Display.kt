package bridge

open class Display(private val impl: DisprayImpl) {
    protected fun open() = impl.rawOpen()
    protected fun print() = impl.rawPrint()
    protected fun close() = impl.rawClose()
    fun display() {
        open()
        print()
        close()
    }
}
