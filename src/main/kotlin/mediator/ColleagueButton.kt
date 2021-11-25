package mediator

import java.awt.Button

class ColleagueButton(caption: String) : Button(caption), Colleague {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
    }
}
