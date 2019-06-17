int len = 18;
for (int i=0; i<len; i++) {
  int middle = i * 2 + 1;
  int leftOrRight = (len - middle) / 2;
  if (leftOrRight == 0) {
    return;
  }
  print(new String(new char[leftOrRight]).replace("\0", " "));
  print(new String(new char[middle]).replace("\0", "*"));
  print(new String(new char[leftOrRight]).replace("\0", " "));
  println();
}
