package org.example;

public class CrushedCoffeeBeansDecorator extends CoffeeDecorator {
    public CrushedCoffeeBeansDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return 0;
    }

    public String description() {
        return coffee.description() + ",Crushed Coffee Beans";
    }
}
