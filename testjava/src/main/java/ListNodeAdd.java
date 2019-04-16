import java.util.Stack;

public class ListNodeAdd {
    public static void main(String args[]) {
        ListNode node1 = new ListNode();
        node1.value = 1;

        node1.next = new ListNode();
        node1.next.value = 4;

        node1.next.next = new ListNode();
        node1.next.next.value = 6;


        ListNode node2 = new ListNode();
        node2.value = 5;

        node2.next = new ListNode();
        node2.next.value = 4;

        node2.next.next = new ListNode();
        node2.next.next.value = 6;


        ListNode node3 = new ListNode();
//        node3 = addTwoNumbers(node1, node2);
//        node3 = mergeTwoList(node1, node2);
//        node3 = deleteDuplicates(node1);
//        node3 = deleteDuplicates(node1);

//        node3 = getLastKNode(node2, 3);
        System.out.println("--" + getListLength(node1));
        System.out.println("--" + getFirstCommonNode(node1, node2));


//        printListInverselyUsingIteration(node1);
//        node3 = reverseList(node1);

        while (node3 != null) {
            System.out.print(node3);
            node3 = node3.next;
        }

    }


    /**
     * 合并同类型
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            currentNode.next = new ListNode(sum % 10);
            sum = sum / 10;
            currentNode = currentNode.next;
        }

        return head.next;
    }


    /**
     * 首尾拼接
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            } else if (l2 != null && (l1 == null || l1.value > l2.value)) {
                currentNode.next = l2;
                l2 = l2.next;
            } else {
                currentNode.next = l1;
                l1 = l1.next;
            }
            currentNode = currentNode.next;
        }
        return head.next;
    }


    /**
     * 获取两个没有环的链表相交节点
     *
     * @param list1
     * @param list2
     * @return
     */

    public static ListNode getFirstCommonNode(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        int length1 = getListLength(list1);
        int length2 = getListLength(list2);

        ListNode longList = list2;
        ListNode shortList = list1;
        int dif = length2 - length1;

        if (length1 > length2) {
            longList = list1;
            shortList = list2;
            dif = length1 - length2;
        }

        //如果要求这种情况的交点，由于相交部分全部都相同，
        // 因此，只需要先得到两个链表的差，用两个指针分别指向这两个链表P1,P2假定P1与P2相差为N，那么将P1移动N个节点后，P1与P2同时出发，
        // 第一个相等的节点即为交点
        while (dif > 0) {
            longList = longList.next;
            dif--;
        }

        while (longList != null && shortList != null && longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }

        return longList;
    }

    /**
     * 获取链表的长度
     *
     * @param list
     * @return
     */
    public static int getListLength(ListNode list) {
        int length = 0;
        while (list != null) {
            length++;
            list = list.next;
        }
        return length;
    }

    /**
     * 链表反转
     *
     * @param head
     * @return （1）迭代法。先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
     */

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }



    /**
     * 删除重复元素
     * 使用一个指针指向链表的头，如果下一个与当前的结点相等则删除，直到遇到一个不相同的，则指针指向这个新的结点，重复操作，直到所有的结点都处理完。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }


    /**
     * 从尾到头打印链表
     *
     * @param root
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.value + " ");
        }
    }

    public static ListNode getLastKNode(ListNode head, int k) {
        ListNode node = head;
        while (node.next != null && k > 0) {
            node = node.next;
            k--;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }

    //创建一个链表的类
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "->";
        }

    }

}