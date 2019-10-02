#include <stdio.h>


int main()
{   int q,x,ele;
    int stack[100];
    int top=-1;
    int size=100;
    while(1)
    {
        printf("1.pop\n2.push\n");
        scanf("%d",&q);
        switch(q)
        {
            case 1: x=pop(&stack,&top);
                    printf("%d has been popped\n",x);
                    display(&stack,&top);
                    break;
            case 2: printf("Enter element to be pushed\n");
                    scanf("%d",&ele);
                    push(&stack,size,&top,ele);
                    display(&stack,&top);
                    break;
            default:
                    printf("invalid entry\n");
                    break;
        }
    }

}

void push(int *stack,int size,int *top,int ele)
{
    if(*top==size-1)
    {
        printf("Overflow\n");
    }
    else
    {
        *(stack+(++*top))=ele;
    }
}

int pop(int *stack,int *top)
{
    if(*top==-1)
    {
        printf("Underflow\n");
    }
    else
    {
        return stack[(*(top))--];
    }

}
void display(int *stack,int *top)
{   int i;
    for(i=*top;i>=0;i--)
    {
        printf("%d\n",*(stack+i));
    }
}

