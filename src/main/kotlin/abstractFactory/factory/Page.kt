package abstractFactory.factory

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

abstract class Page(
    protected val title: String,
    protected val author: String,
    private val content: MutableList<Item>
) {
    fun add(item: Item) = content.add(item)
    fun output(filename: String) {
        try {
            Files.writeString(
                Path.of(filename),
                makeHTML(),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
            )
            println("${filename}を作成しました。")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    abstract fun makeHTML(): String
}
