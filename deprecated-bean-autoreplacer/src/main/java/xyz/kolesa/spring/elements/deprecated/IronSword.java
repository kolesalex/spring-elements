package xyz.kolesa.spring.elements.deprecated;

import org.springframework.stereotype.Component;

@Component
@DeprecatedClass(newImpl = LaserSword.class)
public class IronSword implements Sword {

    public void blow() {
        System.out.println("Iron blow!");
    }
}
