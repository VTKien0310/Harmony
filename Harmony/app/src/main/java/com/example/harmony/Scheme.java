package com.example.harmony;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Scheme {
    private MyColor[] _colors;

    public Scheme(MyColor[] colors) {
        _colors = colors;
    }

    public MyColor getColorAtPos(int pos) {
        return _colors[pos];
    }

    public void setColorAtPos(int pos, MyColor color) {
        _colors[pos] = color;
    }

    public void generateColors()
    {

    }

    public void save(Context context) throws IOException {
        FileOutputStream fileWriter = context.openFileOutput(this.getClass().toString(), Context.MODE_PRIVATE);
        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);
        objectWriter.writeObject(this);
        objectWriter.close();
        fileWriter.close();
    }
}
