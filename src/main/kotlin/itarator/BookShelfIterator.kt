package itarator

class BookShelfIterator(private val bookShelf: BookShelf) : Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < bookShelf.length
    }
    override fun next(): Any {
        val book = bookShelf.getBookAt(index)
        index++
        return book as Any
    }
}
