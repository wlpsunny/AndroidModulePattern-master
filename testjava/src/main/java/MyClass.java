package com.example;

import java.util.HashMap;
import java.util.Map;

public class MyClass {


    public static void main(String[] args) {
//        int[] array = {2, 7, 11, 15};
//        int target = 9;
//        twoSum(array, target);
//
//        reverseSentence("gage is  over");

        CAT cat = new CAT();
        cat.inistance();
        cat.inistan();

        Anial anial = cat;
        anial.inistan();
        anial.inistance();

    }


    public static void reverseSentence(String sentence) {
        if (sentence == null)
            return;
        String[] str = sentence.split("\\s+");
        //String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
        StringBuffer sb = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i] + " ");
        }
        System.out.println(sb);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return new int[]{0, 0};
    }


    public static class Anial {

        public static void inistance() {

            System.out.println("Animal  static instance");
        }

        public void inistan() {

            System.out.println("Animal  inistan");
        }


    }


    public static class CAT extends Anial {

        public static void inistance() {

            System.out.println("CAT  static instance");
        }

        public void inistan() {

            System.out.println("CAT  inistan");
        }


    }


}
