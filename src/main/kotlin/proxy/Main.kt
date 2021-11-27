package proxy

fun main() {
    val p = PrinterProxy("Alice")
    println("名前は現在${p.getPrinterName()}です。")
    p.setPrinterName("Bob")
    println("名前は現在${p.getPrinterName()}です。")
    p.print("Hello, world.")
}
