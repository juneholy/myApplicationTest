package com.example.houlinjiang.myapplicationtest.sqlite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by houlin.jiang on 2016/4/15.
 */
public class ListAdapter extends BaseAdapter{

    private List<Person> data;

    public ListAdapter(List<Person> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null || data.size() == 0 ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position) == null ? new Person() : data.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
