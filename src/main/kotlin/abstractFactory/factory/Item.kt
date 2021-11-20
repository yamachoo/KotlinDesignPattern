package abstractFactory.factory

abstract class Item(protected val caption: String) {
    abstract fun makeHTML(): String
}
