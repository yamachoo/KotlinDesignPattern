package mediator

interface Colleague {
    fun setMediator(mediator: Mediator)
    fun setColleagueEnabled(enabled: Boolean)
}
