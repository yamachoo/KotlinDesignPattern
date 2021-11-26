package memento.game

import kotlin.random.Random

class Gamer(var money: Int) {
    private var fruits = mutableListOf<String>()

    companion object {
        private val fruitsName = arrayOf("リンゴ", "ぶどう", "バナナ", "みかん")
    }

    fun bet() {
        when (Random.nextInt(6) + 1) {
            1 -> {
                money += 100
                println("所持金が増えました。")
            }
            2 -> {
                money /= 2
                println("所持金が半分になりました。")
            }
            6 -> {
                val f = getFruit()
                println("フルーツ($f)をもらいました。")
                fruits.add(f)
            }
            else -> {
                println("何も起こりませんでした。")
            }
        }
    }

    fun createMemento(): Memento {
        val m = Memento(money)
        for (f in fruits) {
            if (f.startsWith("おいしい")) {
                m.addFruits(f)
            }
        }
        return m
    }

    fun restoreMemento(memento: Memento) {
        money = memento.money
        fruits = memento.getFruits()
    }

    override fun toString(): String = "[money = $money, fruits = $fruits]"

    private fun getFruit(): String {
        val f = fruitsName[Random.nextInt(fruitsName.size)]
        return if (Random.nextBoolean()) "おいしい$f" else f
    }
}
