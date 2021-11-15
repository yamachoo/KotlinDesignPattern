package adapter1

fun main() {
    val p: Print = PrintBanner("Hello")
    p.printWeak()
    p.printStrong()
}
