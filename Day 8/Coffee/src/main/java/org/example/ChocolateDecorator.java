package org.example;

public class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return coffee.description() + ",Chocolate";
    }
}
