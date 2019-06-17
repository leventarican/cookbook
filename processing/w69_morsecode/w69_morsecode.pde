surface.setVisible(false);

println("morsecode");

HashMap<Character,String> mc = new HashMap<Character,String>();
mc.put('a', ".-");
mc.put('j', ".---");
mc.put('v', "...-");
String input = "java";
print(input + ": ");
for (int i=0; i<input.length(); i++) {
  Character c = input.charAt(i);
  print( mc.get(c) );
}
