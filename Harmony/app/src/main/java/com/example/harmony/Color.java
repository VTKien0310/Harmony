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

    public Color getOpposite()
    {
        float op_h = (float) (_h + 0.5);
        if(op_h>1)
            op_h-=1;
        return new Color(op_h,_s,_l);
    }

    public Color getNext()
    {

    }

    public Color getTriad()
    {
        
    }
}
