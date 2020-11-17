package com.github.leventarican;

/**
 * enums are a variation of classes that have limited functionality
 * 
 * @author levent
 */
public class Enums {
    public static void main(String[] args) {
        var selection = Paradigm.OOP;
        System.out.println(selection.getDescription());
    }
}

enum Paradigm {
    OOP(100), FUNCTIONAL(200), DECLARATIV(300);
    
    private String description;
    
    public String getDescription() {
        return description;
    }
    
    private Paradigm(int id) {
        switch(id) {
            case 100:
                description = "object oriented programming";
                break;
            case 200:
                description = "functional programming";
                break;
            case 300:
                description = "declarativ programming";
                break;
        }
    }
}
