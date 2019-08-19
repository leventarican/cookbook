package com.github.leventarican.designpattern;

import java.util.EventListener;

public interface MessageListener extends EventListener {
    void code(MessageEvent event);
}
