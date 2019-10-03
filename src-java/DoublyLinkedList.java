import Exceptions.InvalidPositionException;

import java.util.Scanner;

public class DoublyLinkedList {

    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        int ch, x, pos, del;

        loop:
        for (; ; ) {
            System.out.print("1. Insert at Front\n" +
                    "2. Insert at End\n" +
                    "3. Delete from Front\n" +
                    "4. Delete from End\n" +
                    "5. Display\n" +
                    "6. Reverse\n" +
                    "7. Size\n" +
                    "0. Exit\n" +
                    "Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 0:
                    break loop;
                case 1:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    doublyLinkedList.insertAtFront(x);
                    break;
                case 2:
                    System.out.print("Enter the value you want to insert : ");
                    x = sc.nextInt();
                    doublyLinkedList.insertAtEnd(x);
                    break;
                case 3:
                    del = doublyLinkedList.deleteFromFront();
                    if (del == -999)
                        System.out.println("Linked List is empty");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
                case 4:
                    del = doublyLinkedList.deleteFromEnd();
                    if (del == -999)
                        System.out.println("Linked List is empty");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
                case 5:
                    System.out.println("Linked List : ");
                    doublyLinkedList.display();
                    break;
                case 6:
                    doublyLinkedList.reverse();
                    System.out.println("The Linked List has been reversed");
                    break;
                case 7:
                    System.out.println("The size is : " + doublyLinkedList.size());
                    break;

                default:
                    System.out.println("Enter a valid choice you blind fuck!");
            }
            System.out.println();
        }
    }

    private int size() {
        if (isEmpty())
            return 0;

        int counter = 1;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    private void reverse() {
        Node temp = null;
        Node currentNode = head;

        while (currentNode != null) {
            temp = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temp;
            currentNode = currentNode.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    private int deleteFromEnd() {
        if (isEmpty())
            throw new InvalidPositionException("Cannot delete from end since DoublyLinkedList is empty");

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        int value = temp.data;
        if (temp.prev != null) {
            temp.prev.next = null;
        } else {
            head = null;
        }
        return value;
    }

    private int deleteFromFront() {
        if (isEmpty())
            throw new InvalidPositionException("Cannot delete from front since DoublyLinkedList is empty");

        Node temp = head;
        int value = temp.data;
        head = temp.next;
        if (temp.next != null)
            temp.next.prev = null;
        return value;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void insertAtFront(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }

    private void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    private void display() {
        Node t;
        for (t = head; t != null; t = t.next) {
            System.out.print(t.data + " ");
        }
        System.out.println();
    }
}
