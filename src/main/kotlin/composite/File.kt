package composite

class File(private val name: String, private val size: Int) : Entry() {
    override fun getName(): String = name

    override fun getSize(): Int = size

    override fun printList(prefix: String) {
        println("$prefix/$this")
    }
}
