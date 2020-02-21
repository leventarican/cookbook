import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String txt = "ABC_000_20200221.file";
        String pattern = "([a-zA-Z0-9]+)_([a-zA-Z0-9]+)_([a-zA-Z0-9]+).file";
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt);
        
        System.out.println("match: " + m.matches());
        System.out.println(m.group(3));
    }
}