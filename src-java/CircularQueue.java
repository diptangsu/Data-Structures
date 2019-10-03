import Exceptions.OverflowException;
import Exceptions.UnderflowException;

import java.util.Scanner;

public class CircularQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public CircularQueue() {
        queue = null;
        size = 0;
        front = rear = 0;
    }

    public CircularQueue(int size) {
        this.size = size;
        front = rear = -1;
        queue = new int[size];
    }

    public static void main(String[] args) {
        int ch, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue : ");
        int n = sc.nextInt();
        n = Math.abs(n);
        CircularQueue q = new CircularQueue(n);

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
        return (rear + 1) % size == front;
    }

    private boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(int x) throws OverflowException {
        if (!isFull()) {
            rear = (rear + 1) % size;
            queue[rear] = x;
        } else
            throw new OverflowException("Cannot enqueue. Queue is full");
    }

    public int dequeue() throws UnderflowException {
        if (!isEmpty()) {
            front = (front + 1) % size;
            return queue[front];
        } else
            throw new UnderflowException("Cannot dequeue. Queue is empty");
    }

    public void display() {
        if (!isEmpty()) {
            int i;
            System.out.print("[");
            for (i = (front + 1) % size; i != rear; i = (i + 1) % size)
                System.out.print(queue[i] + ", ");
            System.out.println(queue[i] + "]");
        } else
            System.out.println("[]");
    }
}
