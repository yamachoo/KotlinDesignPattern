package abstractFactory.listFactory

import abstractFactory.factory.Page

class ListPage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        val sb = StringBuilder()
        sb.append("<!DOCTYPE html>\n")
        sb.append("<html><head><title>$title</title></head>\n")
        sb.append("<body>\n")
        sb.append("<h1>$title</h1>\n")
        sb.append("<ul>\n")
        for (item in content) {
            sb.append(item.makeHTML())
        }
        sb.append("</ul>\n")
        sb.append("<hr><address>$author</address>\n")
        sb.append("</body></html>\n")
        return sb.toString()
    }
}
