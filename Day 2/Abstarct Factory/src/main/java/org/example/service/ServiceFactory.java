package org.example.service;

public interface ServiceFactory {
    DatabaseService createDatabaseService();
    LoggingService createLoggingService();
    AuthenticationService createAuthenticationService();
}
