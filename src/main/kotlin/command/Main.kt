package command

import command.command.MacroCommand
import command.drawer.DrawCanvas
import command.drawer.DrawCommand
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import kotlin.system.exitProcess

fun main() {
    Main("Command Pattern Sample")
}

class Main(title: String) : JFrame(title), MouseMotionListener, WindowListener {
    private val history = MacroCommand()
    private val canvas = DrawCanvas(400, 400, history)
    private val clearButton = JButton("clear")

    init {
        this.addWindowListener(this)
        canvas.addMouseMotionListener(this)
        clearButton.addActionListener(fun(_) {
            history.clear()
            canvas.repaint()
        })

        val buttonBox = Box(BoxLayout.X_AXIS)
        buttonBox.add(clearButton)
        val mainBox = Box(BoxLayout.Y_AXIS)
        mainBox.add(buttonBox)
        mainBox.add(canvas)
        contentPane.add(mainBox)

        pack()
        isVisible = true
    }

    override fun mouseMoved(e: MouseEvent?) {}

    override fun mouseDragged(e: MouseEvent?) {
        if (e == null) return

        val cmd = DrawCommand(canvas, e.point)
        history.append(cmd)
        cmd.execute()
    }

    override fun windowClosing(e: WindowEvent?) {
        exitProcess(0)
    }

    override fun windowOpened(e: WindowEvent?) {}
    override fun windowClosed(e: WindowEvent?) {}
    override fun windowIconified(e: WindowEvent?) {}
    override fun windowDeiconified(e: WindowEvent?) {}
    override fun windowActivated(e: WindowEvent?) {}
    override fun windowDeactivated(e: WindowEvent?) {}
}
