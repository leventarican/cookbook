package main

import "fmt"

func Demo() (a int) {
	return 1*2
}

func main() {
	fmt.Println("Demo result:", Demo())
	fmt.Println("test with: go test")
}