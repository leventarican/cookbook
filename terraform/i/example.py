import json
import sys

def main(data):
    a = data["a"]
    if a == "example-data":
        x = {
          "key0": "value0",
          "key1": "value1"
        }
        print(json.dumps(x))
    else:
        x = {
            "key0": "no input",
            "key1": "no input1",
        }
        print(json.dumps(x))

if __name__ == "__main__":
    data = json.loads(sys.stdin.readline())
    try:
        main(data)
    except Exception as e:
        print("ERROR")
        raise e
