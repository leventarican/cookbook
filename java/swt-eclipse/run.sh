#!/bin/bash

# Check if filename is provided
if [ $# -eq 0 ]; then
  echo "Usage: $0 <MainClassName>"
  exit 1
fi

# Main class name
MAIN_CLASS=$1

# Find all JAR files in current directory
# CLASSPATH=".:$(find . -maxdepth 1 -name "*.jar" | tr '\n' ':')"

CLASSPATH=".:./swt-4.34-gtk-linux-x86_64/swt.jar"

# Compile Java file
javac -cp "$CLASSPATH" "${MAIN_CLASS}.java"

# Check compilation status
if [ $? -ne 0 ]; then
  echo "Compilation failed"
  exit 1
fi

# Run Java application
java -cp "$CLASSPATH" "$MAIN_CLASS"
