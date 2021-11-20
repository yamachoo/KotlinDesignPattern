package abstractFactory.factory

abstract class Tray(caption: String) : Item(caption) {
    protected val tray = mutableListOf<Item>()

    fun add(item: Item) = tray.add(item)
}
