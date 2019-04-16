import java.util.ArrayList;

/**
 * Created by  wlp on 2018/4/8.
 */

public class TraversalTree {
    private Node root;
    private ArrayList<Node> nodeArrayList = new ArrayList<>();

    private TraversalTree() {
        init();
    }

    private void init() {

        Node x = new Node("x", null, null);
        Node y = new Node("y", null, null);
        Node d = new Node("d", x, y);
        Node e = new Node("e", null, null);
        Node f = new Node("f", null, null);
        Node c = new Node("c", e, f);
        Node b = new Node("b", d, null);
        Node a = new Node("a", b, c);
        root = a;
    }


    public void preNode(Node node) {
        nodeArrayList.add(node);
        if (node.leftchid != null) {
            preNode(node.leftchid);
        }
        if (node.rightchid != null) {
            preNode(node.rightchid);
        }

    }

    private class Node {
        private String data;
        private Node leftchid;
        private Node rightchid;

        public Node(String data, Node leftchid, Node rightchid) {
            this.data = data;
            this.leftchid = leftchid;
            this.rightchid = rightchid;
        }
    }


    public static void main(String[] args) {

        TraversalTree tree = new TraversalTree();
        tree.preNode(tree.root);
        for (Node node : tree.nodeArrayList) {
            System.out.println(node.data);
        }

    }


}
