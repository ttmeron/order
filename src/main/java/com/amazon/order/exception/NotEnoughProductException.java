package com.amazon.order.exception;

public class NotEnoughProductException extends Exception{

    public NotEnoughProductException (String message){
        super(String.valueOf(message));
    }
}
