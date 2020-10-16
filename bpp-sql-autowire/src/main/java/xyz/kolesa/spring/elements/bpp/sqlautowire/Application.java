package xyz.kolesa.spring.elements.bpp.sqlautowire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.SneakyThrows;

@SpringBootApplication
public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);
        String result = context.getBean(Dao.class).select();
        System.out.println(result);
    }
}
