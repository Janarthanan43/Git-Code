package org.example;

public class BeatenCoffee implements Coffee {

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return "Beaten Coffee";
    }
}
