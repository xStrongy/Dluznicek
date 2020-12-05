package com.example.dluznicek;

public class Person {
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
}
