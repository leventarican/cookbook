package main

import "fmt"

func variables() {
	var declaration int
	declaration = 1
	fmt.Println(declaration)
	declaration = 1e10
	fmt.Println(declaration)
	declaration = 2_000_000
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
	// byte = alias uint8
	var a_byte byte
	var also_a_byte uint8

	fmt.Printf("type: %T\n", i)
	fmt.Printf("type: %T\n", s)
	fmt.Printf("type: %T\n", b)
	fmt.Printf("type: %T\n", f)
	fmt.Printf("type: %T\n", c)
	fmt.Printf("type: %T\n", a_byte)
	fmt.Printf("type: %T\n", also_a_byte)

	// initial value is 0, false, ""
	fmt.Println("init value:", i)
	fmt.Println("init value:", b)
	fmt.Println("init value:", s)

	// type conversion
	f = float64(i+1)
	fmt.Println("conversion:", f)
	i = int(f)
	fmt.Println("conversion:", i)

	// type inference
	cx := 0.8 + 0.5i
	fmt.Println("complex128:", cx)
	fl := 3.14
	fmt.Printf("type: %T\n", fl)

	// high precision values
	const (
		Big = 1 << 100
		Small = Big >> 99	// 0010 = 2
	)
	// fmt.Println("this will overflow int:", Big*10 + 1)
}

func arrays() {
	var bits [8]int
	fmt.Println("bits:", bits)

	fibonacci := [...]int{0, 1, 1, 2, 3, 5, 8}
	fmt.Println("fixed sized array", fibonacci)

	dynamicSize := []int{3, 1, 4}
	fmt.Println("dynamic sized array = slice", dynamicSize)
	fmt.Println("dynamic sized array = slice", dynamicSize[1:2])

	var default_slice [3]int
	fmt.Println("default slice:", default_slice)

	for i, s := range dynamicSize {
		fmt.Println("i, s:", i, s)
	}
}

func maps() {
	m := make(map[int]string)
	m[0] = "go"
	m[1] = "java"
	m[2] = "cpp"
	fmt.Println("value:", m[2])

	delete(m, 1)
	v, d := m[1]
	fmt.Println("value:", v, "deleted?", !d)
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

	type Point struct {
		X int
		Y int
	}
	p := Point{3, 2}
	p.Y = 4
	fmt.Println("p.Y:", p.Y)
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

// named return values
func named() (x, y int) {
	x = 0
	y = 1
	return
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

	i := 7
	p := &i
	fmt.Println("point to i [address]:", p)
	fmt.Println("read value of i [value]:", *p)
	*p = *p + 1
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
	x,y := named()
	fmt.Println("x,y:", x, y)
	maps()
}
