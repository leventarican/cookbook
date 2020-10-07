package com.github.leventarican.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * # JAX-RS native Client example
 * 
 * connect to a REST endpoint with javax.ws.rs.client.Client
 * consume XML or JSON
 * 
 * start quarkus app in order to run the REST endpoint / server: cookbook-webapps > quarkus > json-xml
 * 
 * https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/modules-and-dependencies.html
 * 
 * JAXB removed in Java 11
 * https://stackoverflow.com/a/61283181
 * 
 * JAX-B provider
 * https://stackoverflow.com/a/30754994
 * 
 * @author levent
 */
public class Rest {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        
        String code = client.target("http://localhost:8080/developer/code").request().get(String.class);
        System.out.println(code);
        
        Developer devXML = client.
                target("http://localhost:8080/developer/code/json-xml").
                request(MediaType.APPLICATION_XML).
                get(Developer.class);
        System.out.println(devXML.getProgrammingLanguage());
        
        Developer devJSON = client.
                target("http://localhost:8080/developer/code/json-xml").
                request(MediaType.APPLICATION_JSON).
                get(Developer.class);
        System.out.println(devJSON.getProgrammingLanguage());
    }
}
