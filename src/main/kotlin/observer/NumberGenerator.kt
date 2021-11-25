package observer

abstract class NumberGenerator {
    private val observers = mutableListOf<Observer>()

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun deleteObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        for (o in observers) o.update(this)
    }

    abstract fun getNumber(): Int
    abstract fun execute()
}
