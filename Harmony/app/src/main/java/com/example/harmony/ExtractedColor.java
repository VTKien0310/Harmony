package com.example.harmony;

import java.util.Comparator;

public class ColorExtracted implements Comparable<ColorExtracted>{
    String _code;

    @Override
    public int compareTo(ColorExtracted o) {
        return this._percent - o._percent;
    }

    int _percent;

    public ColorExtracted(String code, int percent){
        _code = code;
        _percent = percent;
    }

    public String getCode(){
        return _code;
    }

    public int getPercent(){
        return _percent;
    }

    public void setCode(String code){
        this._code = code;
    }

    public void setPercent(int percent){
        this._percent = percent;
    }
}
