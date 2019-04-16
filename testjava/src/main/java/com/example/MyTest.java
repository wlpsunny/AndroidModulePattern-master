package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTest {
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer == 2)
////                    list.remove(integer);
//                iterator.remove();   //注意这个地方
//        }
//    }

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        Thread thread1 = new Thread() {
//            public void run() {
//                Iterator<Integer> iterator = list.iterator();
//                while (iterator.hasNext()) {
//                    Integer integer = iterator.next();
//                    System.out.println(integer);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            ;
//        };
//        Thread thread2 = new Thread() {
//            public void run() {
//                Iterator<Integer> iterator = list.iterator();
//                while (iterator.hasNext()) {
//                    Integer integer = iterator.next();
//                    if (integer == 2)
//                        iterator.remove();
//                }
//            }
//
//            ;
//        };
//        thread1.start();
//        thread2.start();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer for seconds: ");
        int seconds = input.nextInt();
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;


        System.out.println(minutes + "′" + remainingSeconds + "''");

    }
}