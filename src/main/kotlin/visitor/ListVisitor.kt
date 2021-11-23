package visitor

class ListVisitor : Visiter() {
    var currentDir = ""

    override fun visitor(file: File) = println("$currentDir/$file")

    override fun visitor(directory: Directory) {
        println("$currentDir/$directory")
        val saveDir = currentDir
        currentDir = "$currentDir/${directory.getName()}"
        for (entry in directory) {
            entry.accept(this)
        }
        currentDir = saveDir
    }
}
