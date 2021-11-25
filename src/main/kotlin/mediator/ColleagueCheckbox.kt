package mediator

import java.awt.Checkbox
import java.awt.CheckboxGroup
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class ColleagueCheckbox(
    caption: String,
    group: CheckboxGroup,
    state: Boolean
) : Checkbox(caption, group, state), ItemListener, Colleague {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
    }

    override fun itemStateChanged(e: ItemEvent?) {
        mediator?.colleagueChanged()
    }
}
