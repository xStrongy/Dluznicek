package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.acl.Group;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Autenticathion autenticathion;
    ArrayList<Group> groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void prihlaseni(View view)
    {
        autenticathion = new Autenticathion("admin", "admin");
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("auth");
        reff.push().setValue(autenticathion);

        Intent i = new Intent(getApplicationContext(), Groups.class);
        startActivity(i);
    }
}