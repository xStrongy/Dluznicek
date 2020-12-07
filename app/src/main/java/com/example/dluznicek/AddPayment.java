package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class AddPayment extends AppCompatActivity {


    int pos;
    int position;

    ArrayList<Party> list = new ArrayList<Party>();
    Party party;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        position = getIntent().getIntExtra("position", -1);
        pos = position;
        if((ArrayList<Party>) getIntent().getSerializableExtra("list") != null)
        list = (ArrayList<Party>) getIntent().getSerializableExtra("list");
        party = list.get(position);
        list.set(position, party);
        TextView textView = (TextView) findViewById(R.id.textView13);
        textView.setText(party.getName());
    }

    public void showPopup(View view)
    {
        PopupMenu menu = new PopupMenu(this, view, 0);
        for(Person p : party.people)
        {
            menu.getMenu().add(p.getNickname());
        }
        menu.show();
    }



}