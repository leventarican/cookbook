size(450, 320);
noStroke();
background(255);

color r = color(255, 0, 0);
color g = color(0, 255, 0);
color b = color(0, 0, 255);
color y = color(255, 255, 0);

fill(r);
rect(10,10,100,300);

fill(g);
ellipse(200,320/2,100,100);

strokeWeight(10);
stroke(b);
line(310, 10, 310, 300);

strokeWeight(1);
noStroke();
fill(y);
triangle(400, 10, 370, 310, 440, 310);
