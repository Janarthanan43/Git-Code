package org.example.service;

public class ConcreteAuthenticationService implements AuthenticationService{

    @Override
    public boolean authenticate(String username, String password) {
        return true;
    }
}
