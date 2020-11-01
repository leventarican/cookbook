// https://www.codewars.com/kata/5264d2b162488dc400000001/train/dart

String spinWords(String str) {
  var solution = [];
  str.split(" ").forEach((String element) {
    if (element.length > 4) {
      var reversed = element.split("").reversed.join();
      solution.add(reversed);
    } else {
      solution.add(element);
    }
  });
  return solution.join(" ");
}

// return str.split(' ').map((e)=> e.length > 4 ? e.split('').reversed.join():e).join(' ');

main(List<String> args) {
  assert(spinWords("Hey fellow warriors") == "Hey wollef sroirraw");
}
