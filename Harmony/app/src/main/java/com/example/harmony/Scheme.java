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
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        _colors[pos] = new Color(r, g, b);
    }

    public void generateColors()
    {

    }

    public void save()
    {

    }
}
