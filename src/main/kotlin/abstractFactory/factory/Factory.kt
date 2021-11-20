package abstractFactory.factory

abstract class Factory {
    companion object {
        fun getFactory(classname: String): Factory? {
            var factory: Factory? = null
            try {
                factory = Class.forName(classname).getDeclaredConstructor().newInstance() as Factory
            } catch (e: ClassNotFoundException) {
                println("クラス ${classname}が見つかりません。")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return factory
        }
    }

    abstract fun createLink(caption: String, url: String): Link
    abstract fun createTray(caption: String): Tray
    abstract fun createPage(title: String, author: String): Page
}
