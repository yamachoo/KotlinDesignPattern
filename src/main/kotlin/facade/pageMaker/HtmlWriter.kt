package facade.pageMaker

import java.io.IOException
import java.io.Writer
import kotlin.jvm.Throws

class HtmlWriter(private val writer: Writer) {
    @Throws(IOException::class)
    fun title(title: String) {
        writer.write("<!DOCTYPE html>")
        writer.write("<html>")
        writer.write("<head>")
        writer.write("<title>$title</title>")
        writer.write("</head>")
        writer.write("<body>")
        writer.write("\n")
        writer.write("<h1>$title</h1>")
        writer.write("\n")
    }

    @Throws(IOException::class)
    fun paragraph(msg: String) {
        writer.write("<p>$msg</p>")
        writer.write("\n")
    }

    @Throws(IOException::class)
    fun link(href: String, caption: String) {
        paragraph("<a href=\"$href\">$caption</a>")
    }

    @Throws(IOException::class)
    fun mailto(mailAddr: String, userName: String) {
        link("mailto:$mailAddr", userName)
    }

    @Throws(IOException::class)
    fun close() {
        writer.write("</body>")
        writer.write("</html>")
        writer.write("\n")
        writer.close()
    }
}
