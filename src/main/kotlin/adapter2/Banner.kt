package adapter2

open class Banner(private val string: String) {
    fun showWithParen() = println("($string)")
    fun showWithAster() = println("*$string*")
}
