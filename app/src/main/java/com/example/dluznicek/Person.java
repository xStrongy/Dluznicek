package com.example.dluznicek;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String nickname;
    public int balance;

    Person(int id, String nickname)
    {
        this.id = id;
        this.nickname = nickname;
        this.balance = 0;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public String getInfo()
    {
        if(this.balance < 0)
            return this.id + " " + this.nickname + " dluzi " + this.balance + " Kc";
        if(this.balance > 0)
            return this.id + " " + this.nickname + " ma preplaceno " + this.balance + " Kc";
        return this.id + " " + this.nickname + " " + this.balance + " Kc";
    }

}
