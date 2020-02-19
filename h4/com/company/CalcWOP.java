package com.company;

public class CalcWOP implements ICalc {
    public double sum(double a,double b){
        return a+b;
    }
    public double razn(double a, double b){
        return a-b;
    }

    public double pr(double a, double b){
        return a*b;
    }

    public double chas(double a, double b){
        return a/b;
    }
    public static int factorial(int a){
        if(a == 2)
            return 2;
        return a * factorial(a-1);
    }
    public double abs(double a){
        if(a<0)
            return -a;
        return a;
    }
}
