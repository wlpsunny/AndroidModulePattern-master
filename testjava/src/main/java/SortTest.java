import java.util.Stack;

//
public class SortTest {

    public static void main(String[] args) {
        int[] sortNum = {12, 33, 28, 86, 15, 62, 9, 38};       //定义数组
        int[] arr = {12, 33, 1, 4, 55};
//        bubbleSor(arr);                           //开始排序
//        selectSort(arr);
        printAll(insertSort(arr));
//        quick(arr);

//        sort(arr);
////        System.out.println(BinarySearch2(arr, 55, 0, arr.length - 1) + "====binarySearch");
//        String res = "())()()";
//        System.out.println(longestValidParentheses(res));
//        System.out.println(Arrays.toString(arr));   //打印结果
//        System.out.println(intreverse(12345));   //打印结果


    }


    /**
     * 冒泡排序
     *
     * @param sortNum 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *                <p>
     *                对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *                <p>
     *                针对所有的元素重复以上的步骤，除了最后一个；
     *                <p>
     *                重复步骤1~3，直到排序完成。
     */
    private static void bubbleSor(int[] sortNum) {

        for (int i = 0; i < sortNum.length - 1; i++) {

            for (int j = 0; j < sortNum.length - i - 1; j++) {
                if (sortNum[j] > sortNum[j + 1]) {
                    int temp = sortNum[j];
                    sortNum[j] = sortNum[j + 1];
                    sortNum[j + 1] = temp;
                }
            }

        }
    }


    /**
     * 选择排序
     *
     * @param array 初始状态：无序区为R[1..n]，有序区为空；
     *              <p>
     *              第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     *              <p>
     *              n-1趟结束，数组有序化了
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minindex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
                int temp = array[minindex];
                array[minindex] = array[i];
                array[i] = temp;
            }

        }

    }


    /**
     * 快速排序
     * 然后再来看最糟糕情况下的快排，当待排序的序列为正序或逆序排列时，且每次划分只得到一个比上一次划分少一个记录的子序列，注意另一个为空
     *
     * @param a2
     */
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

    /**
     * 插入排序
     *
     * @param array 从第一个元素开始，该元素可以认为已经被排序；
     *              <p>
     *              取出下一个元素，在已经排序的元素序列中从后向前扫描；
     *              <p>
     *              如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *              <p>
     *              重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *              <p>
     *              将新元素插入到该位置后；
     *              <p>
     *              重复步骤2~5。
     */
    public static int[] insertSort(int[] array) {

        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
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
     * 二分查找
     *
     * @param b
     * @param c
     * @return
     */
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

    /**
     * https://blog.csdn.net/worldwindjp/article/details/39460161
     * 想要O(n)的解法需要一点技巧，栈中保存的不是‘(’而是‘(’所在的index，在此基础上也要弄清楚几种情况：
     * 每次来了‘(’之后，无条件压栈。如果碰到')'的话，如果栈不为空，就消除栈内剩余的'('
     * 第一：消除掉'('之后，如果栈内还有剩余的‘(’的话，最长的合法长度就是：maxLength = Math.max(i - (int)stack.peek() , maxLength);  也就是取：当前')'的index减去栈顶元素的index  和 原来max_length 两者的最大值。
     * <p>
     * 例如：对于这种情况：()(()()，可以正确的得出最大值为4。
     * <p>
     * 第二：消除掉')'之后，栈内没有剩余的‘(’了。此时需要引入一个新的变量start，用于表示合法括号字符串的起点。
     * 例如：对于这种情况：())()()，可以正确的得出最大值为4。
     * <p>
     * start初始为-1，之后每次碰到‘)’且栈为空的时候更新为当前‘)’的index。也就是说无法消除的)之后的括号不可能再和前面的括号合并在一起计算最长序列，所以更新start。
     *
     * @param s
     * @return
     */

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = -1;
        int maxLength = 0;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    if (stack.empty() == true) {
                        maxLength = Math.max(i - start, maxLength);
                    } else {
                        maxLength = Math.max(i - (int) stack.peek(), maxLength);
                    }
                } else {
                    start = i;
                }
            }
        }

        return maxLength;
    }


    public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }




}