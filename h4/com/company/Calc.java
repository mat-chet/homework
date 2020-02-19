package com.company;

public class Calc implements ICalc {

    private ICalc iCalc;

    public Calc(ICalc iCalc){
        this.iCalc = iCalc;
    }

    public double sum(double a,double b){
        return iCalc.sum(a,b);
    }
    public double razn(double a, double b){
        return iCalc.razn(a, b);
    }

    public double pr(double a, double b){
        return iCalc.pr(a, b);
    }

    public double chas(double a, double b){
        return iCalc.chas(a, b);
    }

    public double abs(double a){

        return iCalc.abs(a);
    }

}
