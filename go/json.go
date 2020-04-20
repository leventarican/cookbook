package main

import ( "encoding/json"; "fmt"; "os"; "io/ioutil" )

/*
{
	"description" : "programming languages",
	"lang" : [
		"python",
		"java",
		"go"
	]
}
*/

type Dev struct {
	Description string `json:description`
	Lang []string `json:lang`
}

func main() {
	file, _ := os.Open("data.json")
	defer file.Close()
	data, _ := ioutil.ReadAll(file)

	var dev Dev
	json.Unmarshal(data, &dev)
	fmt.Println(dev)

	createJSON()
}

func createJSON() {
	serialized := Dev {
		Lang: []string {"Python", "C++", "JavaScript"},
	}
	out, _ := json.MarshalIndent(&serialized, "", "\t")
	_ = ioutil.WriteFile("serialized.json", out, 0644)
}