package chainOfResponsibility

fun main() {
    val alice: Support = NoSupport("Alice")
    val bob: Support = LimitSupport("Bob", 100)
    val charlie: Support = SpecialSupport("Charlie", 429)
    val diana: Support = LimitSupport("Diana", 200)
    val elmo: Support = OddSupport("Elmo")
    val fred: Support = LimitSupport("Fred", 300)

    alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred)

    for (i in 0..500 step 33) {
        alice.support(Trouble(i))
    }
}
