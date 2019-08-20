package com.github.leventarican.designpattern;

import java.util.ArrayList;
import java.util.List;

public class MessagesOrchestrator {
    
    private List<MessageListener> listeners = new ArrayList<>();
    private List<MessageEvent> events = new ArrayList<>();

    public MessagesOrchestrator() {
        events.add(new MessageEvent(this, "java"));
        events.add(new MessageEvent(this, "kotlin"));
        events.add(new MessageEvent(this, "cpp"));
    }
    
    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }
    
    public void exec() {
        for (MessageListener listener : listeners) {
            for (MessageEvent event : events) {
                listener.code(event);
            }
        }
    }
    
}
