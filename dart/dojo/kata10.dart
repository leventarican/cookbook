// https://www.codewars.com/kata/562f91ff6a8b77dfe900006e/train/dart

import 'dart:math';

int movie(int card, int ticket, double perc) {
  var c = 0;
  print(pow(perc, c).ceil());
  var d = (card + ticket.toDouble()*pow(perc, c)).ceil();
  print(d);
  // ceil(price of System B) < price of System A.
  while(d > ticket*c++) {
    var t = ticket.toDouble()*pow(perc, c);
    d += t.ceil();
    print("$t; ${t.ceil()}; $d; ${ticket*c}");
  }
  print(c);
  return c;
}

main(List<String> args) {
  assert(movie(500, 15, 0.9) == 43);
  // assert(movie(0, 10, 0.95) == 2);
}