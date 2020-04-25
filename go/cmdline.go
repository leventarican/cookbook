package main

import (
	"fmt"
	"flag"
	"log"
)

// go run cmdline.go -h
// go run cmdline.go --help
// go run cmdline.go number=0
// go run cmdline.go debug=false
// go run cmdline.go 1 2 3
func main() {
	env := flag.String("env", "dev", "dev, staging, prod")
	number := flag.Int("number", 2, "how must loops?")
	debug := flag.Bool("debug", true, "debug on / off")
	flag.Parse()

	if *debug {
		log.Println("DEBUG ON")
	}

	fmt.Println("env:", *env)
	fmt.Println("debug:", *debug)

	if len(flag.Args()) > 0 {
		for i:=0; i < len(flag.Args()); i++ {
			if *debug {
				log.Println("args:", flag.Args()[i])
			}
		}
	}

	for i:=0; i < *number; i++ {
		fmt.Printf("number: %v; %v\n", *number, i)
	}
}