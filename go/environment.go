package main

import (
	"fmt"
	"os"
)

func main() {
	// set environment variable in bash: export foo=bar

	// set environment variable in go
	os.Setenv("go", "1.14")

	fmt.Println("foo:", os.Getenv("foo"))
	fmt.Println("go:", os.Getenv("go"))
}