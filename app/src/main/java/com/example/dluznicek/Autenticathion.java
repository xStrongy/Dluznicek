package com.example.dluznicek;

public class Autenticathion {
    private String username;
    private String password;

    public Autenticathion()
    {
        this.username = null;
        this.password = null;
    }
    public Autenticathion(String u, String p)
    {
        this.username = u;
        this.password = p;
    }
    public void setUsername(String u)
    {
        this.username = u;
    }

    public void setPassword(String p)
    {
        this.password = p;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }
}
