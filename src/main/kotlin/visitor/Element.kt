package visitor

interface Element {
    fun accept(v: Visiter)
}
