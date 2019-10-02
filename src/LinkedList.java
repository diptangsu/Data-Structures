import exception.InvalidPositionException;

import java.util.Scanner;

public class LinkedList {
    Node start;

    public LinkedList() {
        start = null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int ch, x, pos, del;

        loop:
        for (; ; ) {
            System.out.print("1. Insert at Front\n" +
                    "2. Insert at End\n" +
                    "3. Insert at Position\n" +
                    "4. Delete at Front\n" +
                    "5. Delete at End\n" +
                    "6. Delete at Position\n" +
                    "7. Display\n" +
                    "8. Reverse\n" +
                    "9. Recursive Reverse\n" +
                    "10. Size\n" +
                    "11. Reverse in groups\n" +
                    "12. Check if the Linked List is a palindrome\n" +
                    "0. Exit\n" +
                    "Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 0:
                    break loop;
                case 1:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    linkedList.insertAtFront(x);
                    break;
                case 2:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    linkedList.insertAtEnd(x);
                    break;
                case 3:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    System.out.print("Enter the position where you want to enter it : ");
                    pos = sc.nextInt();
                    linkedList.insertAtPos(x, pos);
                    break;
                case 4:
                    del = linkedList.deleteAtFront();
                    if (del == -999)
                        System.out.println("Linked List is empty");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
                case 5:
                    del = linkedList.deleteAtEnd();
                    if (del == -999)
                        System.out.println("Linked List is empty");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
                case 6:
                    System.out.print("Enter the position which you want to remove : ");
                    pos = sc.nextInt();
                    del = linkedList.deleteAtPos(pos);
                    if (del == -999)
                        System.out.println("Position is invalid");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
                case 7:
                    System.out.println("Linked List : ");
                    linkedList.display();
                    break;
                case 8:
                    linkedList.reverse();
                    System.out.println("The Linked List has been reversed");
                    break;
                case 9:
                    linkedList.recursiveReverse(linkedList.start, null);
                    System.out.println("The Linked List has been reversed");
                    break;
                case 10:
                    System.out.println(linkedList.size());
                    break;
                case 11:
                    System.out.print("Enter the size of the group you want to reverse : ");
                    x = sc.nextInt();
                    linkedList.start = linkedList.reverseGroup(linkedList.start, x);
                    System.out.println("The Linked ist has been reversed in groups of " + x);
                    break;
                case 12:
                    if (linkedList.isPalindromeList())
                        System.out.println("The Linked List is a palindrome");
                    else
                        System.out.println("The Linked List is not a palindrome");
                    break;
                default:
                    System.out.println("Enter a valid choice you blind fuck!");
            }
            System.out.println();
        }
    }

    private void insertAtEnd(int x) {
        Node t, n;
        n = new Node(x);
        if (start == null) {
            start = n;
            return;
        }
        for (t = start; t.next != null; t = t.next) ;
        t.next = n;
    }

    private void insertAtFront(int x) {
        Node n = new Node(x);
        n.next = start;
        start = n;
    }

    private void insertAtPos(int x, int pos) {
        Node n = new Node(x);
        Node t;
        if (start == null) {
            start = n;
            return;
        }
        int i = 1;
        for (t = start; i < pos - 1; i++, t = t.next) ;
        n.next = t.next;
        t.next = n;
    }

    private int deleteAtEnd() {
        if (start == null)
            throw new InvalidPositionException("Cannot delete at end since the LinkedList is empty");
        Node t;
        for (t = start; t.next.next != null; t = t.next) ;
        int del = t.next.data;
        t.next = null;
        return del;
    }

    private int deleteAtFront() {
        if (start == null)
            throw new InvalidPositionException("Cannot delete at front since the LinkedList is empty");
        int del = start.data;
        start = start.next;
        return del;
    }

    private int deleteAtPos(int pos) {
        int del;
        if (pos == 1)
            return deleteAtFront();
        if (pos == size())
            return deleteAtEnd();
        if (pos < 0 || pos > size())
            throw new InvalidPositionException("Cannot delete at invalid position" + pos);
        Node t;
        int i = 0;
        for (t = start; i < pos - 2; i++, t = t.next) ;
        del = t.next.data;
        t.next = t.next.next;
        return del;
    }

    private int size() {
        Node t;
        int len = 0;
        for (t = start; t != null; t = t.next, len++) ;
        return len;
    }

    private void display() {
        Node t;
        for (t = start; t != null; t = t.next) {
            System.out.print(t.data + " ");
        }
        System.out.println();
    }

    private void reverse() {
        Node prev, cur, next;
        prev = null;
        cur = start;
        for (; cur != null; ) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        start = prev;
    }

    /**
     * @param cur  holds the reference to the current Node. pass root Node while calling.
     * @param prev holds the reference to the previous Node. pass null while calling.
     */
    private void recursiveReverse(Node cur, Node prev) {
        //last node reached
        if (cur.next == null) {
            start = cur;
            cur.next = prev;
            return;
        }

        Node next = cur.next;
        cur.next = prev;

        recursiveReverse(next, cur);
    }

    /**
     * @param b holds the reference to the beginning Node.
     * @param g size of the group by which the Linked List will be reversed.
     */
    private Node reverseGroup(Node b, int g) {
        Node prev, cur, next;
        prev = null;
        cur = b;
        next = null;
        for (int i = 1; i <= g && cur != null; ++i) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if (cur != null)
            b.next = reverseGroup(next, g);
        return prev;
    }

    private boolean isPalindromeList() {
        int l = size();
        LinkedList temp = new LinkedList();
        Node t = start;
        for (int i = 0; i < l / 2; i++) {
            temp.insertAtFront(t.data);
            t = t.next;
        }
        if (l % 2 != 0)
            t = t.next;
        for (int i = 0; i < l / 2; i++, t = t.next) {
            if (temp.deleteAtFront() != t.data)
                return false;
        }
        return true;
    }

    /*private boolean isPalindromeRecursive(Node x, Node t, int i, int n) {
        if (n % 2 != 0 && i == n / 2 + 1)
            return isPalindromeRecursive(x, x.next, i + 1, n);
        if (i > n / 2)
            return x.data == t.data;
        else
    }*/
}
