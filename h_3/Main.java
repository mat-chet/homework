package com.company;
/*
Первый параметр для задания 1.2(факториал)
Второй - для 1.3
По дефолту стоит 5 и 123 соответственно
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("1.1");
        {
            Alg.tablUmn();
        }

        System.out.println("1.2");
        {
            try {
                System.out.println(args[0] + "! = " + Alg.factorial(Integer.parseInt(args[0])));
            }catch (Throwable t){
                System.out.println("5! = " + Alg.factorial(5));
            }
        }

        System.out.println("1.3");
        {
            try {
                Alg.prChis(Integer.parseInt(args[1]));
            }catch (Throwable t){

                System.out.println("123\n");
                Alg.prChis(123);
            }
        }

        System.out.println("2.1 и 2.2");
        {
            Alg.outArr();
        }
        System.out.println("3.1");
        {                                                                                           //3.1
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.selectionSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("3.2.1");
        {                                                                                           //3.2.1
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.puzirekSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("3.2.2");
        {                                                                                           //3.2.2
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.shakerSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("3.3");
        {                                                                                           //3.3
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.insSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("3.4");
        {                                                                                           //3.4
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.mSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("3.5");
        {                                                                                           //3.5
            int[] a = {-2, 5, 9, 0, 4, 6, 7, 4, 3, 2, 6, 8, 6, 5, 3, 7, -1};
            Alg.qSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("4");
        {                                                                                           //4

            Alg.outSortWithoutR();
        }
    }
}
