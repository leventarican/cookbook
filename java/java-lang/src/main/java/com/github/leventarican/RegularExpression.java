package com.github.leventarican;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public void exec() {
        String search = "<value>the content from 01.01.1970.</value>";
        String regex = "<value>.*</value>";
        boolean matches = search.matches(regex);
        
        System.out.println(matches);
        
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher("42");
        System.out.println(matcher.find());
    }
}
