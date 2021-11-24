package chainOfResponsibility

class SpecialSupport(name: String, private val number: Int) : Support(name) {
    override fun resolve(trouble: Trouble): Boolean = trouble.number == number
}
