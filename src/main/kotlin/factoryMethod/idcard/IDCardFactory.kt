package factoryMethod.idcard

import factoryMethod.framework.Factory
import factoryMethod.framework.Product

class IDCardFactory : Factory() {
    private var owners = mutableListOf<String>()

    override fun createProduct(owner: String): Product {
        return IDCard(owner)
    }
    override fun registerProduct(product: Product) {
        owners.add((product as IDCard).owner)
    }
}
