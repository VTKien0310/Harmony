package com.example.harmony;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Scheme {
    private MyColor[] _colors;

    // get positions of locked colors
    private int[] getLockersPos(int[] lockers) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < lockers.length; i++)
            if (lockers[i] == 1)
                pos.add(i);
        int[] result = new int[pos.size()];
        for (int i = 0; i < pos.size(); i++)
            result[i] = pos.get(i);
        return result;
    }

    // generate a completely new scheme
    private void locked_0() {
        Random rd = new Random();
        for (int i = 0; i < 6; i++) {
            float h = rd.nextInt(101),
                    s = rd.nextInt(101),
                    l = rd.nextInt(101);
            _colors[i] = new MyColor(h, s, l);
        }
    }

    // get the opposite of the locked color
    // and generate triads from the locked color and the opposite color
    private void locked_1(int[] lockersPos) {
        MyColor opposite = _colors[lockersPos[0]].getOpposite();
        MyColor[] triad1 = _colors[lockersPos[0]].getTriad(),
                triad2 = opposite.getTriad(), newColors = new MyColor[5];
        newColors[0] = triad1[0];
        newColors[1] = triad1[1];
        newColors[2] = opposite;
        newColors[3] = triad2[0];
        newColors[4] = triad2[1];

        // set new colors to scheme while keeping the locked color
        for (int i = 0, j = 0; i < 6; i++) {
            if (i == lockersPos[0])
                continue;
            else {
                _colors[i] = newColors[j];
                j++;
            }
        }
    }

    // get analogous of locked colors
    private void locked_2(int[] lockersPos) {
        MyColor[] ana1 = _colors[lockersPos[0]].getAnalogs(),
                ana2 = _colors[lockersPos[1]].getAnalogs(),
                newColors = new MyColor[4];
        newColors[0] = ana1[0];
        newColors[1] = ana1[1];
        newColors[2] = ana2[0];
        newColors[3] = ana2[1];

        // set new colors to scheme while keeping the locked colors
        for (int i = 0, j = 0; i < 6; i++) {
            if (i == lockersPos[0] || i == lockersPos[1])
                continue;
            else {
                _colors[i] = newColors[j];
                j++;
            }
        }
    }

    // get opposite of locked colors
    private void locked_3(int[] lockersPos) {
        MyColor opp1 = _colors[lockersPos[0]].getOpposite(),
                opp2 = _colors[lockersPos[1]].getOpposite(),
                opp3 = _colors[lockersPos[2]].getOpposite(),
                newColors[] = new MyColor[3];
        newColors[0] = opp1;
        newColors[1] = opp2;
        newColors[2] = opp3;

        // set new colors to scheme while keeping the locked colors
        for (int i = 0, j = 0; i < 6; i++) {
            if (i == lockersPos[0] || i == lockersPos[1] || i == lockersPos[2])
                continue;
            else {
                _colors[i] = newColors[j];
                j++;
            }
        }
    }


    private void locked_more(int[] lockersPos) {
        //Todo: implement
    }

    // Default constructor generates a completely new color scheme
    public Scheme() {
        int[] dummy = {};
        generateColors(dummy);
    }

    public Scheme(MyColor color) {
        _colors[0] = color;
        int[] lockers = {1, 0, 0, 0, 0, 0};
        generateColors(lockers);
    }

    public Scheme(MyColor[] colors) {
        _colors = colors;
    }

    public MyColor getColorAtPos(int pos) {
        return _colors[pos];
    }

    public void setColorAtPos(int pos, MyColor color) {
        _colors[pos] = color;
    }

    // generate new colors for scheme
    public void generateColors(int[] lockers) {
        int[] lockersPos = getLockersPos(lockers);

        switch (lockersPos.length) {
            case 0:
                locked_0();
                break;
            case 1:
                locked_1(lockersPos);
                break;
            case 2:
                locked_2(lockersPos);
                break;
            case 3:
                locked_3(lockersPos);
                break;
            default:
                locked_more(lockersPos);
                break;
        }
    }

    public void save(Context context) throws IOException {
        FileOutputStream fileWriter = context.openFileOutput(this.getClass().toString(), Context.MODE_PRIVATE);
        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);
        objectWriter.writeObject(this);
        objectWriter.close();
        fileWriter.close();
    }
}
