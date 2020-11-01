
List<int> flattenAndSort(List<List<int>> nums) {
  if (nums.isEmpty) {
    return [];
  }
  var a = nums.reduce((n, m) => n+m);
  a.sort();
  return a;
}

// List<int> flattenAndSort(List<List<int>> nums) => nums.expand((p) => p).toList()..sort();

main(List<String> args) {
  // expected: [1, 2, 3, 4, 5, 6, 100]
  flattenAndSort([[1, 3, 5], [100], [2, 4, 6]]);
  flattenAndSort([]);
}