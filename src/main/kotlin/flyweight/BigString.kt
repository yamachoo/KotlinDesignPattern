package flyweight

class BigString(string: String) {
    private var bigChar = arrayOfNulls<BigChar>(string.length)

    init {
        val factory = BigCharFactory
        repeat(bigChar.size) {
            bigChar[it] = factory.getBigChar(string[it])
        }
    }

    fun print() {
        for (bc in bigChar) {
            bc?.print()
        }
    }
}
