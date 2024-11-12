package org.example.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "Item not found";
    }
}
