package com.github.leventarican.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Levent
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeveloperAnnotation {
    String name();
    String programmingLanguage() default "java";
}
