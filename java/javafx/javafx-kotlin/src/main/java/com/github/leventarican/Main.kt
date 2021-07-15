package com.github.leventarican

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage?) {
        val javafxVersion = SystemInfo.javafxVersion()

        val label = Label("Hello, JavaFX $javafxVersion, powered by Kotlin.")
        val scene = Scene(StackPane(label), 640.0, 480.0)
        stage!!.scene = scene
        stage!!.show()
    }

}

fun main() {
    Application.launch(Main::class.java)
}