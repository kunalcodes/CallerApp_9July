package com.example.caller_app;

public class Contact {

    private String number;
    private String name;

    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
