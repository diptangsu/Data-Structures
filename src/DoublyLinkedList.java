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
//                    "2. Insert at End\n" +
//                    "3. Insert at Position\n" +
//                    "4. Delete at Front\n" +
//                    "5. Delete at End\n" +
//                    "6. Delete at Position\n" +
//                    "7. Display\n" +
//                    "8. Reverse\n" +
//                    "9. Recursive Reverse\n" +
//                    "10. Size\n" +
//                    "11. Reverse in groups\n" +
//                    "12. Check if the Linked List is a palindrome\n" +
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
//                case 2:
//                    System.out.print("Enter the value you want to insert : ");
//                    x = sc.nextInt();
//                    linkedList.insertAtEnd(x);
//                    break;
//                case 3:
//                    System.out.print("Enter the value you want to insert : ");
//                    x = sc.nextInt();
//                    System.out.print("Enter the position where you want to enter it : ");
//                    pos = sc.nextInt();
//                    linkedList.insertAtPos(x, pos);
//                    break;
//                case 4:
//                    del = linkedList.deleteAtFront();
//                    if (del == -999)
//                        System.out.println("Linked List is empty");
//                    else
//                        System.out.println(del + " has been removed from the Linked List");
//                    break;
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
//                case 7:
//                    System.out.println("Linked List : ");
//                    linkedList.display();
//                    break;
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

    private void insertAtFront(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }
}
