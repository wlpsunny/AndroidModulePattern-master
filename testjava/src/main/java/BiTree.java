import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BiTree {
    private BiTree leftTree;// 左子树
    private BiTree rightTree;// 右子树
    private Object data;// 节点数据
    public final static int MAX = 40;


    // 构造函数
    public BiTree() {
        // TODO Auto-generated constructor stub
    }

    public BiTree(Object data) {
        this.data = data;
    }

    public BiTree(Object data, BiTree lefTree, BiTree righTree) {
        this.data = data;
        this.leftTree = lefTree;
        this.rightTree = righTree;
    }

    // 递归前序遍历二叉树
    public void preOrder(BiTree tree) {
        if (tree != null) {
            visit(tree.data);
            preOrder(tree.leftTree);
            preOrder(tree.rightTree);
        }
    }

    // 非递归实现前序遍历
    public void iterativePreOrder(BiTree tree) {
        Stack<BiTree> stack = new Stack<BiTree>();
        if (tree != null) {
            stack.push(tree);
            while (!stack.isEmpty()) {
                tree = stack.pop();
                visit(tree.data);
                if (tree.rightTree != null)
                    stack.push(tree.rightTree);
                if (tree.leftTree != null)
                    stack.push(tree.leftTree);
            }
        }
    }


    // 递归中序遍历二叉树
    public void inOrder(BiTree tree) {
        if (tree != null) {
            inOrder(tree.leftTree);
            visit(tree.data);
            inOrder(tree.rightTree);
        }
    }

    // 非递归实现中序遍历
    public void iterativeInOrder(BiTree tree) {
        Stack<BiTree> stack = new Stack<BiTree>();
        while (tree != null) {
            while (tree != null) {
                if (tree.rightTree != null)
                    stack.push(tree.rightTree);// 当前节点右子入栈
                stack.push(tree);// 当前节点入栈
                tree = tree.leftTree;
            }
            tree = stack.pop();
            while (!stack.empty() && tree.rightTree == null) {
                visit(tree.data);
                tree = stack.pop();
            }
            visit(tree.data);
            if (!stack.empty())
                tree = stack.pop();
            else
                tree = null;
        }
    }

    // 递归后序遍历二叉树
    public void postOrder(BiTree tree) {
        if (tree != null) {
            postOrder(tree.leftTree);
            postOrder(tree.rightTree);
            visit(tree.data);
        }
    }

    // 非递归实现后序遍历
    public void iterativePostOrder(BiTree tree) {
        BiTree tempTree = tree;
        Stack<BiTree> stack = new Stack<BiTree>();
        while (tree != null) {
            // 左子树入栈
            for (; tree.leftTree != null; tree = tree.leftTree)
                stack.push(tree);
            // 当前节点无右子或右子已经输出
            while (tree != null
                    && (tree.rightTree == null || tree.rightTree == tempTree)) {
                visit(tree.data);
                tempTree = tree;// 记录上一个已输出节点
                if (stack.empty())
                    return;
                tree = stack.pop();
            }
            // 处理右子
            stack.push(tree);
            tree = tree.rightTree;
        }
    }

    // 层次遍历二叉树
    public void levelOrder1(BiTree Node) {
        if (Node == null) {
            return;
        }
        BiTree binaryNode;
        LinkedList<BiTree> list = new LinkedList<>();
        list.add(Node);
        while (list.size() != 0) {
            binaryNode = list.poll();
            System.out.print(binaryNode.data + "===  ");
            if (binaryNode.leftTree != null) {
                list.add(binaryNode.leftTree);
            }
            if (binaryNode.rightTree != null) {
                list.add(binaryNode.rightTree);
            }
        }
    }

    // 层次遍历二叉树
    public void LayerOrder(BiTree tree) {
        BiTree[] elements = new BiTree[MAX];// 层次遍历时保存各个节点
        int front = 0;// 层次遍历时队首
        int rear = 1;// 层次遍历时队尾
        elements[0] = tree;
        while (front < rear) {
            if (elements[front].data != null) {
                System.out.print(elements[front].data + " ");
                if (elements[front].leftTree != null)
                    elements[rear++] = elements[front].leftTree;
                if (elements[front].rightTree != null)
                    elements[rear++] = elements[front].rightTree;
                front++;
            }
        }
    }

    // 求二叉树的高度
    public static int height(BiTree tree) {
        if (tree == null)
            return 0;
        else {
            int leftTreeHeight = height(tree.leftTree);
            int rightTreeHeight = height(tree.rightTree);
            return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1
                    : rightTreeHeight + 1;
        }
    }

    // 求data所对应结点的层数，如果对象不在树中,结果返回-1;否则结果返回该对象在树中所处的层次,规定根节点为第一层
    public int level(Object data) {
        int leftLevel, rightLevel;
        if (this == null)
            return -1;
        if (data == this.data)
            return 1;
        leftLevel = leftTree == null ? -1 : leftTree.level(data);
        rightLevel = rightTree == null ? -1 : rightTree.level(data);
        if (leftLevel < 0 && rightLevel < 0)
            return -1;
        return leftLevel > rightLevel ? leftLevel + 1 : rightLevel + 1;
    }

    // 求二叉树的结点总数
    public static int nodes(BiTree tree) {
        if (tree == null)
            return 0;
        else {
            int left = nodes(tree.leftTree);
            int right = nodes(tree.rightTree);
            return left + right + 1;
        }
    }

    // 求二叉树叶子节点的总数
    public static int leaf(BiTree tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = leaf(tree.leftTree);
            int right = leaf(tree.rightTree);
            if (tree.leftTree == null && tree.rightTree == null) {
                return left + right + 1;
            } else {
                return left + right;
            }
        }
    }

    // 求二叉树父节点个数
    public static int fatherNodes(BiTree tree) {
        if (tree == null || (tree.leftTree == null && tree.rightTree == null)) {
            return 0;
        } else {
            int left = fatherNodes(tree.leftTree);
            int right = fatherNodes(tree.rightTree);
            return left + right + 1;
        }
    }

    // 求只有一个孩子结点的父节点个数
    public static int oneChildFather(BiTree tree) {
        int left, right;
        if (tree == null || (tree.rightTree == null && tree.leftTree == null)) {
            return 0;
        } else {
            left = oneChildFather(tree.leftTree);
            right = oneChildFather(tree.rightTree);
            if ((tree.leftTree != null && tree.rightTree == null)
                    || (tree.leftTree == null && tree.rightTree != null)) {
                return left + right + 1;
            } else {
                return left + right;/* 加1是因为要算上根节点 */
            }
        }
    }

    // 求二叉树只拥有左孩子的父节点总数
    public static int leftChildFather(BiTree tree) {
        if (tree == null)
            return 0;
        else {
            int left = leftChildFather(tree.leftTree);
            int right = leftChildFather(tree.rightTree);
            if ((tree.leftTree != null && tree.rightTree == null))
                return left + right + 1;
            else
                return left + right;
        }
    }

    // 求二叉树只拥有右孩子的结点总数
    public static int rightChildFather(BiTree tree) {
        if (tree == null || tree.rightTree == null)
            return 0;
        else {
            int left = rightChildFather(tree.leftTree);
            int right = rightChildFather(tree.rightTree);
            if (tree.leftTree == null && tree.rightTree != null)
                return left + right + 1;
            else
                return left + right;
        }
    }

    // 计算有两个节点的父节点的个数
    public static int doubleChildFather(BiTree tree) {
        int left, right;
        if (tree == null)
            return 0;
        else {
            left = doubleChildFather(tree.leftTree);
            right = doubleChildFather(tree.rightTree);
            if (tree.leftTree != null && tree.rightTree != null)
                return (left + right + 1);/* 加1是因为要算上根节点 */
            else
                return (left + right);
        }
    }

    // 访问根节点
    public void visit(Object data) {
        System.out.print(data + " ");
    }

    // 将树中的每个节点的孩子对换位置
    public void exChange() {
        if (this == null)
            return;
        if (leftTree != null)
            leftTree.exChange();
        if (rightTree != null)
            rightTree.exChange();
        BiTree temp = leftTree;
        leftTree = rightTree;
        rightTree = temp;
    }

    //递归求所有结点的和
    public static int getSumByRecursion(BiTree tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = getSumByRecursion(tree.leftTree);
            int right = getSumByRecursion(tree.rightTree);
            return Integer.parseInt(tree.data.toString()) + left + right;
        }

    }

    //非递归求二叉树中所有结点的和
    public static int getSumByNoRecursion(BiTree tree) {
        Stack<BiTree> stack = new Stack<BiTree>();
        int sum = 0;
        if (tree != null) {
            stack.push(tree);
            while (!stack.isEmpty()) {
                tree = stack.pop();
                sum += Integer.parseInt(tree.data.toString());
                if (tree.leftTree != null)
                    stack.push(tree.leftTree);
                if (tree.rightTree != null)
                    stack.push(tree.rightTree);
            }

        }
        return sum;

    }

    /**
     * 求二叉树中第k层节点的个数
     *
     * @param root
     * @param k
     * @return
     */
    public int numsOfkLevelTreeNode(BiTree root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numsLeft = numsOfkLevelTreeNode(root.leftTree, k - 1);
        int numsRight = numsOfkLevelTreeNode(root.rightTree, k - 1);
        return numsLeft + numsRight;
    }


    /**
     * 判断二叉树是否是平衡二叉树
     */


    private boolean isBalance(BiTree root) {
        if (root == null)
            return true;
        int left_height = height(root.leftTree);
        int right_height = height(root.rightTree);
        if (Math.abs(left_height - right_height) > 1) {
            return false;
        } else {
            return isBalance(root.leftTree) && isBalance(root.rightTree);
        }
    }

    /**
     * 两个二叉树是否完全相同
     *
     * @param t1
     * @param t2
     * @return
     */


    public boolean isSameTreeNode(BiTree t1, BiTree t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.data != t2.data) {
            return false;
        }
        boolean left = isSameTreeNode(t1.leftTree, t2.leftTree);
        boolean right = isSameTreeNode(t1.rightTree, t2.rightTree);
        return left && right;

    }




    /**
     * 判断二叉树是否是二叉搜索树BST
     *1.  非空 左子树 的所有键值小于其根结点的键值。2.  非空 右子树 的所有键值大于其根结点的键值。3.  左右子树都是二叉搜索树。
     * @param root
     * @return
     */


    public boolean isValidBST(BiTree root) {
        ArrayList<BiTree> list = new ArrayList<BiTree>();
        if (root == null)
            return true;
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if ((int) list.get(i).data >= (int) list.get(i + 1).data) {
                return false;
            }
        }
        return true;
    }


    /**
     * 中序遍历
     * @param root
     * @param list
     */

    public static void inorder(BiTree root, ArrayList<BiTree> list) {
        if (root != null) {
            inorder(root.leftTree, list);
            list.add(root);
            inorder(root.rightTree, list);
        }

    }


    /**
     * 求二叉树的最大深度
     *
     * @param node
     * @return
     */
    int maxDeath(BiTree node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.leftTree);
        int right = maxDeath(node.rightTree);
        return Math.max(left, right) + 1;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BiTree e = new BiTree(5);
