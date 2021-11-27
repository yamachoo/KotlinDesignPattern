package flyweight

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: kotlin Main digits")
        println("Example: kotlin Main 1212123")
        exitProcess(0)
    }

    val bs = BigString(args[0])
    bs.print()
}
