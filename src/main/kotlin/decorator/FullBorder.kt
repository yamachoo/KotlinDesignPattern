package decorator

class FullBorder(display: Display) : Border(display) {
    override fun getColumns(): Int = 1 + display.getColumns() + 1

    override fun getRows(): Int = 1 + display.getRows() + 1

    override fun getRowText(row: Int): String {
        return when (row) {
            0, display.getRows() + 1 -> "+${makeLine(display.getColumns())}+"
            else -> "|${display.getRowText(row - 1)}|"
        }
    }

    private fun makeLine(count: Int): String {
        val line = StringBuilder()
        repeat(count) {
            line.append('-')
        }
        return line.toString()
    }
}
