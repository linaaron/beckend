package com.self.learn.validation.constraints;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Year {
    //    String message();
    String year() default "2015";
}
