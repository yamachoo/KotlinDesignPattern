package state

fun main() {
    val frame = SafeFrame("State Sample")

    while (true) {
        repeat(24) {
            frame.setClock(it)
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}
