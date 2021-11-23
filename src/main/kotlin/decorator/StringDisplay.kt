package decorator

class StringDisplay(private val string: String) : Display() {
    override fun getColumns(): Int = string.length

    override fun getRows(): Int = 1

    override fun getRowText(row: Int): String {
        if (row != 0) {
            throw IndexOutOfBoundsException()
        }
        return string
    }
}
