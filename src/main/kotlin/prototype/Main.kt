package prototype

import prototype.framework.Manager

fun main() {
    val manager = Manager()
    val upen = UnderlinePen('~')
    val mbox = MessageBox('*')
    val sbox = MessageBox('/')

    manager.register("strong message", upen)
    manager.register("warning box", mbox)
    manager.register("slash box", sbox)

    val p1 = manager.create("strong message")
    val p2 = manager.create("warning box")
    val p3 = manager.create("slash box")

    p1?.use("Hello, world.")
    p2?.use("Hello, world.")
    p3?.use("Hello, world.")
}
