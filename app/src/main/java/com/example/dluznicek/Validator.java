package com.example.dluznicek;

import java.util.ArrayList;

public class Validator {
    public boolean isNullorWhiteChar(String string)
    {
        if(string.isEmpty() || string.trim().isEmpty())
            return true;
        return false;
    }

    public boolean groupExists(String string, ArrayList<Party> list)
    {
        for(Party p : list)
        {
            if(p.getName().equals(string))
            {
                return true;
            }
        }
        return false;
    }
}
