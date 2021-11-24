package chainOfResponsibility

class OddSupport(name: String) : Support(name) {
    override fun resolve(trouble: Trouble): Boolean = trouble.number % 2 == 1
}
