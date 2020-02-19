package com.company;

public class MyInt implements Comparable<MyInt>{
    int b;

    @Override
    public int compareTo(MyInt a) {
        return b - a.b;
    }

}
