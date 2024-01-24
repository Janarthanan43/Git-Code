package org.example;

public class PlainCoffee implements Coffee {

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return "Plain Coffee";
    }
}
