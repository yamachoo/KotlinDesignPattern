package abstractFactory.listFactory

import abstractFactory.factory.Factory
import abstractFactory.factory.Link
import abstractFactory.factory.Page
import abstractFactory.factory.Tray

class ListFactory : Factory() {
    override fun createLink(caption: String, url: String): Link {
        return ListLink(caption, url)
    }
    override fun createTray(caption: String): Tray {
        return ListTray(caption)
    }
    override fun createPage(title: String, author: String): Page {
        return ListPage(title, author)
    }
}
