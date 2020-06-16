package com.example.harmony;

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

    public void save()
    {

    }
}
