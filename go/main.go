package main

import "fmt"

func variables() {
	var declaration int
	declaration = 1
	fmt.Println(declaration)

	allInOne := 2
	fmt.Println("infer type, declar, assign:", allInOne)

	var unsignedInt uint = 256;
	fmt.Println(unsignedInt)

	b := byte('A')
	fmt.Println("byte is an alias for uint8:", b)
}

func arrays() {
	var bits [8]int
	fmt.Println("bits:", bits)

	fibonacci := [...]int{0, 1, 1, 2, 3, 5, 8}
	fmt.Println("fixed sized array", fibonacci)

	dynamicSize := []int{3, 1, 4}
	fmt.Println("dynamic sized array", dynamicSize)
}

func multi() (a, b int) {
	return 3, 1
}

func flow_control() {
	if true {

	} else {

	}

	x := 3.0
	switch x {
	case 0,1:
	case 2:
	case 3: fmt.Println("switch")
	}
}

func class() {
	fmt.Println("there is no class type. instead structs is used. like js.")
	type developer struct {
		name string
		programmingLanguage []string
	}

	dev := developer{"go", []string{"go", "rust"}}
	fmt.Println(dev.name)
	fmt.Println(dev.programmingLanguage[0])
}

func main() {
	fmt.Println("Hello, world.")

	variables()
	arrays()
	multi()
	flow_control()
	class()
}
