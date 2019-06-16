int input[][] = {
  {0,0,0,0},
  {0,1,0,0},
  {0,1,0,1}
};

int expected[][] = {
  {0,0,0,0},
  {0,0,1,0},
  {1,0,1,0}
};

void setup() {
  size(800, 300);
  stroke(255);
  noLoop();
}

void draw() {
  drawPattern(input);
  translate(250, 0);
  
  drawPattern(expected);
  translate(250, 0);
  
  int actual[][] = mirror(input);
  drawPattern(actual);
}

void drawPattern(int[][] pattern) {
  pushMatrix();
  for (int i=0; i<3; i++) {
    for (int j=0; j<4; j++) {
      if (pattern[i][j] == 1) {
        fill(0);
      } else {
        fill(255);
      }
      rect(j*(50+5), i*(50+5), 50, 50, 3);
    }
  }
  popMatrix();
}

int[][] mirror(int pattern[][]) {
  for (int i=0; i<pattern.length; i++) {
    for (int j=0; j<pattern[i].length/2; j++) {
      int x = pattern[i][j];
      int y = pattern[i][pattern[i].length-j-1];
      pattern[i][j] = y;
      pattern[i][pattern[i].length-j-1] = x;
    }
  }
  return pattern;
}
