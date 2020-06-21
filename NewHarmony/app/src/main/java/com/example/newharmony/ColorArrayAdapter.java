package com.example.newharmony;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ColorArrayAdapter extends ArrayAdapter<MyColor> {
    Context _context;
    int _layoutResourceID;
    ArrayList<MyColor> _ExtractedColor;

    public ColorArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MyColor> objects) {
        super(context, resource);
        _context = context;
        _layoutResourceID = resource;
        _ExtractedColor = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(_context);
            convertView = layoutInflater.inflate(_layoutResourceID,parent,false);
        }

        MyColor extractedColor = _ExtractedColor.get(position);
        TextView tvColor = convertView.findViewById(R.id.tv_color);
        TextView tvCode = convertView.findViewById(R.id.tv_colorCode);
        TextView txtPercent = convertView.findViewById(R.id.tv_percentColor);
        String temp = extractedColor.getHexStr();
        tvColor.setBackgroundColor(Color.parseColor(extractedColor.getHexStr()));
        tvCode.setText(extractedColor.getHexStr());
        txtPercent.setText(extractedColor.get_percent() + "");

        return convertView;
    }

    @Override
    public int getCount()
    {
        return _ExtractedColor.size();
    }


}
