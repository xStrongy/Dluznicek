package com.example.dluznicek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AddPayment extends AppCompatActivity {

    PopupMenu menu;
    int pos;
    int position;
    ListView listView;
    ArrayList<Integer> peoplePaidId = new ArrayList<Integer>();
    TextView textViewPeoplePaid;

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
        textViewPeoplePaid = (TextView) findViewById(R.id.textView12);
        party = list.get(position);
        list.set(position, party);
        final TextView textView = (TextView) findViewById(R.id.textView13);
        textView.setText(party.getName());

        CustomListAdapter3 adapter = new CustomListAdapter3(this, party.people);
        listView = (ListView) findViewById(R.id.listView10);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idPaid = party.people.get(position).getId();

                String [] parseLine = textViewPeoplePaid.getText().toString().split(" ");
                int tempId = Integer.parseInt(parseLine[0]);
                if(peoplePaidId.contains(idPaid)){
                    peoplePaidId.remove((Object) idPaid);
                }
                else if(!peoplePaidId.contains(idPaid) && idPaid != tempId)
                    peoplePaidId.add(idPaid);
            }
        });
    }

    public void showPopup(View view)
    {
        menu = new PopupMenu(this, view, 0);
        for(Person p : party.people)
        {
            menu.getMenu().add(p.getId() + " " +p.getNickname());
        }
        menu.show();

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CharSequence title = item.getTitle();
                TextView tv = (TextView) findViewById(R.id.textView12);
                tv.setText(title);
                TextView textView = (TextView) findViewById(R.id.textView14);
                textView.setVisibility(View.VISIBLE);
                EditText editText = (EditText) findViewById(R.id.editTextNumber);
                editText.setVisibility(View.VISIBLE);
                return false;
            }
        });
    }

    public void AddPaymentFunction(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        int castka = Integer.parseInt(editText.getText().toString());
        String[] parseLine = textViewPeoplePaid.getText().toString().split(" ");
        int idPerson = Integer.parseInt(parseLine[0]);
        EditText editDesc = (EditText) findViewById(R.id.editTextDesc);
        String desc = editDesc.getText().toString();
        Person person = party.getPersonWithId(idPerson);
        ArrayList<Person> peoplePaid = new ArrayList<>();
        peoplePaid.add(person);
        for (Integer i : peoplePaidId) {
            peoplePaid.add(party.getPersonWithId(i));
        }

        double splittedCastka = castka / peoplePaid.size();

        for (int i = 0; i < peoplePaid.size(); i++) {
            Person p = peoplePaid.get(i);
            if (i == 0) {
                p.balance += castka - splittedCastka;
            } else {
                p.balance -= splittedCastka;
            }

            for (int j = 0; j < party.people.size(); j++) {
                if (party.people.get(j) == p) {
                    party.people.set(j, p);
                }
            }
        }

        party.payments.add(new Payment(castka, desc, peoplePaid));
        Intent i = new Intent(this, currentGroup.class);
        i.putExtra("groups", list);
        i.putExtra("position", pos);
        startActivity(i);

    }


}