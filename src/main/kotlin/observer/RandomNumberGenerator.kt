package observer

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator() {
    private var number = 0

    override fun getNumber(): Int = number

    override fun execute() {
        repeat(20) {
            number = Random.nextInt(50)
            notifyObservers()
        }
    }
}
