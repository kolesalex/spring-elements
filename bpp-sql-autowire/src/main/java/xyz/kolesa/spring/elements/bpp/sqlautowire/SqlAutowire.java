package xyz.kolesa.spring.elements.bpp.sqlautowire;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SqlAutowire {

    String value();
}
