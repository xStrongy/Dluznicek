package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.security.acl.Group;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Group> groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void prihlaseni(View view)
    {
        Intent i = new Intent(getApplicationContext(), Groups.class);
        startActivity(i);
    }
}