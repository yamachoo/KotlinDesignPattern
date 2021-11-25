package observer

class GraphObserver : Observer {
    override fun update(generator: NumberGenerator) {
        println("GraphObserver:")
        val count = generator.getNumber()
        repeat(count) {
            print("*")
        }
        println("")
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
