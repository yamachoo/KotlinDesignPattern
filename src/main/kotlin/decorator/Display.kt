package decorator

abstract class Display {
    abstract fun getColumns(): Int
    abstract fun getRows(): Int
    abstract fun getRowText(row: Int): String

    fun show() {
        repeat(getRows()) {
            println(getRowText(it))
        }
    }
}
