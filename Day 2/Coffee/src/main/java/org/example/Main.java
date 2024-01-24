package org.example;

interface Coffee{
    String description();
}

class PlainCoffee implements Coffee{

    public String description(){
        return "Plain Coffee";
    }
}

class BeatenCoffee implements Coffee{

    public String description(){
        return "Beaten Coffee";
    }
}

class ColdCoffee implements Coffee{

    public String description(){
        return "Cold Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
}

class CreamDecorator extends CoffeeDecorator{
    public CreamDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+",Cream";
    }
}

class ChocolateDecorator extends CoffeeDecorator{
    public ChocolateDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+",Chocolate";
    }
}

class CrushedCoffeeBeansDecorator extends CoffeeDecorator{
    public CrushedCoffeeBeansDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+",Crushed Coffee Beans";
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