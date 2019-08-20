package com.github.leventarican.designpattern;

public class TheObserverPattern {
    public void exec() {
        class Foobar implements MessageListener {
            @Override
            public void code(MessageEvent event) {
                System.out.println(Foobar.class.getName() + " received event: " + event.getMessage());
            }
        }
        
        MessagesOrchestrator orchestrator = new MessagesOrchestrator();
        orchestrator.addListener(new Foobar());
        orchestrator.exec();
    }
}
