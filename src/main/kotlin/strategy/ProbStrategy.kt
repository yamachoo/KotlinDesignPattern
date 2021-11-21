package strategy

import kotlin.random.Random

class ProbStrategy(seed: Int) : Strategy {
    private val random = Random(seed)
    private var prevHandValue = 0
    private var currentHandValue = 0
    private val history = listOf(
        mutableListOf(1, 1, 1),
        mutableListOf(1, 1, 1),
        mutableListOf(1, 1, 1)
    )

    override fun nextHand(): Hand {
        val bet = random.nextInt(getSum(currentHandValue))
        var handValue = 2
        if (bet < history[currentHandValue][0]) {
            handValue = 0
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1
        }
        prevHandValue = currentHandValue
        currentHandValue = handValue
        return Hand.getHand(handValue)
    }

    private fun getSum(handValue: Int): Int {
        var sum = 0
        repeat(3) {
            sum += history[handValue][it]
        }
        return sum
    }

    override fun study(win: Boolean) {
        if (win) {
            history[prevHandValue][currentHandValue]++
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }
}
