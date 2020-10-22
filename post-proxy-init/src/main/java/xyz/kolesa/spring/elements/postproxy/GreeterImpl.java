package xyz.kolesa.spring.elements.postproxy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class GreeterImpl implements Greeter {

    public GreeterImpl() {
        System.out.println("Phase 1: constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2: post constructor initialization (proxies are absent)");
    }

    @PostProxy
    public void initPostProxy(){
        System.out.println("Phase 3: post proxy (proxies are configured)");
    }

    @Override
    public void greet() {
        System.out.println("Hi there!");
    }
}
