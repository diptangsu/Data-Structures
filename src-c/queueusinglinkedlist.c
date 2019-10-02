#include <stdio.h>
struct node
{
    int data;
    struct node *ptr;
};
struct node *front=NULL;
struct node *rear=NULL;

void insert(int ele)
{   struct node *t;
    t=(struct node *)malloc(sizeof(struct node));
    if(t==NULL)
        printf("overflow\n");
    else if(rear==NULL)
    {
        rear=t;
        front=t;
        t->data=ele;
        t->ptr=NULL;
    }
    else
    {
        rear->ptr=t;
        rear=t;
        t->data=ele;
        t->ptr=NULL;
    }
}

void del()
{   struct node *t;
    if(front==NULL)
        printf("Underflow\n");
    else if(front==rear)
    {
        printf("%d\n",front->data);
        free(front);
        front=NULL;
        rear=NULL;
    }
    else
    {
        printf("%d\n",front->data);
        t=front;
        front=front->ptr;
        free(t);
    }
}
void print()
{   struct node *t;
    for(t=front;t!=NULL;t=t->ptr)
    {
        printf("%d\n",t->data);
    }
}

void main()
{   int q,ele,prio;
    while(1)
    {
        printf("1.Insert\n2.Delete\n3.display\n4.exit\n");
        scanf("%d",&q);
        switch(q)
        {
            case 1: printf("Enter element\n");
                    scanf("%d",&ele);
                    insert(ele);
                    break;
            case 2: del();
                    break;
            case 4: exit(1);
                    break;
            case 3: print();
                    break;
            default:
                    printf("Invalid entry\n");
                    break;

        }
    }
}

