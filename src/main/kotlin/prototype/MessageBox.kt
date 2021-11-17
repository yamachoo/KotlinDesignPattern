package prototype

import prototype.framework.Product

class MessageBox(private val decochar: Char) : Product {
    override fun use(s: String) {
        val length = s.toByteArray().size
        printDecoLine(length)
        println("$decochar $s $decochar")
        printDecoLine(length)
    }
    override fun createClone(): Product? {
        var p: Product? = null
        try {
            p = clone() as Product
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return p
    }
    private fun printDecoLine(length: Int) {
        repeat(length + 4) {
            print(decochar)
        }
        println("")
    }
}