//        BiTree g = new BiTree(7);
//        BiTree h = new BiTree(8);
//        BiTree l = new BiTree(12);
//        BiTree m = new BiTree(13);
//        BiTree n = new BiTree(14);
//        BiTree k = new BiTree(11, n, null);
//        BiTree j = new BiTree(10, l, m);
//        BiTree i = new BiTree(9, j, k);
        BiTree d = new BiTree(4, null, null);
        BiTree f = new BiTree(6, null, null);
        BiTree b = new BiTree(2, d, e);
        BiTree c = new BiTree(3, f, null);
        BiTree tree = new BiTree(1, b, c);

        tree.iterativeInOrder(tree);
//        System.out.println("递归前序遍历二叉树结果: ");
//        tree.preOrder(tree);
//        System.out.println();
//        System.out.println("非递归前序遍历二叉树结果: ");
//        tree.iterativePreOrder(tree);
//        System.out.println();
//        System.out.println("递归中序遍历二叉树的结果为:");
//        tree.inOrder(tree);
//        System.out.println();
//        System.out.println("非递归中序遍历二叉树的结果为:");
//        tree.iterativeInOrder(tree);
//        System.out.println();
//        System.out.println("递归后序遍历二叉树的结果为:");
//        tree.postOrder(tree);
//        System.out.println();
//        System.out.println("非递归后序遍历二叉树的结果为:");
//        tree.iterativePostOrder(tree);
//        System.out.println();
//        System.out.println("层次遍历二叉树结果: ");
        tree.LayerOrder(tree);
        tree.levelOrder1(tree);
        tree.isBalance(tree);
