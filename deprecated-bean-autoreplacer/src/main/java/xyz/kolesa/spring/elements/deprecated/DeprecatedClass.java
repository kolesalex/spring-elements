package xyz.kolesa.spring.elements.deprecated;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

    Class newImpl();
}
