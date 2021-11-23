package visitor

class File(private val name: String, private val size: Int) : Entry() {
    override fun getName(): String = name

    override fun getSize(): Int = size

    override fun accept(v: Visiter) = v.visitor(this)
}
