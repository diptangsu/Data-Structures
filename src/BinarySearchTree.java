import java.util.Scanner;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch, x;
        BinarySearchTree bst = new BinarySearchTree();

        loop:
        for (; ; ) {
            System.out.print("1. Insert node\n" +
                    "2. Insert node using recursion\n" +
                    "3. In order traversal\n" +
                    "4. Pre order traversal\n" +
                    "5. Post order traversal\n" +
                    "6. Delete node\n" +
                    "0. Exit\n" +
                    "Enter your choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 0:
                    break loop;
                case 1:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    bst.insertChild(x);
                    break;
                case 2:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    bst.insertChildRecursion(bst.root, x);
                    break;
                case 3:
                    bst.inOrder(bst.root);
                    break;
                case 4:
                    bst.preOrder(bst.root);
                    break;
                case 5:
                    bst.postOrder(bst.root);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Get a pair of specs, maybe?");
            }
            System.out.println();
        }
    }

    public void insertChild(int x) {
        Node n = new Node(x);
        Node t = root;
        if (t == null) {
            root = n;
            return;
        }
        for (; ; ) {
            if (x < t.data) {
                if (t.left == null) {
                    t.left = n;
                    break;
                } else
                    t = t.left;
            } else {
                if (t.right == null) {
                    t.right = n;
                    break;
                } else
                    t = t.right;
            }
        }
    }

    public void insertChildRecursion(Node n, int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        if (x < n.data) {
            if (n.left == null) {
                n.left = new Node(x);
            } else
                insertChildRecursion(n.left, x);
        } else {
            if (n.right == null) {
                n.right = new Node(x);
            } else
                insertChildRecursion(n.right, x);
        }
    }

    public void inOrder(Node x) {
        if (x == null)
            return;
        inOrder(x.left);
        System.out.print(x.data + " ");
        inOrder(x.right);
    }

    public void preOrder(Node x) {
        if (x == null)
            return;
        System.out.print(x.data + " ");
        inOrder(x.left);
        inOrder(x.right);
    }

    public void postOrder(Node x) {
        if (x == null)
            return;
        inOrder(x.left);
        inOrder(x.right);
        System.out.print(x.data + " ");
    }

    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        public Node() {
            data = 0;
            left = right = null;
        }
    }
}
