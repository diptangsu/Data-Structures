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

    @Override
    public int hashCode()
    {
        return data;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Node)
        {
            Node n = (Node)obj;
            return data == n.data;
        }
        else
            return false;
    }
}
