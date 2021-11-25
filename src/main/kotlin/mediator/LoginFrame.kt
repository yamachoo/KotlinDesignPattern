package mediator

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import kotlin.system.exitProcess

class LoginFrame(title: String) : Frame(title), ActionListener, Mediator {
    private var checkGuest: ColleagueCheckbox? = null
    private var checkLogin: ColleagueCheckbox? = null
    private var textUser: ColleagueTextField? = null
    private var textPass: ColleagueTextField? = null
    private var buttonOk: ColleagueButton? = null
    private var buttonCancel: ColleagueButton? = null

    init {
        background = Color.lightGray
        layout = GridLayout(4, 2)

        createColleagues()

        add(checkGuest)
        add(checkLogin)
        add(Label("Username:"))
        add(textUser)
        add(Label("Password:"))
        add(textPass)
        add(buttonOk)
        add(buttonCancel)

        colleagueChanged()

        pack()
        isVisible = true
    }

    override fun createColleagues() {
        val g = CheckboxGroup()
        checkGuest = ColleagueCheckbox("Guest", g, true)
        checkLogin = ColleagueCheckbox("Login", g, false)

        textUser = ColleagueTextField("", 10)
        textPass = ColleagueTextField("", 10)
        textPass?.echoChar = '*'

        buttonOk = ColleagueButton("OK")
        buttonCancel = ColleagueButton("Cancel")

        checkGuest?.setMediator(this)
        checkLogin?.setMediator(this)
        textUser?.setMediator(this)
        textPass?.setMediator(this)
        buttonOk?.setMediator(this)
        buttonCancel?.setMediator(this)

        checkGuest?.addItemListener(checkGuest)
        checkLogin?.addItemListener(checkLogin)
        textUser?.addTextListener(textUser)
        textPass?.addTextListener(textPass)
        buttonOk?.addActionListener(this)
        buttonCancel?.addActionListener(this)
    }

    override fun colleagueChanged() {
        if (checkGuest?.state == true) {
            textUser?.setColleagueEnabled(false)
            textPass?.setColleagueEnabled(false)
            buttonOk?.setColleagueEnabled(true)
        } else {
            textUser?.setColleagueEnabled(true)
            userPassChanged()
        }
    }

    private fun userPassChanged() {
        if (textUser?.text?.isNotEmpty() == true) {
            textPass?.setColleagueEnabled(true)
            if (textPass?.text?.isNotEmpty() == true) {
                buttonOk?.setColleagueEnabled(true)
            } else {
                buttonOk?.setColleagueEnabled(false)
            }
        } else {
            textPass?.setColleagueEnabled(false)
            buttonOk?.setColleagueEnabled(false)
        }
    }

    override fun actionPerformed(e: ActionEvent?) {
        println(e.toString())
        exitProcess(0)
    }
}
