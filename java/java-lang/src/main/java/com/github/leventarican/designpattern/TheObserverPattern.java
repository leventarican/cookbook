package com.github.leventarican.designpattern;

public class TheObserverPattern {

    public static void main(String[] args) {
        class ExampleListener implements MessageListener {

            @Override
            public void code(MessageEvent event) {
                System.out.println(ExampleListener.class.getName() + " received event: " + event.getMessage());
            }
        }

        MessagesOrchestrator orchestrator = new MessagesOrchestrator();
        orchestrator.addListener(new ExampleListener());
        orchestrator.exec();
    }

}
