package composite

abstract class Entry {
    abstract fun getName(): String
    abstract fun getSize(): Int
    fun printList() = printList("")
    abstract fun printList(prefix: String)
    override fun toString(): String = "${getName()} (${getSize()})"
}
