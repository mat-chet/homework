package com.company;

import java.util.Random;
import java.util.Scanner;

public class Alg {

    public static void tablUmn(){
        for(int i = 2; i < 10; i++){
            for(int j = 2; j < 6; j++){
                System.out.print(j + " x " + i + " = " + j*i + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 2; i < 10; i++){
            for(int j = 6; j < 10; j++){
                System.out.print(j + " x " + i + " = " + j*i + "\t");
            }
            System.out.println();
        }
    }

    public static int factorial(int a){
        int pr = 1;
        for(int i =1; i <= a; i++){
            pr *= i;
        }
        return pr;
    }

    public static void prChis(int a){
        int b = a;
        while(b != 0){
            int d = a;
            while (d != 0){
                System.out.print(b%10 + " x " + d%10 + " = " + (b%10)*(d%10) + "\n");
                d/=10;
            }
            b/=10;
        }
        System.out.println();
    }

    public static void outArr(){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        System.out.println();
        if(n>0) {
            int j = 0;
            do {
                System.out.print(a[j] + "\t");
                j++;
            } while (j < n);
        }
        System.out.println();
        {
            int j = 0;
            while (j < n){
                System.out.print(a[j] + "\t");
                j++;
            }
        }
        System.out.println();
        {

           for(int j = 0; j < n; j++){
                System.out.print(a[j] + "\t");

            }
        }
        System.out.println();
        {

            for(int j : a){
                System.out.print(j + "\t");

            }
        }
        System.out.println();
        for(int j = 0; j < n; j+=2){
            System.out.print(a[j] + "\t");

        }

        System.out.println();
    }

    private static int[] qSort0(int[]s,int a,int b){//~O(n*log(n))
        //Random rr = new Random();
        int porog = s[(b+a)/2];
        int i = a;
        int j = b-1;
        do {
            while (i < b && s[i] < porog) i++;
            while (j >= a && s[j] > porog) j--;
            if(i<=j){
                if(s[i]>s[j]){
                    int res = s[i];
                    s[i] = s[j];
                    s[j] = res;
                }
                i++;
                j--;
            }

        }while(i<j);
        int[] s1 = s;
        if(i<b)  s1= Alg.qSort0(s,i,b);
        if(j>a)  s = Alg.qSort0(s1,a,j+1);
        return s;
    }
    public  static int[] qSort(int[] s){
        int[] s1 = Alg.qSort0(s,0,s.length);
        return s1;
    }


    public static int[] mSort(int [] s){
        int []s1;
        s1 = Alg.mSort0(s,0,s.length);
        return s1;
    }

    private static int[] mSort0(int []s,int l,int r){//O(n*log(n))
        if(l == r-1)
            return s;
        int cc = (l+r)/2;
        mSort0(s,l,cc);
        mSort0(s,cc,r);

        int i = l;
        int j = cc;
        int f = 0;
        int[] buf = new int[r-l];
        while (f<r-l){
            if(s[j]>s[i] && i<cc) {
                buf[f] = s[i];
                i++;
            }
            else if(j<r){
                buf[f] = s[j];
                j++;
            }
            f++;
            if(j==r){
                for(int i1 = i;i1<cc;i1++){
                    buf[f] = s[i1];
                    f++;
                }
            }
            if(i == cc){
                for(int j1 = j;j1<cc;j1++){
                    buf[f] = s[j1];
                    f++;
                }
            }
        }
        f = 0;
        for(i = l;i<r;i++){
            s[i] = buf[f];
            f++;
        }
        return s;
    }

    public static int[] puzirekSort(int[] s){//O(n^2)
        for(int i = 0;i<s.length;i++){
            for(int j = 0; j < s.length - i - 1; j++){
                if(s[j]>s[j+1]){
                    int buf = s[j];
                    s[j] = s[j+1];
                    s[j+1] = buf;
                }
            }
        }
        return s;
    }
    public static int[] shakerSort(int[] s)
    {
        int l = 0, r = s.length - 1;

        while (l < r) {
            for (int i = l; i < r; i++) {
                if (s[i] > s[i + 1]) {
                    int buf = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = buf;
                }
            }
            r--;

            for (int i = r; i > l; i--) {
                if (s[i - 1] > s[i]) {

                    int buf = s[i];
                    s[i] = s[i - 1];
                    s[i - 1] = buf;
                }
            }
            l++;
        }
        return s;
    }
    public static int[] selectionSort(int[]s){
        for(int i = 0; i < s.length; i++){
            int min = s.length-1;
            for(int j = i; j < s.length; j++){
                if(s[j]<s[min])
                    min = j;

            }
            int min1 = s[min];
            for(int j = min-1;j>=i;j--){
                s[j+1] = s[j];
            }
            s[i] = min1;
        }
        return s;
    }
    public static int[] insSort(int [] s){
        for(int i = 1;i<s.length;i++){
            int j = i-1;
            int buf = s[i];
            while(j>0 && s[j]>buf){
                s[j+1] = s[j];
                j--;
            }
            s[j+1] = buf;
        }
        return s;
    }

    public static void outSortWithoutR(){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        System.out.println();
        //int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
        //n = a.length;
        qSort(a);
        int sdvig = 0;
        for(int i =1;i<n;i++){
            if(a[i] == a[i-1]){
                sdvig++;
            }
            else
                a[i-sdvig] = a[i];

        }
        for(int i = 0;i<n-sdvig;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

}
