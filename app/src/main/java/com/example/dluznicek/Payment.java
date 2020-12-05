package com.example.dluznicek;

import java.util.ArrayList;

public class Payment {
    public int price;
    public String description;
    ArrayList<Person> people = new ArrayList<Person>();

    public Payment(int price, String description, ArrayList<Person> people)
    {
        this.price = price;
        this.description = description;
        this.people = people;
    }
}
