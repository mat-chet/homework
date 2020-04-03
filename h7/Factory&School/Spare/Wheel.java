package com.company.Spare;


import com.company.api.IWheel;

public class Wheel implements IWheel {
    public final int R;
    public final TypeWheel type;

    public TypeWheel getType() {
        return type;
    }

    public int getR() {
        return R;
    }

    public Wheel(int R, TypeWheel type){
        this.R = R;
        this.type = type;
    }
}
