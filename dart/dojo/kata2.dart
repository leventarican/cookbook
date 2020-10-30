// https://www.codewars.com/kata/5506b230a11c0aeab3000c1f/train/dart

// We know the content of the evaporator (content in ml), the percentage of foam or gas lost every day (evap_per_day) and the threshold (threshold) in percentage beyond which the evaporator is no longer useful. All numbers are strictly positive.

// input
// evaporator (content in ml) - optional
// the percentage of foam or gas lost every day (evap_per_day)
// the threshold (threshold) in percentage - beyond its no longer useful

// output
// the nth day (as an integer) on which the evaporator will be out of use.
int evaporator(double content, double evap_per_day, double threshold) {
  int day = 0;
  double init_evap_per_day = evap_per_day;
  for (var i = 100.0; i > threshold; i=i-evap_per_day) {
    evap_per_day = i / 100 * init_evap_per_day;
    day++;
  }
  return day;
}

// return (log(threshold / 100) / log(1 - evap_per_day / 100)).ceil();

main(List<String> args) {
  assert(evaporator(10, 10, 10) == 22);
  assert(evaporator(10, 10, 5) == 29);
  assert(evaporator(100, 5, 5) == 59);
}
