package builder

import java.io.FileWriter
import java.io.IOException

class HTMLBuilder : Builder() {
    private var filename = "untitled.html"
    private val sb = StringBuilder()

    override fun makeTitle(title: String) {
        filename = "$title.html"
        sb.append("<!DOCTYPE html>\n")
        sb.append("<html>\n")
        sb.append("<head><title>")
        sb.append(title)
        sb.append("</title></head>\n")
        sb.append("<body>\n")
        sb.append("<h1>")
        sb.append(title)
        sb.append("</h1>\n")
    }
    override fun makeString(str: String) {
        sb.append("<p>$str</p>\n")
    }
    override fun makeItems(items: List<String>) {
        sb.append("<ul>")
        for (item in items) {
            sb.append("<li>$item</li>\n")
        }
        sb.append("</ul>\n")
    }
    override fun close() {
        sb.append("</body>\n")
        sb.append("</html>\n")
        try {
            val writer = FileWriter(filename)
            writer.write(sb.toString())
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun getHTMLResult() = filename
}
