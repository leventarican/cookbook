package dojo.kata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * count chars in a string
 * input   --> string = "this is"
 * output  --> t:1, h:1, i:2, s:2,  :1
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String count(String actual) {
        char[] characters = actual.toCharArray();
        // Map<Character, Integer> keyvalue = new HashMap<Character,Integer>();
        actual.replaceAll(" ", "_");
        Set<Character> done = new HashSet<Character>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            char current = characters[i];
            int counter = 1;
            if(!done.contains(current)) {
                for (int j = i+1; j < characters.length; j++) {
                    char next = characters[j];
                    if(current == next) {
                        counter++;
                    }
                }
                done.add(current);
                // keyvalue.put(current, counter);
                System.out.println(String.format("i=%d l=%d", i, characters.length));
                if(i == characters.length-1)
                    builder.append(current).append(":").append(counter);
                else
                    builder.append(current).append(":").append(counter).append(", ");
            }
        }

        String result = builder.toString();
        result = result.substring(0, result.length()-2);    // remove last ", "
        System.out.println(result);

        return result;
    }
}
