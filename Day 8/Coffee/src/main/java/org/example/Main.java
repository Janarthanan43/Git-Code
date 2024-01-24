package org.example;

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
}

//Example
public class Main {
    public static void main(String[] args) {
        Coffee plainCoffee = new PlainCoffee();
        System.out.println("Description: "+plainCoffee.description());
        Coffee beatenCoffeeWithCream = new CreamDecorator(new BeatenCoffee());
        System.out.println("Description: "+beatenCoffeeWithCream.description());
        Coffee coldCoffeeWithChocolateAndBeans = new CrushedCoffeeBeansDecorator(new ChocolateDecorator(new ColdCoffee()));
        System.out.println("Description: "+coldCoffeeWithChocolateAndBeans.description());
    }
}