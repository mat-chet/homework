package com.company;

import com.sun.javafx.scene.traversal.Algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Calc calc1 = new Calc(new CalcWM() );
        Calc calc2 = new Calc(new CalcWOP() );

        System.out.println(calc1.abs(-12));
        System.out.println(calc2.abs(-12));
        System.out.println("5! = " + CalcWOP.factorial(5));

        int n = 10;

        MyInt[] a1 = new MyInt[n];
        MyInt[] a2 = new MyInt[n];


        Random rand = new Random();

        System.out.println();

        for(int i = 0;i<n;i++){
            a1[i] = new MyInt();
            a1[i].b = rand.nextInt()%100;
            System.out.print(a1[i].b + " ");
        }



        System.out.println();
        Arrays.sort(a1);

        for(int i = 0;i<n;i++){
            System.out.print(a1[i].b + " ");
        }

        System.out.println();
        System.out.println();


        for(int i = 0;i<n;i++){
            a2[i] = new MyInt();
            a2[i].b = rand.nextInt()%100;

            System.out.print(a2[i].b + " ");
        }
        Comparator<MyInt> comparator = Comparator.comparing(a->-a.b);
        Arrays.sort(a2, comparator);
        System.out.println();
        for(int i = 0;i<n;i++){
            System.out.print(a2[i].b + " ");
        }
    }
}
