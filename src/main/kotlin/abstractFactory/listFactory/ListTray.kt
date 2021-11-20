package abstractFactory.listFactory

import abstractFactory.factory.Tray

class ListTray(caption: String) : Tray(caption) {
    override fun makeHTML(): String {
        val sb = StringBuilder()
        sb.append("<li>\n")
        sb.append("$caption\n")
        sb.append("<ul>\n")
        for (item in tray) {
            sb.append(item.makeHTML())
        }
        sb.append("</ul>\n")
        sb.append("</li>\n")
        return sb.toString()
    }
}
