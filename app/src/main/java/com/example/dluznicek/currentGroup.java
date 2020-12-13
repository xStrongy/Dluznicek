package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class currentGroup extends AppCompatActivity {

    ArrayList<Party> list = new ArrayList<Party>();
    Party party;
    ListView listView;
    ListView listView2;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_group);

        if((ArrayList<Party>) getIntent().getSerializableExtra("groups") != null)
            list = (ArrayList<Party>) getIntent().getSerializableExtra("groups");

        int position = getIntent().getIntExtra("position",-1);
        pos = position;
        party = list.get(position);
        final CustomListAdapter2 adapter = new CustomListAdapter2(this, party.people);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        TextView textView = (TextView) findViewById(R.id.textView8);
        textView.setText(String.valueOf(party.getFinalPrice()));
        if(party.payments.size() != 0)
        {
             CustomListAdapter4 adapter2 = new CustomListAdapter4(this, party.payments);
             listView2 = (ListView) findViewById(R.id.listViewPayments);
             listView2.setAdapter(adapter2);
        }

    }

    public void AddPersonToGroup(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView18);
        EditText edit = (EditText) findViewById(R.id.textBox1);
        String PersonNickname = edit.getText().toString();
        int NewPersonId;
        if(party.people.size() == 0)
            NewPersonId = 1;
        else
            NewPersonId = party.getLastId() + 1;
        Person p = new Person(NewPersonId, PersonNickname);


        Validator validator = new Validator();
        if(validator.isNullorWhiteChar(edit.getText().toString()) == true)
        {
            textView.setVisibility(View.VISIBLE);
            return;
        }
        else
        {
            textView.setVisibility(View.INVISIBLE);
            edit.setText("");
        }
        party.people.add(p);
        listView = (ListView) findViewById(R.id.listView1);
        CustomListAdapter2 adapter = ( CustomListAdapter2)listView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    public void SaveParty(View view)
    {

        list.set(pos, party);
        Intent i = new Intent(getApplicationContext(), Groups.class);
        //i.putExtra("list", list);
        PrefConfig.writeListInPref(getApplicationContext(), list);
        startActivity(i);
    }

    public void AddPaymentFunction(View view)
    {
        Intent i = new Intent(getApplicationContext(), AddPayment.class);
        i.putExtra("position", pos);
        i.putExtra("list", list);
        startActivity(i);
    }
}