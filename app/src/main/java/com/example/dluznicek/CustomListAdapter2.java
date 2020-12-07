package com.example.dluznicek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<Person> items;

    public CustomListAdapter2(Context context, ArrayList<Person> items)
    {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.my_base_list_adapter2, parent, false);
        }
        Person currentItem = (Person) getItem(position);

        TextView textViewItemName = (TextView) convertView.findViewById(R.id.item_name);

        textViewItemName.setText(currentItem.getInfo());

        return convertView;
    }
}
