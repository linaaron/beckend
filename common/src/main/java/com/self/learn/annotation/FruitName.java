package com.self.learn.annotation;


import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@NotNull(message="not null...")
public @interface FruitName {
    String value() default "default name...";
}
