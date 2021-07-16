package com.github.leventarican

import javafx.event.Event
import javafx.event.EventType


class UserEvent(eventType: EventType<out Event?>?) : Event(eventType) {
    companion object {
        val ANY: EventType<UserEvent> = EventType(Event.ANY, "ANY")
        val LOGIN_SUCCEEDED: EventType<UserEvent> = EventType(ANY, "LOGIN_SUCCEEDED")
        val LOGIN_FAILED: EventType<UserEvent> = EventType(ANY, "LOGIN_FAILED")
    }
}

