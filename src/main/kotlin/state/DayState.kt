package state

object DayState : State {
    override fun doClock(context: Context, hour: Int) {
        if (hour !in 9..16) {
            context.changeState(NightState)
        }
    }

    override fun doUse(context: Context) {
        context.recordLog("金庫使用(昼間)")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("非常ベル(昼間)")
    }

    override fun doPhone(context: Context) {
        context.callSecurityCenter("通常の通話(昼間)")
    }

    override fun toString(): String = "[昼間]"
}
