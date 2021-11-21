package strategy

enum class Hand(private val hand: String, private val handValue: Int) {
    ROCK("グー", 0),
    SCISSORS("チョキ", 1),
    PAPER("パー", 2);

    companion object {
        private val hands = listOf(ROCK, SCISSORS, PAPER)

        fun getHand(handValue: Int) = hands[handValue]
    }

    fun isStrongerThan(h: Hand) = fight(h) == 1

    fun isWeakerThan(h: Hand) = fight(h) == -1

    private fun fight(h: Hand): Int {
        val result = if (this == h) {
            0
        } else if ((handValue + 1) % 3 == h.handValue) {
            1
        } else {
            -1
        }
        return result
    }

    override fun toString(): String = hand
}
