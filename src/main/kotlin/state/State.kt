package state

interface State {
    fun doClock(context: Context, hour: Int)
    fun doUse(context: Context)
    fun doAlarm(context: Context)
    fun doPhone(context: Context)
}
