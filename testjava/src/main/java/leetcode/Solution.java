package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {

        int[] array = {5, 4, 1};
        int target = 6;
//        String parenthese = "((){}[]";
//        System.out.print(isValid(parenthese));
//        System.out.print(climbStairs(5));
//        System.out.print(twoSum(array, target));

        int[] a = new int[8];
        a[0] = -1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        int[] b = {0, 1, 5, 8};
        merge(a, 4, b, 4);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

//        System.out.print(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.print(isPalindrome("A man, a plan, a canal: Panama"));
//        removeElement(b, 5);
        array();
        mostCount();
        checkCommom(new String("adefg"), new String("abcd"));

        System.out.print(reverse2("abcd"));
        System.out.print(reverseByStack("abcd"));
        lastPerson();
        isSuShu();
    }

    /**
     * 有效括号长度
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        List<Character> list = new ArrayList<>();

        for (Character c : charArr) {
            if (c == '(' || c == '{' || c == '[') {
                list.add(c);
            } else {
                if (list.size() == 0) {
                    return false;
                }
                char last = list.get(list.size() - 1);
                if (c == ')' && last != '(') {
                    return false;
                } else if (c == '}' && last != '{') {
                    return false;
                } else if (c == ']' && last != '[') {
                    return false;
                }
                list.remove(list.size() - 1);
            }
        }
        if (list.size() != 0) {
            return false;
        }
        return true;
    }


    /**
     * 数字反转
     *
     * @param x
     * @return
     */
    public static int intreverse(int x) {
        long tmp = x; // 防止结果溢出
        long result = 0;
        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        // 溢出判
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) result;
    }


    /**
     * 爬台阶
     *
     * @param n
     * @return
     */

    public static int climbStairsrecursive(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return climbStairs(n - 2) + climbStairs(n - 1);
        }
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    /**
     * 两数求和
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 数组合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0 || (p1 >= 0 && nums1[p1] > nums2[p2])) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }




    /**
     * 是否是回文，过滤空格等字符，结果只有（0-9.a-z.A-Z）
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        int fix = 'a' - 'A';
        for (char c : charArr) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                list.add((int) c);
            } else if (c >= 'A' && c <= 'Z') {
                list.add(c + fix);
            }
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 我的做法是把所有非给定值的元素，交换到数组的前面位置。而这边做了一些优化，即只把非指定值替换到前面，
     * 而不需要把给定值替换到后面。我创建了一个指针（数组下标），代表当前可作为写入新值的数组位置，同时循环结束后，它也是新数组的长度。
     *
     * @param nums
     * @param val
     * @return
     */

    public static int removeElement(int[] nums, int val) {
        int nextEmpty = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nextEmpty] = nums[i];
                nextEmpty++;
            }
        }
        return nextEmpty;
    }


    /**
     * 数组正负元素左右分开
     */

    public static void array() {
        int[] x = {1, 7, -5, -12, -13, 99, -6, 31, 15};
        int p = 0;
        for (int i = x.length - 1; i > p; ) {
            if (x[i] < 0) {
                int j = i;
                while (j != 0) {
                    int t = x[j];
                    x[j] = x[j - 1];
                    x[j - 1] = t;//交换
                    j--;
                }
                p++;
            } else i--;
        }
        System.out.println(Arrays.toString(x));
    }

    /**
     * 数组中出现次数最多的元素
     * <p>
     * 第一个不重复的字符  计算第一个value为1
     */
    public static void mostCount() {
        int[] array = {2, 1, 2, 3, 4, 5, 2, 2, 2, 2};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int temp = map.get(array[i]);
                map.put(array[i], temp + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Collection<Integer> count = map.values();
        int maxCount = Collections.max(count);
        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxNumber = entry.getKey();
            }
        }
        System.out.println("出现次数最多的数字为：" + maxNumber);
        System.out.println("该数字一共出现" + maxCount + "次");
    }


    /**
     * 两个字符串交集
     *
     * @param str1
     * @param str2
     */
    public static void checkCommom(String str1, String str2) {

        HashSet<String> result = new HashSet<String>();
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                String char1 = str1.charAt(i) + "";
                String char2 = str2.charAt(j) + "";
                if (char1.equals(char2)) {
                    result.add(char1);
                }
            }
        }

        Iterator<String> it = result.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.print(value);
        }

    }

    /**
     * 标号1-n的n个人首尾相接，报数1-3，报到3者退出，问剩下最后一人标号。
     */
    public static void lastPerson() {
        int arr[] = new int[101];//报数从1开始所以数组大小为n+1
        int n = 100, m = 3;
        int i;
        int dead = 0;   //表示已经死了多少人
        int num = 0;    //num模拟报数
        for (i = 1; i <= n; i++) {
            //开始时每个人都可以报数，为了能得到最后一个人的编号，我们让初始值为i下标
            arr[i] = i;
        }

        for (i = 1; ; i++) {
            if (i > n) {
                //如果大于总人数，我们就从头开始
                i = i % n;
            }

            if (arr[i] > 0) {
                //如果当前这个人没有死，就报数
                num++;
            }

            if (m == num && dead != n - 1) {
                //如果当前这个人报的数等于m 并且没有已经死亡n-1个人
                num = 0;
                arr[i] = 0;
                dead++;
            } else if (m == num && dead == n - 1) {
                //如果这个人报数等于m，并且已经死了n-1个人，说明当前这个人就是最后的一个活着的了。
                System.out.print(arr[i] + "");
                break;
            }

        }

    }

    /**
     * 字符串反转
     *
     * @param s
     * @return
     */
    public static String reverse2(String s) {

        return new StringBuffer(s).reverse().toString();

//        char[] array = s.toCharArray();    //String转字符数组
//        String reverse = "";  //注意这是空串，不是null
//        for (int i = array.length - 1; i >= 0; i--) {
//            reverse += array[i];
//        }
//        return reverse;
    }

    //用栈实现
    public static String reverseByStack(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Stack<Character> strStack = new Stack<Character>();
        char[] chArray = str.toCharArray();
        for (Character ch : chArray) {
            strStack.push(ch);
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            chArray[i] = strStack.pop();
        }
        return new String(chArray);


    }

    /**
     * 判断一个整数是不是素数的方法
     */
    public static void isSuShu() {
        int count = 0;
        for (int i = 2; i <= 100; i++) {                //从2开始
            if (isSuShu(i)) {                         //判断是否为素数
                System.out.print(i + " ");        //打印素数
                count++;
            }
        }
        System.out.println("\n");
        System.out.println("共有" + count + "个");
    }


    public static boolean isSuShu(int number) {
        for (int i = 2; i < number; i++) {                    //从2开始
            if (number % i == 0) {                    //判断是否能除尽
                return false;                   //返回false
            }
        }
        return true;                                    //返回true
    }
}