import Exceptions.OverflowException;
import Exceptions.UnderflowException;

import java.util.Scanner;

public class Queue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public Queue() {
        queue = null;
        size = 0;
        front = rear = -1;
    }

    public Queue(int size) {
        this.size = size;
        front = rear = -1;
        queue = new int[size];
    }

    public static void main(String[] args) {
        int ch, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue : ");
        int n = sc.nextInt();
        Queue q = new Queue(n);

        loop:
        for (; ; ) {
            System.out.print("1. Enqueue\n" +
                    "2. Dequeue\n" +
                    "3. Display\n" +
                    "0. Exit\n" +
                    "Enter your choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    break loop;
                case 1:
                    System.out.print("Enter the number you want to enqueue : ");
                    x = sc.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (OverflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        x = q.dequeue();
                        System.out.println(x + " has been removed");
                    } catch (UnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    q.display();
                    break;
                default:
                    System.out.println("Dude, seriously?\nI'm sure you can do better than that.\nTry again.");
            }
            System.out.println();
        }
    }

    private boolean isFull() {
        return rear >= size - 1;
    }

    private boolean isEmpty() {
        return front > rear;
    }

    public void enqueue(int x) throws OverflowException {
        if (front == -1)
            ++front;
        if (!isFull())
            queue[++rear] = x;
        else
            throw new OverflowException("Queue is full. Unable to enqueue");
    }

    public int dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Queue is empty. Unable to dequeue");
        }
        return queue[front++];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("[");
        for (int i = front; i < rear; i++)
            System.out.print(queue[i] + ", ");
        System.out.println(queue[rear] + "]");
    }
}
