package com.example.ProductMicroService.Exception;

public class PriceException extends RuntimeException{
    public PriceException(String msg)
    {
        super(msg);
    }
}
