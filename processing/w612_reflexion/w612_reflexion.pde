int input[][] = {
  {1,1,1},
  {1,1,1},
  {1,0,1}
};
int input1[][] = {
  {1,1,1,0,0},
  {1,1,1,0,0},
  {1,1,1,0,0},
  {0,0,1,1,1},
  {0,1,1,1,0},
  {1,1,1,0,0}
};

int expected[][] = {
  {1,1,1},
  {1,1,1},
  {1,0,1},
  {1,0,1}
};

void setup() {
  size(800, 500);
  stroke(255);
  noLoop();
}

void draw() {
  drawPattern(input1);
  translate(300, 0);
  
  int actual[][] = reflect(input1);
  drawPattern(actual);
}

void drawPattern(int[][] pattern) {
  pushMatrix();
  for (int i=0; i<pattern.length; i++) {
    for (int j=0; j<pattern[i].length; j++) {
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

int[][] reflect(int pattern[][]) {
  // create new array with one new row. e.g. pattern[3][4] --> result[4][4]
  int increase = pattern.length / 3;
  int result[][] = new int[pattern.length+increase][pattern[pattern.length-1].length];
  
  // fill elements 1:1. e.g. pattern[3][4] --> result[3][4]
  for (int i=0; i<pattern.length; i++) {
    for (int j=0; j<pattern[i].length; j++) {
      result[i][j] = pattern[i][j];
    }
  }
  
  /*
  now fill the last elements. Mirrow the rows:
  0100
  0110
  ----
  0110
  0100
  */
  int x = 1;
  for (int i=pattern.length; i<result.length; i++) {
    for (int j=0; j<result[i].length; j++) {
      result[i][j] = result[pattern.length-x][j];
    }
    x++;
  }
  return result;
}
