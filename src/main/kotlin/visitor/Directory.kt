package visitor

class Directory(private val name: String) : Entry(), Iterable<Entry> {
    private val directory = mutableListOf<Entry>()

    override fun getName(): String = name

    override fun getSize(): Int {
        var size = 0
        for (entry in directory) {
            size += entry.getSize()
        }
        return size
    }

    fun add(entry: Entry) = directory.add(entry)

    override fun iterator(): Iterator<Entry> = directory.iterator()

    override fun accept(v: Visiter) = v.visitor(this)
}
