# create program with Make
* Make: a built-tool 
* create a `Makefile`
``` 
target: dependencies
    commands
``` 
* run with: `make`
* clean with: `make clean`

# manual steps to create a program
* all in one command
    * `-Wall`: display all warnings
``` 
gcc -g -Wall -o main main.c
``` 

1. C-preprocessor will append complete header file to file
```
gcc -E main.c -o _main.c
```
2. create assembler code (x86 64 architecture)
```
gcc -S -masm=intel _main.c
```
3. create machinecode so-called objectfile
```
as -o main.o _main.s
```
4. link objectfile with libraries with linker
```
gcc -o main main.o
```
5. execute
```
./main
```