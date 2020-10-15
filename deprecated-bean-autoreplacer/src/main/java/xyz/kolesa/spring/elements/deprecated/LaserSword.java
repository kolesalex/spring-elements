package xyz.kolesa.spring.elements.deprecated;

public class LaserSword implements Sword {

    @Override
    public void blow() {
        System.out.println("Laser blow! Pshhh!");
    }
}
