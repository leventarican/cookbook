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

	a := byte('A')
	fmt.Println("byte is an alias for uint8:", a)

	sa := string(65)
	fmt.Println("str:", sa)

	var java_version, go_version = "11", "1.4"
	fmt.Println("java:", java_version, "go version:", go_version)

	const pi = 3.14
	fmt.Println("constant PI:",pi)

	const (
		Limit = 20
		DebugOn = true
	)

	var (
		y = 200
		z = 300
	)
	fmt.Printf("y: %v; z: %v\n", y, z)

	var i int
	var s string
	var b bool
	var f float64
	var c complex128

	fmt.Printf("type: %T\n", i)
	fmt.Printf("type: %T\n", s)
	fmt.Printf("type: %T\n", b)
	fmt.Printf("type: %T\n", f)
	fmt.Printf("type: %T\n", c)
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
	return 3, 2
}

func flow_control() {
	if true {} else {}

	x := 3.0
	switch x {
	case 0,1:
	case 2:
	case 3: fmt.Println("switch")
	}

	for i:=3; i>0; i-- {
		fmt.Println(i)
	}

	i := 0
	Go:
		fmt.Println("label and goto")
		i++
		fmt.Println(i)
		if i < 2 {
			goto Go
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

func anon_function() {
	a, b := func() (int, int) {
		fmt.Println("anonymous function")
		return 1, 2
	}()
	fmt.Println("a:", a, "b:", b)
}

func variadic_function(j ...int) {
	for i := 0; i < len(j); i++ {
		fmt.Printf("%v ", j[i])
	}
	fmt.Println()
}

func closures() func() {
	fmt.Println("#")
	return func() {
		fmt.Println("##")
	}
}

func pointer() {
	// new is a built-in function: allocate memory
	addr := new(int)
	fmt.Println("variable address:", addr)
	fmt.Println("value:", *addr)
	fmt.Println("value address:", &addr)

	copy := addr
	*copy = 1
	fmt.Println("value:", *addr)
}

func main() {
	fmt.Println("Hello, world.")

	variables()
	arrays()
	multi()
	flow_control()
	class()
	anon_function()
	pointer()
	variadic_function(1000, 2000, 3000)
	closures()()
}
