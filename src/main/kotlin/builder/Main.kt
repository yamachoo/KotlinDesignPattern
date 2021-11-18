package builder

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        usage()
        exitProcess(0)
    }
    if (args[0] == "plain") {
        val textBuilder = TextBuilder()
        val director = Director(textBuilder)
        director.construct()
        val result = textBuilder.getResult()
        println(result)
    } else if (args[0] == "html") {
        val htmlBuilder = HTMLBuilder()
        val director = Director(htmlBuilder)
        director.construct()
        val filename = htmlBuilder.getHTMLResult()
        println("${filename}が作成されました")
    } else {
        usage()
        exitProcess(0)
    }
}

fun usage() {
    println("Usage: kotlin Main plain    テキストで文書作成")
    println("Usage: kotlin Main html     HTMLファイルで文書作成")
}
