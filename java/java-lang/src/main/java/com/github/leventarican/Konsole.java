package com.github.leventarican;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
Console will not work within IDE.
Therefor compile and run in shell:
compile: java Konsole.java
run: java -cp ../../..  com.github.leventarican.Konsole
 */
public class Konsole {
    public static void main( String[] args ) throws InterruptedException {
        Console console = System.console();
        if (console == null) {
            System.out.println("no console available");
            return;
        }

        String username = console.readLine("username: ");
//        console.printf("username: %s\n", str);

        System.out.print("password: ");
        char[] ch = console.readPassword();

        if (!username.equals(String.valueOf(ch))) {
            System.out.println("wrong username / password");
            return;
        }

        ArrayList<TimerTask> timerTasks = new ArrayList<>();
        Timer threadsafeTimer = new Timer();

        while (true) {
            String input = console.readLine("# ");
            if (input.equals("exit")) {
                return;
            }

            // straight forward - for now; do later refactoring
            {
                if (input.equals("help")) {
                    System.out.println("##########");
                    System.out.println("#pomodoro#");
                    System.out.println("##########");
                } else if (input.equals("create") || input.equals("c")) {
                    System.out.println("create task");
                    PomodoreTask task = new PomodoreTask();
                    timerTasks.add(task);
                    threadsafeTimer.scheduleAtFixedRate(task, 0, 1000);
                } else if (input.equals("list")) {
                    timerTasks.forEach(timerTask -> {
                        long s = (new Date().getTime() - timerTask.scheduledExecutionTime()) / 1000;
                        System.out.println(timerTask.hashCode() + ": " + s);
                    });
                } else {
                    System.out.println("exit for exit");
                }
            }

            Thread.sleep(100);
        }
    }

    /*
    A Pomodore Task as an inner class
     */
    private static class PomodoreTask extends TimerTask {
        int untilSeconds = 3;
        int counter = 0;

        @Override
        public void run() {
            if (counter++ > untilSeconds) {
                System.out.println("\nDONE");
                cancel();
            } else if (counter == 1) {
                System.out.println(repeat("", "-", untilSeconds));
            } else {
                System.out.print(">");
            }
        }
    }

    public static String repeat(String str, String con, int count) {
        for (int i = 0; i < count; i++) {
            str = str.concat(con);
        }
        return str;
    }
}