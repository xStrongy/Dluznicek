package com.example.dluznicek;

import java.io.Serializable;
import java.util.ArrayList;

public class Party implements Serializable {
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
    public String getNameOfPerson(int i)
    {
        return people.get(i).getNickname();
    }

    public int getLastId()
    {
        return people.get(people.size()-1).getId();
    }

    public int getFinalPrice(){
        int soucet = 0;
        for (Payment p : payments) {
            soucet += p.price;
        }
        return soucet;
    }
}
