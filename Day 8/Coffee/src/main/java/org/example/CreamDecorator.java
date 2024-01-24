package org.example;

public class CreamDecorator extends CoffeeDecorator {
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return coffee.description() + ",Cream";
    }
}
