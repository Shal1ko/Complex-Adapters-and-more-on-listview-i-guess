package com.shal1ko.proekti2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class userAdapter extends BaseAdapter{

    private List<User> list;
    private LayoutInflater inflater;

    public userAdapter(Context context, List<User> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout,parent,false);
        }
        User currUser = (User)getItem(position);

        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView age = (TextView)convertView.findViewById(R.id.age);
        name.setText(currUser.getName().toString());
        age.setText(String.valueOf(currUser.getAge()));

        return convertView;

    }
}
