import Exceptions.StackOverflowException;
import Exceptions.StackUnderflowException;

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
                    try {
                        s.push(x);
                    } catch (StackOverflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println(x + " has been popped");
                    } catch (StackUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
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

    private void push(int x) throws StackOverflowException {
        if (!isFull())
            stack[++top] = x;
        else
            throw new StackOverflowException("Stack is full");
    }

    private int pop() throws StackUnderflowException {
        if (!isEmpty())
            return stack[top--];
        else
            throw new StackUnderflowException("Stack is empty");
    }

    private void display() {
        System.out.print("[");
        for (int i = 0; i <= top; i++)
            System.out.print(stack[i] + ", ");
        System.out.println("]");
    }
}
