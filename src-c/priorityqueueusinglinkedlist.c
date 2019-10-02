#include <stdio.h>

struct node
{
    int data;
    int pri;
    struct node *ptr;
};
struct node *start=NULL;
struct node *t1,*t2;

void insert(int ele,int pri)
{   struct node *t;
    t=(struct node*)malloc(sizeof(struct node));
    if(t==NULL)
        printf("Overflow");
    else if(start==NULL||start->pri>pri)
    {
        t->data=ele;
        t->pri=pri;
        t->ptr=start;
        start=t;
    }
    else
    {
        t1=start;
        t2=start;
        for(t2=start;t2->pri<=pri&&t2!=NULL;t2=t2->ptr)
            {t1=t2;}
        t->ptr=t1->ptr;
        t1->ptr=t;
        t->data=ele;
        t->ptr=pri;
    }
}
void deletion()
{
    printf("%d\n",start->data);
    start=start->ptr;
}
void display()
{
    struct node *t;
    t=start;
    for(t=start;t!=NULL;t=t->ptr)
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
                    printf("Enter priority\n");
                    scanf("%d",&prio);
                    insert(ele,prio);
                    break;
            case 2: deletion();
                    break;
            case 4: exit(1);
                    break;
            case 3: display();
                    break;
            default:
                    printf("Invalid entry\n");
                    break;

        }
    }
}
