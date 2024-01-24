import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeTestcase {

    @Test
    public void testCoffeeOrderingSystem() {
        // Test Plain Coffee
        Coffee plainCoffee = new PlainCoffee();
        assertEquals("Description: Plain Coffee", getFormattedCoffeeInfo(plainCoffee));

        // Test Beaten Coffee with Cream
        Coffee beatenCoffeeWithCream = new CreamDecorator(new BeatenCoffee());
        assertEquals("Description: Beaten Coffee,Cream",
                getFormattedCoffeeInfo(beatenCoffeeWithCream));

        // Test Cold Coffee with Chocolate and Crushed Coffee Beans
        Coffee coldCoffeeWithChocolateAndBeans = new CrushedCoffeeBeansDecorator(new ChocolateDecorator(new ColdCoffee()));
        assertEquals("Description: Cold Coffee,Chocolate,Crushed Coffee Beans",
                getFormattedCoffeeInfo(coldCoffeeWithChocolateAndBeans));
    }

    private String getFormattedCoffeeInfo(Coffee coffee) {
        return String.format("Description: %s", coffee.description(), coffee.description());
    }
}