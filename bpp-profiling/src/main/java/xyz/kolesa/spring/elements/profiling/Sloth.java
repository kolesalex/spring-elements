package xyz.kolesa.spring.elements.profiling;

import org.springframework.stereotype.Component;

@Component
@Profiling
public class Sloth implements Animal {

    public void voice(){
        System.out.println("Sloooow voice");
    }
}
