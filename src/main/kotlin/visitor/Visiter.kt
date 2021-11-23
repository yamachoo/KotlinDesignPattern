package visitor

abstract class Visiter {
    abstract fun visitor(file: File)
    abstract fun visitor(directory: Directory)
}
