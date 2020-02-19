package com.company;

public class CalcWithCounter implements ICalc {
    private int counter;
    private ICalc iCalc;

    public CalcWithCounter(ICalc iCalc){
        counter = 0;
        this.iCalc = iCalc;
    }

    public double sum(double a,double b){

        counter++;
        return iCalc.sum(a,b);
    }
    public double razn(double a, double b){

        counter++;
        return iCalc.razn(a, b);
    }

    public double pr(double a, double b){
        counter++;

        return iCalc.pr(a, b);
    }

    public double chas(double a, double b){

        counter++;
        return iCalc.chas(a, b);
    }

    public double abs(double a){

        counter++;

        return iCalc.abs(a);
    }

    public int getCounter() {
        return counter;
    }
}
