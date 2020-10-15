package xyz.kolesa.spring.elements.deprecated;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.SneakyThrows;

@Configuration
@ComponentScan
public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(Sword.class).blow();
    }
}
