package org.example.aopannotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IPLimit {
    double limitNum() default 20;  //默认每秒放入桶中的token

}