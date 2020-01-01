all: main

_main.c: main.c
	cpp main.c _main.c

_main.s: _main.c
	gcc -S -masm=intel _main.c

main.o: _main.s
	as -o main.o _main.s

main: main.o
	gcc -o main main.o

clean: 
	rm main main.o _main.s _main.c