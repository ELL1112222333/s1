package org.example.aopannotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autho {
    String aopname();


}


//编写拦截规则的注解