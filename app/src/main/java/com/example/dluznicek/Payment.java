package com.example.dluznicek;

import java.io.Serializable;
import java.util.ArrayList;

public class Payment implements Serializable {
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
