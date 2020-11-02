// https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/dart

// p0: population at year 0 (beginning)
// aug: inhabitants coming or leaving each year
// p: poluation to surpass
// return n number of entire years needed to get a population greater or equal to p
int nbYear(int p0, double percent, int aug, int p) {
  var years = 0;
  int population = p0;
  while(population < p) {
    population = (population + population * percent/100).round() + aug;
    years++;
  }
  print(population);  
  return years;
}

// or recursion: yield ...
// int nbYear(int p0, double percent, int aug, int p) {
//   p0 = (p0 + p0 * percent/100).round() + aug;
//   print(p0);
//   if (p0 >= p) {
//     return 0;
//   }
//   return nbYear(p0, percent, aug, p);
// }

// int nbYear(int p0, double percent, int aug, int p) {
//   if (p0 >= p) { return 0;}
//   return nbYear((p0 * (100 + percent) / 100).toInt() + aug, percent, aug, p) + 1;
// }

// nbYear(a, b, c, d) => a >= d ? 0 : 1 + nbYear(a + a*b/100 + c, b, c, d);

main(List<String> args) {
  assert(nbYear(1000, 2, 50, 1200) == 3);
  // 1000 + 1000 * 0.02 + 50 => 1070 inhabitants
  // 1070 + 1070 * 0.02 + 50 => 1141
  // 1141 + 1141 * 0.02 + 50 => 1213
  // result: 3 (years)

  assert(nbYear(1500, 5, 100, 5000) == 15);
  assert(nbYear(1500000, 2.5, 10000, 2000000) == 10);
}
