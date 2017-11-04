public class Node {
    int data;
    Node next, prev;

    public Node() {
        data = 0;
        next = prev = null;
    }

    public Node(int data) {
        this.data = data;
        next = prev = null;
    }

    public Node(Node x) {
        data = x.data;
        next = x.next;
        prev = x.prev;
    }

    public boolean equals(Node x) {
        if (data != x.data) {
            return false;
        }
        return true;
    }
}
