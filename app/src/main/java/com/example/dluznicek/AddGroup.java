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
        if((ArrayList<Party>) getIntent().getSerializableExtra("groups") != null)
        groups = (ArrayList<Party>) getIntent().getSerializableExtra("groups");
        /*FileInputStream fis;
        try {
            fis = openFileInput("groups.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            groups = (ArrayList<Party>) ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/

    }

    public void CreateGroup(View view)
    {
        EditText edit = (EditText) findViewById(R.id.textBox1);
        String partyName = edit.getText().toString();
        EditText edit2 = (EditText) findViewById(R.id.textBox2);
        String personName = edit2.getText().toString();
        Party p = new Party(partyName);
        Person pe = new Person(1, personName);
        p.people.add(pe);
        groups.add(p);


        /*try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("groups.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(groups);
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }*/
        Intent i = new Intent(getApplicationContext(), Groups.class);
        i.putExtra("list", groups);
        startActivity(i);
    }
}