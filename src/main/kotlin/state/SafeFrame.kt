package state

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import kotlin.system.exitProcess

class SafeFrame(title: String) : Frame(title), ActionListener, Context {
    private val textClock = TextField(60)
    private val textScreen = TextArea(10, 60)
    private val buttonUse = Button("金庫使用")
    private val buttonAlarm = Button("非常ベル")
    private val buttonPhone = Button("通常通話")
    private val buttonExit = Button("終了")

    private var state: State = DayState

    init {
        background = Color.lightGray
        layout = BorderLayout()

        add(textClock, BorderLayout.NORTH)
        textClock.isEditable = false

        add(textScreen, BorderLayout.CENTER)
        textScreen.isEditable = false

        val panel = Panel()
        panel.add(buttonUse)
        panel.add(buttonAlarm)
        panel.add(buttonPhone)
        panel.add(buttonExit)

        add(panel, BorderLayout.SOUTH)

        pack()
        isVisible = true

        buttonUse.addActionListener(this)
        buttonAlarm.addActionListener(this)
        buttonPhone.addActionListener(this)
        buttonExit.addActionListener(this)
    }

    override fun actionPerformed(e: ActionEvent?) {
        println(e.toString())
        when (e?.source) {
            buttonUse -> {
                state.doUse(this)
            }
            buttonAlarm -> {
                state.doAlarm(this)
            }
            buttonPhone -> {
                state.doPhone(this)
            }
            buttonExit -> {
                exitProcess(0)
            }
            else -> {
                println("?")
            }
        }
    }

    override fun setClock(hour: Int) {
        val clockString = String.format("現在時刻は%02d:00", hour)
        println(clockString)
        textClock.text = clockString
        state.doClock(this, hour)
    }

    override fun changeState(state: State) {
        println("${this.state}から${state}へ状態が変化しました。")
        this.state = state
    }

    override fun callSecurityCenter(msg: String) {
        textScreen.append("call! $msg\n")
    }

    override fun recordLog(msg: String) {
        textScreen.append("record ... $msg\n")
    }
}
