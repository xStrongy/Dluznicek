package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Groups extends AppCompatActivity {

    ListView listView;
    public ArrayList<Party> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        list = new ArrayList<Party>();

        FileInputStream fis;
        try {
            fis = openFileInput("groups");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Party>) ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        listView = (ListView) findViewById(R.id.listView1);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

            Log.d("Pozdrav:", "AHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOj**************************************");
            if(list.size() == 0)
                Log.d("pozdrav: ", "Pzradnyyyyyyyyyyyyyyyyyy***************************************");
        for(Party p : list)
        {
            Log.d("nazevvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv", p.getName());
        }

    }

    public void AddGroupWindow(View view)
    {
        Intent i = new Intent(getApplicationContext(), AddGroup.class);
        startActivity(i);
    }

}