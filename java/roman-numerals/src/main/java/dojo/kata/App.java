package dojo.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App 
{
    // private final static String[] ROMAN_NUMERALS = {"I", "V", "X", "L", "C"};
    private static Map<Integer, String> romanNumerals = new HashMap<Integer,String>();

    private final static int I = 1;
    private final static int V = 5;
    private final static int X = 10;
    private final static int FACTOR = 10;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public static String[] toRomanNumerals(int[] actual) {
        romanNumerals.put(1, "I");
        romanNumerals.put(5, "V");
        romanNumerals.put(10, "X");
        romanNumerals.put(50, "L");
        romanNumerals.put(100, "C");
        romanNumerals.put(500, "D");
        romanNumerals.put(1000, "M");

        ArrayList<String> numerals = new ArrayList<String>();
        for (int value : actual) {
            numerals.add(convert(value));
        }

        String[] result = numerals.toArray(new String[0]);

        for (String var : result) {
            System.out.println(var);
        }

        return result;
	}

	private static String convert(int value) {
        if(value < 4) {
            return convertI(value);
        } else if (value < 9 ) {
            return convertV(value);
        } else if (value <= 10) {
            return convertX(value);
        } else if (value <= 50) {
            return convertL(value);
        } else if (value < 499) {
            return convertC(value);
        } else if (value < 999) {
            return convertD(value);
        } else {
            return convertM(value);
        }
    }
    
    private static String convertI(int value) {
        if(value == 0) return "";
        return new String(new char[value]).replace("\0", "I");
    }

    private static String convertV(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 5]).replace("\0", "V"));
        build.append(convert(value % 5));
        return build.toString();
    }

    private static String convertX(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 10]).replace("\0", "X"));
        if(value % 10 == 9) {
            build.append("IX");
        } else {
            build.append(convert(value % 10));
        }
        return build.toString();
    }

    private static String convertL(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 50]).replace("\0", "L"));
        build.append(convert(value % 50));
        return build.toString();
    }

    private static String convertC(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 100]).replace("\0", "C"));
        if(value % 100 == 90) {
            build.append("XC");
        } else {
            build.append(convert(value % 100));
        }
        return build.toString();
    }

    private static String convertD(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 500]).replace("\0", "D"));
        build.append(convert(value % 500));
        return build.toString();
    }

    private static String convertM(int value) {
        StringBuilder build = new StringBuilder();
        build.append(new String(new char[value / 1000]).replace("\0", "M"));
        if (value % 1000 == 900) {
            build.append("CM");
        } else {
            build.append(convert(value % 1000));
        }
        return build.toString();
    }

	public static String[] run(int[] actual) {
        ArrayList<String> numerals = new ArrayList<String>();
        for (int var : actual) {
            StringBuilder build = new StringBuilder();
            
            numerals.add(conv(var, build));
        }

		return numerals.toArray(new String[0]);
    }
    
    /*
    1 	5 	10 	50 	100 	500 	1000
    I 	V 	X 	L 	C 	    D   	M
    */
    private static String conv(int var, StringBuilder build) {
        // 48 --> XLVIII
        // 49 --> XLIX
        // 39 --> XXXIX

        int current = X;
        if((var / (X*FACTOR) > 0)) current = X*FACTOR;
        if((var / (X*FACTOR*FACTOR)) > 0) current = X*FACTOR*FACTOR;

        if(current == X) build.append(new String(new char[var / X]).replace("\0", "X"));
        if(current == X*FACTOR) build.append(new String(new char[var / (X*FACTOR)]).replace("\0", "C"));
        if(current == X*FACTOR*FACTOR) build.append(new String(new char[var / (X*FACTOR*FACTOR)]).replace("\0", "M"));

        System.out.println(build.toString());
        System.out.println(current);

        int remainder = var % current;
        // if(remainder % V != 9) remainder = remainder % V;
        // if(remainder % I != 4) remainder = remainder % I;
        System.out.println(remainder);

        //  4, 9, 40, 90, 400, and 900
        if(remainder < 4) {
            build.append(new String(new char[remainder]).replace("\0", "I"));
            remainder = 0;
        } else if(remainder == 4) {
            build.append("IV");
            remainder = 0;
        } else if(remainder > 4 && remainder < 9) {
            build.append("V");
            remainder = remainder - V;
            // build.append(new String(new char[remainder-V]).replace("\0", "I"));
        } else if(remainder == 9) {
            build.append("IX");
            remainder = 0;
        } else if(remainder == 40) {
            build.append("XL");
            remainder = 0;
        } else if(remainder > 40 && remainder < 90) {
            build.append("L");
            remainder = remainder - V*FACTOR;
            // build.append(new String(new char[remainder-V*FACTOR]).replace("\0", "I"));
        } else if(remainder == 90) {
            build.append("XC");
            remainder = 0;
        } else if(remainder == 400) {
            build.append("CD");
            remainder = 0;
        } else if(remainder > 400 && remainder < 900) {
            build.append("D");
            remainder = remainder-V*FACTOR*FACTOR;
            // build.append(new String(new char[remainder-V*FACTOR*FACTOR]).replace("\0", "I"));
        } else if(remainder == 900) {
            build.append("CM");
            remainder = 0;
        }

        System.out.println(build.toString());
        System.out.println("\n\n");

        return remainder > 0 ? conv(remainder, build) : build.toString();
    }
}
