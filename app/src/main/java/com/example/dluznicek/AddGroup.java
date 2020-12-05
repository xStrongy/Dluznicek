package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddGroup extends AppCompatActivity {

    ArrayList<Party> groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        groups = new ArrayList<Party>();

        FileInputStream fis;
        try {
            fis = openFileInput("groups");
            ObjectInputStream ois = new ObjectInputStream(fis);
            groups = (ArrayList<Party>) ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void CreateGroup(View view)
    {
        EditText edit = (EditText) findViewById(R.id.textBox1);
        String name = edit.getText().toString();
        Party p = new Party(name);
        groups.add(p);

        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("groups");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(groups);
            out.close();
            fileOut.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Intent i = new Intent(getApplicationContext(), Groups.class);
        startActivity(i);
    }
}