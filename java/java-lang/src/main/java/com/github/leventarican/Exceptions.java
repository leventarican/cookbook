package com.github.leventarican;

public class Exceptions {

    public void exec() {
        System.out.println("\nExceptions:");

        try {
            System.out.println(Integer.parseInt("16GB"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // java.lang.NumberFormatException: For input string: "16GB"
        }
    }
}
