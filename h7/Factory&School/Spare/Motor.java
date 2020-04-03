package com.company.Spare;


import com.company.api.IMotor;

public class Motor implements IMotor {
    private static int kk = 0;
    public final int number = kk++;
    public final double V;
    public Motor(double V){
        this.V = V;
    }
    public boolean work = false;
    public void usil(){
        work = true;
    }
}
