package com.example.newharmony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractColor extends AppCompatActivity {

    ArrayList<MyColor> _lstColor;
    ListView _lstView;
    float[] h, s, l;

    ColorArrayAdapter _myArrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_6colors);


        generateData();
        initListView();


        //send hsl to another activity to generate pallet
        _lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent generateIntent = new Intent(getApplicationContext(), GenerateColor.class);
                generateIntent.putExtra("h", h[position]);
                generateIntent.putExtra("s", s[position]);
                generateIntent.putExtra("l", l[position]);
                startActivity(generateIntent);
            }
        });

    }

    private void initListView() {
        _myArrAdapter = new ColorArrayAdapter(getBaseContext(), R.layout.listview_color, _lstColor);
        _lstView = findViewById(R.id.lst_color);
        _lstView.setAdapter(_myArrAdapter);
    }

    private void generateData() {
        Bitmap b = null;
        b = BitmapFactory.decodeResource(getResources(), R.drawable.illustration);
        Palette p = Palette.from(b).generate();

        _lstColor = new ArrayList<>();
        List<Palette.Swatch> pss;
        pss = p.getSwatches();
        int n = pss.size();
        h = new float[n];
        s = new float[n];
        l = new float[n];
        for (int j = 0; j < n; j++) {
            Palette.Swatch ps = pss.get(j);
            int population = ps.getPopulation();
            float[] hsl = ps.getHsl();


            h[j] = hsl[0];
            s[j] = hsl[1];
            l[j] = hsl[2];
            _lstColor.add(new MyColor(hsl, population));
        }
        Collections.sort(_lstColor, new DecreaseExtractedColorComparator());
    }


}