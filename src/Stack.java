import exception.OverflowException;
import exception.UnderflowException;

import java.util.Scanner;

public class Stack {
    private int stack[];
    private int size, top;

    Stack() {
        stack = null;
        size = 0;
        top = -1;
    }

    Stack(int size) {
        this.size = size;
        top = -1;
        stack = new int[size];
    }

    public static void main(String args[]) {
        int ch, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack : ");
        int n = sc.nextInt();
        Stack s = new Stack(n);

        loop:
        for (; ; ) {
            System.out.print("1. Push\n" +
                    "2. Pop\n" +
                    "3. Display\n" +
                    "0. Exit\n" +
                    "Enter your choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    break loop;
                case 1:
                    System.out.print("Enter the number you want to push : ");
                    x = sc.nextInt();
                    s.push(x);
                    break;
                case 2:
                    x = s.pop();
                    if (x == Integer.MIN_VALUE)
                        System.out.println("Stack is empty");
                    else
                        System.out.println(x + " has been popped");
                    break;
                case 3:
                    s.display();
                    break;
                default:
                    System.out.println("Dude, seriously?\nI'm sure you can do better than that.\nTry again.");
            }
            System.out.println();
        }
    }

    private boolean isFull() {
        return top >= size - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void push(int x) {
        if (!isFull())
            stack[++top] = x;
        else
            throw new OverflowException("Stack is full. Unable to push");
    }

    private int pop() {
        if(isEmpty())
            throw new UnderflowException("Stack is empty. Unable to pop");

        return stack[top--];
    }

    private void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i <= top; i++)
            System.out.print(stack[i] + " ");
        System.out.println();
    }
}
