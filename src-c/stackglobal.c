#include <stdio.h>
int stack[100];
top=-1;
size=100;

int main()
{   int q,x,ele;
    while(1)
    {
        printf("1.pop\n2.push\n");
        scanf("%d",&q);
        switch(q)
        {
            case 1: x=pop();
                    printf("%d has been popped\n",x);
                    display(stack,top);
                    break;
            case 2: printf("Enter element to be pushed\n");
                    scanf("%d",&ele);
                    push(ele);
                    display(stack,top);
                    break;
            default:
                    printf("invalid entry\n");
                    break;
        }
    }

}

void push(int ele)
{
    if(top==size-1)
    {
        printf("Overflow\n");
    }
    else
    {
        stack[++top]=ele;
    }
}

int pop()
{
    if(top==-1)
    {
        printf("Underflow\n");
    }
    else
    {
        return stack[top--];
    }

}
void display()
{   int i;
    for(i=top;i>=0;i--)
    {
        printf("%d\n",stack[i]);
    }
}
