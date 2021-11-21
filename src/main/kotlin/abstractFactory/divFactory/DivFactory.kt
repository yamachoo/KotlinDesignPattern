package abstractFactory.divFactory

import abstractFactory.factory.Factory
import abstractFactory.factory.Link
import abstractFactory.factory.Page
import abstractFactory.factory.Tray

class DivFactory : Factory() {
    override fun createLink(caption: String, url: String): Link = DivLink(caption, url)
    override fun createTray(caption: String): Tray = DivTray(caption)
    override fun createPage(title: String, author: String): Page = DivPage(title, author)
}
