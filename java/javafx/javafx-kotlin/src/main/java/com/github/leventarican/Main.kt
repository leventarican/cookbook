package com.github.leventarican

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.text.Text
import javafx.stage.Stage


class Main : Application() {
    override fun start(stage: Stage?) {
        val title = "Hello, JavaFX ${SystemInfo.javafxVersion()}, powered by Kotlin."
        val gridPane = GridPane()
        gridPane.setMinSize(400.0, 200.0)
        gridPane.padding = Insets(16.0, 16.0, 16.0, 16.0)
        gridPane.vgap = 5.0
        gridPane.hgap = 5.0
        gridPane.alignment = Pos.CENTER

        val tvUser = Text("user")
        val tvPassword = Text("password")
        val teUser = TextField()
        val tePassword = PasswordField()
        val btLogin = Button("login")
        btLogin.style = "-fx-font: 20 arial; -fx-base: #b6e7c9;"
        val event = UserEvent(UserEvent.LOGIN_SUCCEEDED)
        btLogin.setOnMouseClicked {
            println("login")
            btLogin.fireEvent(event)
        }
        val btClear = Button("clear")
        gridPane.add(tvUser, 0, 0)
        gridPane.add(teUser, 1, 0)
        gridPane.add(tvPassword, 0, 1)
        gridPane.add(tePassword, 1, 1)
        gridPane.add(btLogin, 0, 2)
        gridPane.add(btClear, 1, 2)

        tvUser.addEventHandler(UserEvent.LOGIN_SUCCEEDED) { event ->
            println("####")
            println(event.source)
        }

        val scene = Scene(gridPane)
        stage!!.title = title
        stage!!.scene = scene
        stage!!.show()
    }
}

fun main() {
    Application.launch(Main::class.java)
}