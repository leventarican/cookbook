package main

import ( "encoding/xml"; "fmt"; "os"; "io/ioutil" )

/*
data.xml

<dev>
    <lang>java</lang>
    <lang>kotlin</lang>
    <lang>python</lang>
    <lang>go</lang>
</dev>
*/

// XMLName and Lang has to be uppercase: convention over code?!
type Dev struct {
	XMLName xml.Name `xml:"dev"`
	Lang []string `xml:"lang"`
}

func main() {
	fmt.Println("xml parsing.")
	file, err := os.Open("data.xml")
	if err != nil {
		fmt.Println("error during file opening:", err)
		return 
	}
	// defer (wait with func execution) the closing until main function returns
	defer file.Close()

	// data, _ := ioutil.ReadAll(file)
	data, err := ioutil.ReadAll(file)
	if err != nil {
		fmt.Println("error during file reading:", err)
		return 
	}

	var deserialized Dev
	xml.Unmarshal(data, &deserialized)

	fmt.Println(deserialized)
    for i := 0; i < len(deserialized.Lang); i++ {
        fmt.Println("#", deserialized.Lang[i])
    }
}