package memento

import memento.game.Gamer

fun main() {
    val gamer = Gamer(100)
    var memento = gamer.createMemento()

    repeat(100) {
        println("==== $it")
        println("現状:$gamer")

        gamer.bet()

        println("所持金は${gamer.money}円になりました。")

        if (gamer.money > memento.money) {
            println("※だいぶ増えたので、現在の状態を保存しておこう！")
            memento = gamer.createMemento()
        } else if (gamer.money < memento.money / 2) {
            println("※だいぶ減ったので、以前の状態を復元しよう！")
            gamer.restoreMemento(memento)
        }

        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println()
    }
}
