package xyz.kolesa.spring.elements.profiling;

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
        while (true) {
            Thread.sleep(1000);
            //Look up by interface is needed as class is replaced with a proxy.
            context.getBean(Animal.class).voice();
        }
    }
}
