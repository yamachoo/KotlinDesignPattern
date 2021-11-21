package abstractFactory.divFactory

import abstractFactory.factory.Page

class DivPage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        val sb = StringBuilder()
        sb.append("<!DOCTYPE html>\n")
        sb.append("<html><head><title>$title</title><style>\n")
        sb.append("div.tray { padding:0.5em; margin-left:5em; border:1px solid black; }\n")
        sb.append("div.link { padding:0.5em; background-color: lightgray; }\n")
        sb.append("</style></head><body>\n")
        sb.append("<h1>$title</h1>")
        for (item in content) {
            sb.append(item.makeHTML())
        }
        sb.append("<hr><address>$author</address>\n")
        sb.append("</body></html>\n")
        return sb.toString()
    }
}
