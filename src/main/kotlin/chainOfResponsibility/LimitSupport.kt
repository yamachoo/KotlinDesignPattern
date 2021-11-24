package chainOfResponsibility

class LimitSupport(name: String, private val limit: Int) : Support(name) {
    override fun resolve(trouble: Trouble): Boolean = trouble.number < limit
}
