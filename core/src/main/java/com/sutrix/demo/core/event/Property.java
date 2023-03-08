package com.sutrix.demo.core.event;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value=METHOD)
@Retention(value=RUNTIME)
public @interface Property {
    String label();

    String[] value();

    String description();

    String name();

    boolean propertyPrivate();
}
