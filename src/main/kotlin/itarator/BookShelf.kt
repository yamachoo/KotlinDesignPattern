package itarator

class BookShelf(maxsize: Int) : Aggregate {
    private val books = arrayOfNulls<Book>(maxsize)
    private var last = 0
    val length: Int
        get() = last

    fun getBookAt(index: Int): Book? {
        return books[index]
    }
    fun appendBook(book: Book) {
        books[last] = book
        last++
    }
    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}
