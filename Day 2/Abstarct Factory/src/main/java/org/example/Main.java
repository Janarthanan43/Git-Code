package org.example;



import org.example.controller.MyController;
import org.example.service.ConcreteServiceFactory;
import org.example.service.ServiceFactory;

public class Main {
    public static void main(String[] args) {

        ServiceFactory serviceFactory = new ConcreteServiceFactory();

        MyController controller = new MyController(serviceFactory);

        controller.performOperations();
    }
}