package abstractFactory.factory

abstract class Tray(
    caption: String,
    private val tray: MutableList<Item>
) : Item(caption) {
    fun add(item: Item) = tray.add(item)
}
