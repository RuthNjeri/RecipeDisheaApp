package com.example.waiganjo.nihondishes;

/**
 * Created by Waiganjo on 11/19/2015.
 */

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Dish> data;//modify here
    public CustomAdapter(Context context, ArrayList<Dish> data) //modify here
    {
        this.mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual movie
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);//modify here
            viewHolder.imageviewdish = (ImageView) convertView.findViewById(R.id.imageView);//modify here
//check on changing the font Typeface tf=Typeface.createFromAsset(mcontext.getAssets(),"fonts/abc.ttf");
           // viewHolder.textViewTitle.setTypeface(tf);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Dish b = data.get(position);//modify her
        viewHolder.textViewTitle.setText(b.getTitle());//modify here
        viewHolder.imageviewdish.setImageResource(b.getImage());//modify here

        return convertView;
    }
    static class ViewHolder {
        TextView textViewTitle;//modify here
        ImageView imageviewdish;//modify here

    }

}