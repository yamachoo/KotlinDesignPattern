package adapter1

class PrintBanner(string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }
    override fun printStrong() {
        showWithAster()
    }
}
