import exception.OverflowException;

import java.util.Scanner;

public class CircularQueue {
    private int queue[], size, front, rear;

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

    public static void main(String args[]) {
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
                    q.enqueue(x);
                    break;
                case 2:
                    x = q.dequeue();
                    if (x == Integer.MIN_VALUE)
                        System.out.println("Queue is empty");
                    else
                        System.out.println(x + " has been removed");
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

    public void enqueue(int x) {
        if (!isFull()) {
            rear = (rear + 1) % size;
            queue[rear] = x;
        } else
            throw new OverflowException("Cannot enqueue. Queue is full");
    }

    public int dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % size;
            return queue[front];
        } else
            throw new OverflowException("Cannot dequeue. Queue is empty");
    }

    public void display() {
        if (!isEmpty()) {
            int i;
            for (i = (front + 1) % size; i != rear; i = (i + 1) % size)
                System.out.print(queue[i] + " ");
            System.out.println(queue[i]);
        } else
            System.out.println("Queue is empty");
    }
}
