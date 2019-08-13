package com.github.leventarican;

import java.io.StringWriter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public String velocity() {
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.init();

            VelocityContext context = new VelocityContext();
            context.put("key0", "apache velocity");

            StringWriter writer = new StringWriter();
            Template t = ve.getTemplate("app.html");
            t.merge(context, writer);

            String value = writer.toString();
            System.out.println(value);
            return value;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "not what you expected";
    }
}
