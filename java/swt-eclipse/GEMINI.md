# Project Overview

This project is a collection of simple Java applications demonstrating the use of the Eclipse Standard Widget Toolkit (SWT) for creating graphical user interfaces. The applications, or "Katas", create windows with simple animations, such as moving balls that bounce off the boundaries of the window.

The project is set up to be developed and run from the command line, with dependencies managed manually.

# Building and Running

The project includes a shell script, `run.sh`, to compile and run the Java applications.

**To compile and run a specific Kata:**

```bash
./run.sh <ClassName>
```

For example, to run `Kata0`:

```bash
./run.sh Kata0
```

This will compile `Kata0.java` and then execute the compiled class.

The `README.md` file also provides manual compilation and execution commands:

**Using the included SWT zip release:**

```bash
javac -cp "./swt-4.34-gtk-linux-x86_64/swt.jar" Main.java
java -cp ".:./swt-4.34-gtk-linux-x86_64/swt.jar" Main
```

**Using the Maven jar:**

```bash
javac -cp "org.eclipse.swt.gtk.linux.x86_64-3.128.0.jar" Main.java
java -cp ".:org.eclipse.swt.gtk.linux.x86_64-3.128.0.jar" Main
```

## Troubleshooting

The `README.md` file notes a potential issue with the SWT jar being signed. If you encounter a `SecurityException`, you may need to remove the signature files from the jar:

```bash
zip -d ./swt-4.34-gtk-linux-x86_64/swt.jar 'META-INF/*.SF' 'META-INF/*.RSA' 'META-INF/*.DSA'
```

# Development Conventions

*   The code is written in Java.
*   Graphical user interfaces are built using the SWT framework.
*   Each `Kata` is a self-contained application with a `main` method.
*   The applications use a simple animation loop with `display.timerExec` for updating the UI.
