package singleton

fun main() {
    println("Start.")

    val obj1 = Singleton.instance
    val obj2 = Singleton.instance

    if (obj1 === obj2) {
        println("obj1とobj2は同じインスタンスです。")
    } else {
        println("obj1とobj2は同じインスタンスではありません。")
    }

    println("End.")
}
