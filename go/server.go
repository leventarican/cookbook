package main

import (
	"encoding/json"
	"net/http"
	"fmt"
)

// json is used for data transfer
type Dev struct {
	Description string `json:description`
	Lang []string `json:lang`
}

func handleRequest(w http.ResponseWriter, r *http.Request) {
	switch r.Method {
	case "GET":
		handleGet(w, r)
	default:
		fmt.Println("not implemented yet.")
	}
}

func handleGet(w http.ResponseWriter, r *http.Request) {
	fmt.Println("url path:", r.URL.Path)

	serialized := Dev {
		Lang: []string {"Python", "C++", "JavaScript"},
	}
	out, _ := json.MarshalIndent(&serialized, "", "\t")

	w.Header().Set("Content-Type", "application/json")
	w.Write(out)
	return
}

func main() {
	server := http.Server {
		Addr: "127.0.0.1:8080",
	}

	http.HandleFunc("/dev/", handleRequest)

	fmt.Println("server is running. try it.\ncurl -i -X GET http://127.0.0.1:8080/dev/\n\n")
	server.ListenAndServe()
}