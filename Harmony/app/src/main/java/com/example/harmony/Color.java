package com.example.harmony;

class Color {
    private float _h;
    private float _s;
    private float _l;

    public Color()
    {
        _h = 0;
        _s = 0;
        _l = 0;
    }

    public Color(float h, float s, float l)
    {
        _h = h;
        _s = s;
        _l = l;
    }

    public float get_h()
    {
        return _h;
    }

    public float get_s()
    {
        return _s;
    }

    public float get_l()
    {
        return _l;
    }

    public void set_h(float h)
    {
        _h = h;
    }

    public void set_s(float s)
    {
        _s = s;
    }

    public void set_l(float l)
    {
        _l = l;
    }

    // get the opposite color on the color wheel
    public Color getOpposite()
    {
        float op_h = (float) (_h + 180);
        if(op_h>360)
            op_h-=360;
        return new Color(op_h,_s,_l);
    }

    public Color getNext()
    {

    }

    // get 2 other colors on the color wheel that make a triangle
    public Color[] getTriad()
    {
        float tri1_h = _h + 120, tri2_h = _h - 120;

        if(tri1_h>360)
            tri1_h-=360;
        if(tri2_h<0)
            tri2_h+=360;

        Color tri1 = new Color(tri1_h,_s,_l), tri2 = new Color(tri2_h,_s,_l);
        return new Color[]{tri1, tri2};
    }
}
