package abstractFactory.divFactory

import abstractFactory.factory.Link

class DivLink(caption: String, url: String) : Link(caption, url) {
    override fun makeHTML(): String = "<div class=\"link\"><a href=\"$url\">$caption</a></div>\n"
}
