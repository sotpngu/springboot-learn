package com.example.learn.annotation;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Document
public @interface Column {
    String value() default "";
}
