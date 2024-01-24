package org.example.service;

public class ConcreteServiceFactory implements ServiceFactory{
    @Override
    public DatabaseService createDatabaseService(){
        return new ConcreteDatabaseService();
    }

    @Override
    public LoggingService createLoggingService(){
        return new ConcreteLoggingService();
    }

    @Override
    public AuthenticationService createAuthenticationService(){
        return new ConcreteAuthenticationService();
    }
}
