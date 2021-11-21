package abstractFactory.divFactory

import abstractFactory.factory.Tray

class DivTray(caption: String) : Tray(caption) {
    override fun makeHTML(): String {
        val sb = StringBuilder()
        sb.append("<p><b>$caption</b></p>\n")
        sb.append("<div class=\"tray\">")
        for (item in tray) {
            sb.append(item.makeHTML())
        }
        sb.append("</div>\n")
        return sb.toString()
    }
}
