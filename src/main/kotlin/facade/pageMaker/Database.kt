package facade.pageMaker

import java.io.FileReader
import java.io.IOException
import java.nio.file.Paths
import java.util.Properties
import kotlin.jvm.Throws

val path = Paths.get("src/main/kotlin/facade").toAbsolutePath().toString()

object Database {
    @Throws(IOException::class)
    fun getProperties(dbName: String): Properties {
        val fileName = "$dbName.txt"
        val prop = Properties()
        prop.load(FileReader("$path/$fileName"))
        return prop
    }
}
