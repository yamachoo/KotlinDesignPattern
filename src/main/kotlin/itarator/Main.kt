package itarator

fun main() {
    val bookShelf = BookShelf(4)
    bookShelf.appendBook(Book("Around the World in 80 Days"))
    bookShelf.appendBook(Book("Bible"))
    bookShelf.appendBook(Book("Cinderella"))
    bookShelf.appendBook(Book("Daddy-Long-Legs"))

    val iterator = bookShelf.iterator()
    while (iterator.hasNext()) {
        val book = iterator.next() as Book
        println(book.name)
    }
}
