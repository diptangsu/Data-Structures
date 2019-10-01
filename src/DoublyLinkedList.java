import java.util.Scanner;

public class DoublyLinkedList {

    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        int ch, x, pos, del;

        loop:
        for (; ; ) {
            System.out.print("1. Insert at Front\n" +
                    "2. Insert at End\n" +
                    "3. Delete at Front\n" +
//                    "4. Delete at End\n" +
                    "5. Display\n" +
//                    "6. Reverse\n" +
//                    "7. Size\n" +
//                    "0. Exit\n" +
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
                    del = doublyLinkedList.deleteAtFront();
                    if (del == -999)
                        System.out.println("Linked List is empty");
                    else
                        System.out.println(del + " has been removed from the Linked List");
                    break;
//                case 5:
//                    del = linkedList.deleteAtEnd();
//                    if (del == -999)
//                        System.out.println("Linked List is empty");
//                    else
//                        System.out.println(del + " has been removed from the Linked List");
//                    break;
//                case 6:
//                    System.out.print("Enter the position which you want to remove : ");
//                    pos = sc.nextInt();
//                    del = linkedList.deleteAtPos(pos);
//                    if (del == -999)
//                        System.out.println("Position is invalid");
//                    else
//                        System.out.println(del + " has been removed from the Linked List");
//                    break;
                case 7:
                    System.out.println("Linked List : ");
                    doublyLinkedList.display();
                    break;
//                case 8:
//                    linkedList.reverse();
//                    System.out.println("The Linked List has been reversed");
//                    break;
//                case 9:
//                    linkedList.recursiveReverse(linkedList.start, null);
//                    System.out.println("The Linked List has been reversed");
//                    break;
//                case 10:
//                    System.out.println(linkedList.size());
//                    break;
//                case 11:
//                    System.out.print("Enter the size of the group you want to reverse : ");
//                    x = sc.nextInt();
//                    linkedList.start = linkedList.reverseGroup(linkedList.start, x);
//                    System.out.println("The Linked ist has been reversed in groups of " + x);
//                    break;
//                case 12:
//                    if (linkedList.isPalindromeList())
//                        System.out.println("The Linked List is a palindrome");
//                    else
//                        System.out.println("The Linked List is not a palindrome");
//                    break;
                default:
                    System.out.println("Enter a valid choice you blind fuck!");
            }
            System.out.println();
        }
    }

    private int deleteAtFront() {
        if(isEmpty())
            return -999;

        Node temp = head;
        int value = temp.data;
        head = temp.next;
        if(temp.next != null)
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

        if(isEmpty()) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
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
