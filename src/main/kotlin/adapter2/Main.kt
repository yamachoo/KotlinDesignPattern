package adapter2

fun main() {
    val p: Print = PrintBanner("Hello")
    p.printWeak()
    p.printStrong()
}
