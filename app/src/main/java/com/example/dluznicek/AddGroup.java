package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        Validator validator = new Validator();
        String groupName = edit.getText().toString();
        if(validator.isNullorWhiteChar(groupName) == true)
        {
            TextView textView = (TextView) findViewById(R.id.textView19);
            textView.setText("Musis vyplnit název skupiny");
            textView.setVisibility(View.VISIBLE);
            return;
        }
        if(validator.groupExists(groupName, groups) == true)
        {
            TextView textView = (TextView) findViewById(R.id.textView19);
            textView.setText("Skupina z danym nazvem uz existuje");
            textView.setVisibility(View.VISIBLE);
            return;
        }
        Party p = new Party(partyName);
        groups.add(p);


        Intent i = new Intent(getApplicationContext(), Groups.class);
        //i.putExtra("list", groups);
        PrefConfig.writeListInPref(getApplicationContext(), groups);
        startActivity(i);
    }
}