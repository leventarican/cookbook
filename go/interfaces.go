package main

import "fmt"

type ext_int int

type Inter interface {
	Face() int
}

// a method
// like extension function in kotlin
func (ei ext_int) Face() int {
	return int(ei) * 100
}

func main() {
	var empty_interface interface{}
	fmt.Printf("type: %T\n", empty_interface)

	empty_interface = 7
	fmt.Printf("type: %T\n", empty_interface)

	var v ext_int
	v = 7
	v.Face()
	fmt.Println("v:", v)

	var i Inter
	i = v
	fmt.Println("i:", i.Face())
}