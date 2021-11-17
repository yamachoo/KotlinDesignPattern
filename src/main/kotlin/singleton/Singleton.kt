package singleton

object Singleton {
    val instance = singleton()

    private fun singleton() = println("インスタンスを作成しました。")
}
