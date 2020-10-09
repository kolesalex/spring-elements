package xyz.kolesa.spring.elements.prototype;

import java.awt.Color;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import lombok.SneakyThrows;

@Configuration
@ComponentScan
public class Application {

    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                //Color bean is taken according to scope
                return  color();
            }
        };
    }

    @SneakyThrows
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
