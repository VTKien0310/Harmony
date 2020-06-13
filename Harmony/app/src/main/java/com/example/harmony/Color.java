package com.example.harmony;

class Color {
    private int _red = 0;
    private int _green = 0;
    private int _blue = 0;

    public Color(int red, int green, int blue)
    {
        _red = red;
        _green = green;
        _blue = blue;
    }

    public int getRed()
    {
        return _red;
    }

    public int getGreen()
    {
        return _green;
    }

    public int getBlue()
    {
        return _blue;
    }

    public void setRed(int red)
    {
        _red = red;
    }

    public void setGreen(int green)
    {
        _green = green;
    }

    public void setBlue(int blue)
    {
        _blue = blue;
    }

    public float[] rgb2hsl()
    {
        int minValue = Math.min(Math.min(_red,_green),_blue);
        int maxValue = Math.max(Math.max(_red,_green),_blue);
        int delMax = maxValue - minValue;

        float h = 0, s = 0;
        float l = (maxValue+minValue)/2;

        if(delMax != 0)
        {
            if(l < 0.5)
                s = delMax / (maxValue + minValue);
            else
                s = delMax / (2 - maxValue - minValue);

            float delRed = (((maxValue - _red) / 6) + (delMax / 2)) / delMax;
            float delGreen = (((maxValue - _green) / 6) + (delMax / 2)) / delMax;
            float delBlue = (((maxValue - _blue) / 6) + (delMax / 2)) / delMax;

            if(_red == maxValue)
                h = delBlue - delGreen;
            else if(_green == maxValue)
                h = (1/3) + delRed - delBlue;
            else if(_blue == maxValue)
                h = (2/3) + delGreen - delRed;

            if(h<0)
                h+=1;

            if(h>1)
                h-=1;
        }
        return new float[]{h, s, l};
    }

    public Color getOpposite()
    {
        float[] hsl = rgb2hsl();

        float oph = (float) (hsl[0]+0.5);
        if(oph>1)
            oph-=1;
    }

    public Color getNext()
    {

    }

    public Color getLeap()
    {
        
    }
}
