package memento.game

class Memento(val money: Int) {
    private val fruits = mutableListOf<String>()

    fun addFruits(fruit: String) = fruits.add(fruit)

    fun getFruits() = fruits
}
