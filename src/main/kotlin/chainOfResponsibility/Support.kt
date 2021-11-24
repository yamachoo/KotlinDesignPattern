package chainOfResponsibility

abstract class Support(val name: String) {
    private var next: Support? = null

    fun setNext(nextSupport: Support): Support {
        next = nextSupport
        return next as Support
    }

    fun support(trouble: Trouble) {
        if (resolve(trouble)) {
            done(trouble)
        } else if (next != null) {
            next!!.support(trouble)
        } else {
            fail(trouble)
        }
    }

    override fun toString(): String {
        return "[$name]"
    }

    protected abstract fun resolve(trouble: Trouble): Boolean

    protected fun done(trouble: Trouble) = println("$trouble is resolved by $this.")

    protected fun fail(trouble: Trouble) = println("$trouble cannot be resolved.")
}
