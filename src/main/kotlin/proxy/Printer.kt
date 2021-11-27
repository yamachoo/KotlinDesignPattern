package proxy

class Printer : Printable {
    private var name = ""

    constructor() {
        heavyJob("Printerのインスタンスを生成中")
    }

    constructor(name: String) {
        this.name = name
        heavyJob("Printerのインスタンス($name)を生成中")
    }

    override fun setPrinterName(name: String) {
        this.name = name
    }

    override fun getPrinterName(): String = name

    override fun print(string: String) {
        println("=== $name ===")
        println(string)
    }

    private fun heavyJob(msg: String) {
        kotlin.io.print(msg)
        repeat(5) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            kotlin.io.print(".")
        }
        println("完了。")
    }
}
