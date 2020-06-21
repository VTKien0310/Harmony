package com.example.newharmony;

import android.graphics.Color;

import androidx.core.graphics.ColorUtils;

import java.util.Random;

class MyColor implements Comparable<MyColor> {
    private float _h;
    private float _s;
    private float _l;
    private int _percent;

    @Override
    public int compareTo(MyColor o) {
        return this._percent - o._percent;
    }

    public MyColor(float h, float s, float l) {
        _h = h;
        _s = s;
        _l = l;
    }

    public MyColor(float[] hsl, int percent) {
        _h = hsl[0];
        _s = hsl[1];
        _l = hsl[2];
        _percent = percent;
    }

    public int get_percent() {
        return _percent;
    }

    public float[] get() {
        return new float[]{_h, _s, _l};
    }

    public void set(float[] hsl) {
        _h = hsl[0];
        _s = hsl[1];
        _l = hsl[2];
    }

    // get the opposite color on the color wheel
    public MyColor getOpposite() {
        float op_h = _h + 180;
        if (op_h > 360)
            op_h -= 360;
        return new MyColor(op_h, _s, _l);
    }

    //get hexString from h,l,s
    public String getHexStr() {
        //HSL
        int color = ColorUtils.HSLToColor(new float[]{_h, _s, _l});
        //RGB
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        //return hex string
        return String.format("#%02x%02x%02x", red, green, blue);
    }

    // get 2 other colors on the color wheel that are analogous
    public MyColor[] getAnalogs() {
        float ana1_h = _h + 30, ana2_h = _h - 30;

        if (ana1_h > 360)
            ana1_h -= 360;
        if (ana2_h < 0)
            ana2_h += 360;

        MyColor ana1 = new MyColor(ana1_h, _s, _l), ana2 = new MyColor(ana2_h, _s, _l);
        return new MyColor[]{ana1, ana2};
    }

    // get 2 other colors on the color wheel that make a triangle
    public MyColor[] getTriad() {
        float tri1_h = _h + 120, tri2_h = _h - 120;

        if (tri1_h > 360)
            tri1_h -= 360;
        if (tri2_h < 0)
            tri2_h += 360;

        MyColor tri1 = new MyColor(tri1_h, _s, _l), tri2 = new MyColor(tri2_h, _s, _l);
        return new MyColor[]{tri1, tri2};
    }

    // get a different shade of the color
    public MyColor getDifferentShade() {
        Random rd = new Random();
        float new_s = rd.nextFloat(),
                new_l = rd.nextFloat();
        return new MyColor(_h, new_s, new_l);
    }

//    public void saveToFile(Context context) throws IOException {
//        FileOutputStream fileWriter = context.openFileOutput(this.getClass().toString(), Context.MODE_PRIVATE);
//        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);
//        objectWriter.writeObject(this);
//        objectWriter.close();
//        fileWriter.close();
//    }
}
