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

    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(people.get(0).getId() + " " + people.get(0).getNickname() + " platil: " + this.description + " (" + this.price + ") za: ");
        for (int i = 1;i<people.size();i++) {
            if(i < people.size())
                sb.append(people.get(i).getId() + " " + people.get(i).getNickname() + ", ");
            else
                sb.append(people.get(i).getId() + " " + people.get(i).getNickname() + ".");
        }
        return sb.toString();
    }
}
