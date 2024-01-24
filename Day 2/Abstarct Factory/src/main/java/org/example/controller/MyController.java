package org.example.controller;

import org.example.service.AuthenticationService;
import org.example.service.DatabaseService;
import org.example.service.LoggingService;
import org.example.service.ServiceFactory;

public class MyController {
    private final DatabaseService databaseService;
    private final LoggingService loggingService;
    private final AuthenticationService authenticationService;

    public MyController(ServiceFactory serviceFactory){
        this.databaseService=serviceFactory.createDatabaseService();
        this.loggingService=serviceFactory.createLoggingService();
        this.authenticationService= serviceFactory.createAuthenticationService();
    }

    public void performOperations(){
        databaseService.connect();
        System.out.println("Connected to the database.");
        loggingService.log("Hello, Jeeva");
        System.out.println("Logged a message.");
        boolean isAuthenticated = authenticationService.authenticate("Jeeva", "Kumar");
        if (isAuthenticated){
            System.out.println("User authenticated successfully.");
        }else{
            System.out.println("Authentication failed.");
        }
    }

}
