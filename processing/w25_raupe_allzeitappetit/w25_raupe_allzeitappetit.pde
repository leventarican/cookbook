size(450, 320);
noStroke();
background(255);

color r = color(255, 0, 0);
color g = color(0, 255, 0);
color b = color(0, 0, 255);
color yellow = color(255, 255, 0);

// #####################################################

strokeWeight(1);
stroke(0);
fill(g);
int radius = 50;
int x = 100;
int y = 100;
fill(g);
ellipse(x-20, y-40, radius, radius);

fill(255);
ellipse(x-40, y-50, radius/3, radius/3);
ellipse(x-25, y-50, radius/3, radius/3);
fill(0);
ellipse(x-30, y-50, radius/10, radius/10);
ellipse(x-35, y-50, radius/10, radius/10);

fill(g);
pushMatrix();
for (int i=1; i<=5; i++) {
  ellipse(x, y, radius, radius);
  if (i % 2 != 0) {
    translate(radius/4*3,radius/4);
  } else {
    translate(radius/4*3,-radius/4);
  }
  
}
popMatrix();
