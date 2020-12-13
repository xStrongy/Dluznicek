package com.example.dluznicek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        String realUsername;
        String realPassword;
        final String DbUrl = "https://dluznicek-e291a-default-rtdb.europe-west1.firebasedatabase.app/";
        autenticathion = new Autenticathion("admin", "admin");
        DatabaseReference reff = FirebaseDatabase.getInstance(DbUrl).getReference().child("auth");
        //reff.push().setValue(autenticathion);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Autenticathion> auths = new ArrayList<Autenticathion>();
                Autenticathion auth = new Autenticathion();
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    auth = data.getValue(Autenticathion.class);
                    auths.add(auth);
                }

                EditText editTextl = (EditText) findViewById(R.id.editTextLogin);
                EditText editTextp = (EditText) findViewById(R.id.editTextPassword);
                TextView textView = (TextView) findViewById(R.id.textView20);
                String realUsername = editTextl.getText().toString();
                String realPassword = editTextp.getText().toString();
                String usernameFromDb = auth.getUsername();
                String passwordFromDb = auth.getPassword();

                if(realUsername.equals(usernameFromDb) && realPassword.equals(passwordFromDb))
                {
                    Intent i = new Intent(getApplicationContext(), Groups.class);
                    startActivity(i);
                }
                else
                {
                    textView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}