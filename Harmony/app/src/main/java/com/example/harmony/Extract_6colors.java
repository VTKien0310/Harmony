package com.example.harmony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Extract_6colors extends AppCompatActivity {

    ArrayList<ExtractedColor> _lstColor;
    ListView _lstView;
    ColorArrayAdapter _myArrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_6colors);

        generateData();
        initListView();
    }

    private void initListView(){
        _myArrAdapter = new ColorArrayAdapter(getBaseContext(),R.layout.listview_color,_lstColor);
        _lstView = findViewById(R.id.lst_color);
        _lstView.setAdapter(_myArrAdapter);
    }

    private void generateData(){

        Bitmap b = null;
        b = BitmapFactory.decodeResource(getResources(), R.drawable.illustration);
        Palette p = Palette.from(b).generate();


        List<Palette.Swatch> pss;
        List<String> colorHex;
        int[] population;
        pss = p.getSwatches();
        int n = pss.size();
        population = new int[n];
        _lstColor = new ArrayList<>();

        for(int j = 0; j < n; j++) {
            Palette.Swatch ps = pss.get(j);
            colorHex.add(Integer.toHexString(ps.getRgb()));
            colorHex = "#" + colorHex.substring(2,colorHex.length());
            population[j] = ps.getPopulation();

        }
        Collections.sort(_lstColor, (new DecreaseExtractedColorComparator()));
    }
}