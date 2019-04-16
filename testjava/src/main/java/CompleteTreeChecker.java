import java.util.LinkedList;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class CompleteTreeChecker {
    //实现广度遍历需要的队列  
    private LinkedList<Node> queue = new LinkedList<Node>();
    //第n层最右节点的标志  
    private boolean leftMost = false;

    public boolean processChild(Node child) {
        if (child != null) {
            if (!leftMost) {
                queue.addLast(child);
            } else {
                return false;
            }
        } else {
            leftMost = true;
        }
        return true;
    }

    public boolean isCompleteTree(Node root) {
        //空树也是完全二叉树  
        if (root == null) return true;

        //首先根节点入队列  
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();

            //处理左子结点  
            if (!processChild(node.left))
                return false;
            //处理右子结点  
            if (!processChild(node.right))
                return false;
        }

        //广度优先遍历完毕，此树是完全二叉树  
        return true;
    }

    public static void main(String[] args) {


    }
}  