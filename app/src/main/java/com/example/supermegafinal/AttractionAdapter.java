package com.example.supermegafinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    public AttractionAdapter(Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_attraction, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.attractionNameTextView);
        TextView descriptionTextView = convertView.findViewById(R.id.attractionDescriptionTextView);

        nameTextView.setText(currentAttraction.getName());
        descriptionTextView.setText(currentAttraction.getDescription());

        return convertView;
    }
}
