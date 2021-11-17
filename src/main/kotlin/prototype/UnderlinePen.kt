package prototype

import prototype.framework.Product

class UnderlinePen(private val ulchar: Char) : Product {
    override fun use(s: String) {
        val length = s.toByteArray().size
        println("\"$s\"")
        print(" ")
        repeat(length) {
            print(ulchar)
        }
        println("")
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
}
