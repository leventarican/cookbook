package com.github.leventarican.designpattern.iterator;

public class IteratorDemo {
    public void exec() {
        String[] data = {"python", "cpp"};
        TheIterator it = new TheIterator(data);
        IteratorForTheIterator elements = it.getElements();
        while (elements.hasNext()) {
            String next = elements.next();
            System.out.println(">> "+ next);
        }
    }
}
