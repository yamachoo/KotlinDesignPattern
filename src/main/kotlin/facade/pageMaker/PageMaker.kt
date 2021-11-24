package facade.pageMaker

import java.io.FileWriter
import java.io.IOException

object PageMaker {
    fun makeWelcomePage(mailAddr: String, fileName: String) {
        try {
            val mailProp = Database.getProperties("mailData")
            val userName = mailProp.getProperty(mailAddr)
            val writer = HtmlWriter(FileWriter(fileName))

            writer.title("$userName's web page")
            writer.paragraph("Welcome to $userName's web page!")
            writer.paragraph("Nice to meet you!")
            writer.mailto(mailAddr, userName)
            writer.close()

            println("$fileName is created for $mailAddr ($userName)")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
