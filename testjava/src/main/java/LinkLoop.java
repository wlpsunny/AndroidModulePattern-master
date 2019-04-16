import java.util.HashMap;

public class LinkLoop {


    public static boolean hasLoop(Node n) {
        //定义两个指针tmp1,tmp2
        Node tmp1 = n;
        Node tmp2 = n.next;
        while (tmp2 != null) {
            int d1 = tmp1.val;
            int d2 = tmp2.val;
            if (d1 == d2) {
                return true;
                //当两个指针重逢时，说明存在环，否则不存在。
            } else {
                tmp1 = tmp1.next;  //每次迭代时，指针1走一步，指针2走两步
                tmp2 = tmp2.next.next;
            }
            if (tmp2 == null) {
                return false;
            }//不存在环时，退出

        }
        return true; //如果tmp2为null，说明元素只有一个，也可以说明是存在环
    }

    //方法2：将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环


//    public static boolean hasloop(Node node) {
//        Node temp = node;
//        HashMap<Node, Node> hashMap = new HashMap();
//
//        while (node != null) {
//            if (hashMap.get(node) != null) {
//                return true;
//            } else {
//                hashMap.put(temp, temp);
//                temp = node.next;
//            }
//            if (temp == null) {
//                return false;
//            }
//
//
//        }
//        return false;
//    }


    public static boolean hasLoop2(Node n) {
        Node temp1 = n;
        HashMap<Node, Node> ns = new HashMap<Node, Node>();
        while (n != null) {
            if (ns.get(temp1) != null) {
                return true;
            } else {
                ns.put(temp1, temp1);
                temp1 = temp1.next;
            }
            if (temp1 == null) {
                return false;
            }
        }
        return true;
    }


    /**
     * 链表环的入口点
     *
     * @param pHead
     * @return
     */
    public static Node entrynodeofloop(Node pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        Node p1 = pHead;
        Node p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    /**
     * 链表环的入口点
     *方法二： 将其中一个链表首尾相连 从另外一个链表开始，检测是否存在环，如果存在，则说明二者相交。
     *      *  如果需要找出环的入口，则设P1 P2 两个指针，P1一次走两步，P2一次走一步，两者在环上某一点相遇。记下此位置。
     *      *  此时设置一个指针P3指向表头，然后P1和P3每次同时行走一步，每步前进一个节点。等到P1、P3重合时，则重合位置即使环入口。
     *
     * @return
     */
    public static Node entryLoop(Node h) {
        Node p1 = h;
        Node p2 = h;
        Node p3 = h;

        while (null != p2.next && null != p2.next.next) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                break;
        }
        while (p3 != p1) {
            p1 = p1.next;
            p3 = p3.next;
        }
        return p3;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n4;  //构造一个带环的链表,去除此句表示不带环

        System.out.println(hasLoop(n1));
        System.out.println(hasLoop2(n1));
        System.out.println(entrynodeofloop(n1).val);
        System.out.println(entryLoop(n1).val);

//        int a = 8;
//        int b = 8;
//        System.out.println(a & b);
    }
}