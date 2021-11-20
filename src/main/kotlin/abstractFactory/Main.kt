package abstractFactory

import abstractFactory.factory.Factory
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: kotlin Main filename.html class.name.of.ConcreteFactory")
        println("Example 1: java Main list.html listfactory.ListFactory")
        println("Example 2: java Main div.html divfactory.DivFactory")
        exitProcess(0)
    }

    val filename = args[0]
    val classname = args[1]

    val factory = Factory.getFactory(classname) ?: exitProcess(1)

    val blog1 = factory.createLink("Blog 1", "https://example.com/blog1")
    val blog2 = factory.createLink("Blog 2", "https://example.com/blog2")
    val blog3 = factory.createLink("Blog 3", "https://example.com/blog3")

    val blogTray = factory.createTray("Blog Site")
    blogTray.add(blog1)
    blogTray.add(blog2)
    blogTray.add(blog3)

    val news1 = factory.createLink("News 1", "https://example.com/news1")
    val news2 = factory.createLink("News 2", "https://example.com/news2")
    val news3 = factory.createTray("News 3")
    news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"))
    news3.add(factory.createLink("News 3 (Japan)", "https://example.com/news3jp"))

    val newsTray = factory.createTray("News Site")
    newsTray.add(news1)
    newsTray.add(news2)
    newsTray.add(news3)

    val page = factory.createPage("Blog and News", "Hiroshi Yuki")
    page.add(blogTray)
    page.add(newsTray)

    page.output(filename)
}
