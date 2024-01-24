package org.example;

public class ColdCoffee implements Coffee {

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return "Cold Coffee";
    }
}
