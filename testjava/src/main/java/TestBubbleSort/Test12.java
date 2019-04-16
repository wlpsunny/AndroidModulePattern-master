package TestBubbleSort;

import java.util.Arrays;
import java.util.Stack;

public class Test12 {

    public static void main(String[] args) {
        int[] sortNum = {12, 33, 28, 86, 15, 62, 9, 38};       //定义数组
        int[] arr = {12, 33, 1, 4, 55};
//        bubbleSor(arr);                           //开始排序
//        selectSort(arr);
//        insertSort(arr);
        quick(arr);
//        System.out.println(BinarySearch2(arr, 55, 0, arr.length - 1) + "====binarySearch");
        String res = "(()()(((()))";
        System.out.println(longestValidParentheses(res));
        System.out.println(Arrays.toString(arr));   //打印结果
        System.out.println(intreverse(12345));   //打印结果


    }


    public static int intreverse(int x) {
        long tmp = x; // 防止结果溢出
        long result = 0;
        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    //冒泡排序
    private static void bubbleSor(int[] sortNum) {
        boolean bChange = false; // 交换标志如果用一个flag来判断一下，当前数组是否已经有序，如果有序就退出循环，这样可以明显的提高冒泡排序的性能。

        for (int i = 0; i < sortNum.length; i++) {
            bChange = false;

            for (int j = 0; j < sortNum.length - i - 1; j++) {
                if (sortNum[j] > sortNum[j + 1]) {
                    int temp = sortNum[j + 1];
                    sortNum[j + 1] = sortNum[j];
                    sortNum[j] = temp;
                    bChange = true;
                }
            }

            if (false == bChange)
                break;
        }
    }


    //选择排序
    public static void selectSort(int[] list) {
        // 需要遍历获得最小值的次数
        // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
        for (int i = 0; i < list.length; i++) {

            int minindex = i; // 用来保存最小值得索引

            // 寻找第i个小的数值
            for (int j = i; j < list.length; j++) {
                if (list[minindex] > list[j]) {
                    minindex = j;
                }
            }

            // 将找到的第i个小的数值放在第i个位置上
            int temp = list[minindex];
            list[minindex] = list[i];
            list[i] = temp;

        }
    }


    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public static void insertSort(int list[]) {

        int cur = 0;
        for (int i = 0; i < list.length - 1; i++) {
            cur = list[i + 1];
            int pre = i;
            while (pre >= 0 && cur < list[pre]) {
                list[pre + 1] = list[pre];
                pre--;
            }
            list[pre + 1] = cur;
        }

    }

    public static int binarySearch(int[] b, int c) {
        // 这里需要先排序，假设已经是有序的数组了
        int low = 0;
        int high = b.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;//防止溢出
            if (c == b[middle]) {
                System.out.println("您要找的结果" + c + "已经找到，位置在：" + middle);
                return middle;
            } else if (c > b[middle]) {
                low = middle + 1;
            } else if (c < b[middle]) {
                high = middle - 1;
            }
        }
        System.out.println("sorry！这里没有您想要的结果！");
        return -1;
    }


//    String res = "(()()(((()))";

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}