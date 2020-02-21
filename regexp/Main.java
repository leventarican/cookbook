import java.util.regex.*;

// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
public class Main {
    public static void main(String[] args) {
        // String txt = "ABC_20200221_120000.file";
        String txt = "ABC_1111_222_20200221_120000.FILE";
        
        // group 2 can have char length from 8 to 10
        String pattern = "([a-zA-Z0-9[_0-9]]+)_([a-zA-Z0-9]{8,10})_([a-zA-Z0-9]+)().[fileFILE]+";
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt);
        
        System.out.println("match: " + m.matches());
        System.out.println(m.group(2));
    }
}