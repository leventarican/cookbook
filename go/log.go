package main

import (
	"log"
)

func init() {
	log.Println("init: advanced logging")
	log.SetPrefix("TRACE ")
	log.SetFlags(log.Ldate | log.Lmicroseconds | log.Lshortfile)
}

func main() {
	log.Println("main")

	// terminate program with os.Exit(1)
	log.Fatalln("fatal")

	// panic() and stack trace
	log.Panicln("panic")
}
