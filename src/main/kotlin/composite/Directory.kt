package composite

class Directory(private val name: String) : Entry() {
    private val directory = mutableListOf<Entry>()

    override fun getName(): String = name

    override fun getSize(): Int {
        var size = 0
        for (entry in directory) {
            size += entry.getSize()
        }
        return size
    }

    override fun printList(prefix: String) {
        println("$prefix/$this")
        for (entry in directory) {
            entry.printList("$prefix/$name")
        }
    }

    fun add(entry: Entry) = directory.add(entry)
}
