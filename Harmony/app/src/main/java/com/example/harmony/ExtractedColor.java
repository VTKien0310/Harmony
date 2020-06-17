package com.example.harmony;

public class ExtractedColor implements Comparable<ExtractedColor>{
    String _code;

    @Override
    public int compareTo(ExtractedColor o) {
        return this._percent - o._percent;
    }

    int _percent;

    public ExtractedColor(String code, int percent){
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
