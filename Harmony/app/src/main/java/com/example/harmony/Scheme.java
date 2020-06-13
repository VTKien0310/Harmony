package com.example.harmony;

class Scheme {
    private Color[] _colors;

    public Scheme(Color[] colors)
    {
        _colors = colors;
    }

    public Color getColorAtPos(int pos)
    {
        return _colors[pos];
    }

    public void setColorAtPos(int pos, Color color)
    {
        _colors[pos] = color;
    }

    public void generateColors()
    {

    }

    public void save()
    {

    }
}
