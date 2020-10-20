import java.util.LinkedList;

import java.util.Collections;

class main{
    
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of elements you want in your linked list: ");
        int a=sc.nextInt();
        int b;
        System.out.print("Enter the elements in your linked list: ");
        for(int i=0;i<a;i++){
            b=sc.nextInt();
            linkedList.add(b);
        }
        System.out.println();
        System.out.println("The elements after traversing the linked list in reverse are: ");
        ListIterator<Integer> listIterator= linkedList.listIterator();
        for(int i=0;i<a;i++){
            if(listIterator.hasNext()){
                stack.push(listIterator.next());
            }
        }
        for(int i=0;i<a;i++){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
}