//        System.out.println();
//        System.out.println("递归求二叉树中所有结点的和为:" + getSumByRecursion(tree));
//        System.out.println("非递归求二叉树中所有结点的和为:" + getSumByNoRecursion(tree));
//
//        System.out.println("二叉树中,每个节点所在的层数为:");
//        for (int p = 1; p <= 14; p++) {
//            System.out.println(p + "所在的层为:" + tree.level(p));
//        }
//        System.out.println("二叉树的高度为:" + height(tree));
//        System.out.println("二叉树中节点总数为:" + nodes(tree));
//        System.out.println("二叉树中叶子节点总数为:" + leaf(tree));
//        System.out.println("二叉树中父节点总数为:" + fatherNodes(tree));
        System.out.println("二叉树中只拥有一个孩子的父节点数:" + oneChildFather(tree));
//        System.out.println("二叉树中只拥有左孩子的父节点总数:" + leftChildFather(tree));
//        System.out.println("二叉树中只拥有右孩子的父节点总数:" + rightChildFather(tree));
//        System.out.println("二叉树中同时拥有两个孩子的父节点个数为:" + doubleChildFather(tree));
        System.out.println("--------------------------------------");
//        tree.exChange();
//        System.out.println("交换每个节点的左右孩子节点后......");
//        System.out.println("递归前序遍历二叉树结果: ");
//        tree.preOrder(tree);
//        System.out.println();
//        System.out.println("非递归前序遍历二叉树结果: ");
//        tree.iterativePreOrder(tree);
//        System.out.println();
//        System.out.println("递归中序遍历二叉树的结果为:");
//        tree.inOrder(tree);
//        System.out.println();
//        System.out.println("非递归中序遍历二叉树的结果为:");
//        tree.iterativeInOrder(tree);
//        System.out.println();
//        System.out.println("递归后序遍历二叉树的结果为:");
//        tree.postOrder(tree);
//        System.out.println();
//        System.out.println("非递归后序遍历二叉树的结果为:");
//        tree.iterativePostOrder(tree);
//        System.out.println();
//        System.out.println("层次遍历二叉树结果: ");
//        tree.LayerOrder(tree);
//        System.out.println();
//
//        System.out.println("递归求二叉树中所有结点的和为:" + getSumByRecursion(tree));
//        System.out.println("非递归求二叉树中所有结点的和为:" + getSumByNoRecursion(tree));
//
//        System.out.println("二叉树中,每个节点所在的层数为:");
//        for (int p = 1; p <= 14; p++)
//            System.out.println(p + "所在的层为:" + tree.level(p));
//        System.out.println("二叉树的高度为:" + height(tree));
//        System.out.println("二叉树中节点总数为:" + nodes(tree));
//        System.out.println("二叉树中叶子节点总数为:" + leaf(tree));
//        System.out.println("二叉树中父节点总数为:" + fatherNodes(tree));
//        System.out.println("二叉树中只拥有一个孩子的父节点数:" + oneChildFather(tree));
//        System.out.println("二叉树中只拥有左孩子的父节点总数:" + leftChildFather(tree));
//        System.out.println("二叉树中只拥有右孩子的父节点总数:" + rightChildFather(tree));
//        System.out.println("二叉树中同时拥有两个孩子的父节点个数为:" + doubleChildFather(tree));


    }
}  