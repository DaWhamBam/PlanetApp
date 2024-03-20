package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> plantesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> plantesArrayList, Context context) {
        super(context, R.layout.item_list_layout, plantesArrayList);
        this.plantesArrayList = plantesArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Planet planets = getItem(position);

        MyViewHolder myViewHolder;
        final View result;


        if (convertView == null) {

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.tv_planetName);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.tv_moons);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.iv_planet);

            result = convertView;

            convertView.setTag(myViewHolder);

        } else {

            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;

        }

        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return result;

    }
}
