package com.example.dluznicek;

import java.util.ArrayList;

public class Party {
    private String name;
    public ArrayList<Person> people;
    public ArrayList<Payment> payments;

    public Party(String name)
    {
        this.name = name;
        people = new ArrayList<Person>();
        payments = new ArrayList<Payment>();
    }

    public String getName()
    {return this.name;}
}
