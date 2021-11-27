package state

object NightState : State {
    override fun doClock(context: Context, hour: Int) {
        if (hour in 9..16) {
            context.changeState(DayState)
        }
    }

    override fun doUse(context: Context) {
        context.callSecurityCenter("非常：夜間の金庫使用！")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("非常ベル(夜間)")
    }

    override fun doPhone(context: Context) {
        context.recordLog("夜間の通話録音")
    }

    override fun toString(): String = "[夜間]"
}
