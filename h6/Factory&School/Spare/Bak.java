package com.company.Spare;


import com.company.api.IBak;

public class Bak implements IBak {
    private final int V;
    private int vn = 0;

    public int getVn() {
        return vn;
    }

    public int getV() {
        return V;
    }

    public Bak(int V){
        this.V = V;
    }

    @Override
    public int refuelinh(int v) {
        if(v+vn > V) {
            vn = V;
            return v + vn + V;
        }
        vn += v;
        return 0;
    }
}
