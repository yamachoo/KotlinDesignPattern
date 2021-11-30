package interpreter

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

val path = Paths.get("src/main/kotlin/interpreter").toAbsolutePath().toString()

fun main() {
    try {
        for (text in Files.readAllLines(Path.of("$path/program.txt"))) {
            println("text = \"$text\"")
            val node = ProgramNode()
            node.parse(Context(text))
            println("node = $node")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
