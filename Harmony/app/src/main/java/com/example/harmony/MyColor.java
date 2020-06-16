package com.example.harmony;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class MyColor {
    private float _h;
    private float _s;
    private float _l;

    public MyColor() {
        _h = 0;
        _s = 0;
        _l = 0;
    }

    public MyColor(float h, float s, float l) {
        _h = h;
        _s = s;
        _l = l;
    }

    public float get_h() {
        return _h;
    }

    public void set_h(float h) {
        _h = h;
    }

    public float get_s() {
        return _s;
    }

    public void set_s(float s) {
        _s = s;
    }

    public float get_l() {
        return _l;
    }

    public void set_l(float l) {
        _l = l;
    }

    // get the opposite color on the color wheel
    public MyColor getOpposite() {
        float op_h = _h + 180;
        if (op_h > 360)
            op_h -= 360;
        return new MyColor(op_h, _s, _l);
    }

    // get the next color on the color wheel
    public MyColor getNext() {
        float next_h = _h + 10;
        if (next_h > 360)
            next_h -= 360;
        return new MyColor(next_h, _s, _l);
    }

    // get the previous color on the color wheel
    public MyColor getPrevious() {
        float prev_h = _h + 10;
        if (prev_h < 0)
            prev_h += 360;
        return new MyColor(prev_h, _s, _l);
    }

    // increase color saturation
    public void increaseSaturation() {
        if (_s != 100)
            _s++;
    }

    // decrease color saturation
    public void decreaseSaturation() {
        if (_s != 0)
            _s--;
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

    public void saveToFile(Context context) throws IOException {
        FileOutputStream fileWriter = context.openFileOutput(this.getClass().toString(), Context.MODE_PRIVATE);
        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);
        objectWriter.writeObject(this);
        objectWriter.close();
        fileWriter.close();
    }
}
