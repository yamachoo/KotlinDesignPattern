package flyweight

object BigCharFactory {
    private val pool = HashMap<String, BigChar>()

    @Synchronized
    fun getBigChar(charName: Char): BigChar {
        var bc = pool[charName.toString()]
        if (bc == null) {
            bc = BigChar(charName)
            pool[charName.toString()] = bc
        }
        return bc
    }
}
