int input[] = {0, 1, 2, 3, 4, 5};

printArray(input);
println("now mirror:");
for (int i=0; i<input.length/2; i++) {
  int x = input[i];
  int y = input[input.length-i-1];
  input[i] = y;
  input[input.length-i-1] = x;
}
printArray(input);
System.exit(0);
