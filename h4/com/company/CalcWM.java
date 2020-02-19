package com.company;

public class CalcWM implements ICalc {
    public double abs(double a){
        return Math.abs(a);
    }
    public double sum(double a, double b){
        return a+b;
    }
    public double razn(double a, double b){
        return a-b;
    }

    public double chas(double a, double b){
        return a/b;
    }

    public double pr(double a, double b){
        return a*b;
    }

}
