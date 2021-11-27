package flyweight

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

val path = Paths.get("src/main/kotlin/flyweight").toAbsolutePath().toString()

class BigChar(charName: Char) {
    private var fontData = ""

    init {
        try {
            val fileName = "big$charName.txt"
            val sb = StringBuilder()
            for (line in Files.readAllLines(Path.of("$path/$fileName"))) {
                sb.append("$line\n")
            }
            this.fontData = sb.toString()
        } catch (e: IOException) {
            this.fontData = "$charName?"
        }
    }

    fun print() = print(fontData)
}
