package prototype.framework

class Manager {
    private val showcase = HashMap<String, Product>()

    fun register(name: String, product: Product) {
        showcase[name] = product
    }
    fun create(protoname: String): Product? {
        val p = showcase[protoname]
        return p?.createClone()
    }
}
