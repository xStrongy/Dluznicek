package com.example.dluznicek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
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


        //if((ArrayList<Party>) getIntent().getSerializableExtra("list") != null)
        //list = (ArrayList<Party>) getIntent().getSerializableExtra("list");
        if(PrefConfig.readListFromPref(this) != null)
        list = PrefConfig.readListFromPref(this);
        listView = (ListView) findViewById(R.id.listView1);

        CustomListAdapter adapter = new CustomListAdapter(this, list);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), currentGroup.class);
                i.putExtra("groups", list);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }

    public void AddGroupWindow()
    {
        Intent i = new Intent(getApplicationContext(), AddGroup.class);
        i.putExtra("groups", list);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.CreateGroupButton:
                AddGroupWindow();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}