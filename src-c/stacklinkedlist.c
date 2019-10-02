#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *ptr;
};

struct node* push(struct node *top,int ele)
{
    struct node *t;
    t=(struct node *)malloc(sizeof(struct node));
    if(t==NULL)
    {
        printf("Memory overflow\n");
    }
    else
    {
        t->data=ele;
        t->ptr=top;
        top=t;
    }
    return top;
}
struct node* pop(struct node *top)
{   int ele;
    struct node *t;
    if(top==NULL)
    {
        printf("Underflow\n");
    }
    else
    {
        t=top;
        top = top->ptr;
        ele =t->data;
        free(t);
        return top;
    }
}
void display(struct node *top)
{
    for(top;top!=NULL;top=top->ptr)
    {
        printf("%d\n",top->data);
    }
}
int main()
{
    struct node *top=NULL;
    int q,x,ele;
    while(1)
    {
        printf("1.pop\n2.push\n");
        scanf("%d",&q);
        switch(q)
        {
            case 1: top=pop(top);
                    display(top);
                    break;
            case 2: printf("Enter element to be pushed\n");
                    scanf("%d",&ele);
                    top=push(top,ele);
                    display(top);
                    break;
            default:
                    printf("invalid entry\n");
                    break;
        }
    }
}
