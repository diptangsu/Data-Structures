#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node* ptr;
};
struct node *last;
struct node* start=NULL;
struct node *t;
int len;
void insert(void);
void display(void);
void del(void);
void search(void);
void create(void);
void main()
{   int ch;
    while(1)
    {
        printf("Circular operations:\n");
        printf("1.create\n");
        printf("2.insertion\n");
        printf("3.deletion\n");
        printf("4.search\n");
        printf("6.display\n");
        printf("8.exit\n");
        scanf("%d",&ch);

        switch(ch)
        {
            case 1: create();
                    break;
            case 2: insert();
                    break;
            case 3: del();
                    break;
            case 4: search();
                    break;
            case 6: display();
                    break;
            case 7: exit(1);
            default: printf("Invalid choice\n");
        }
    }
    return 0;
}
void create()
{   int i,q;
    printf("Enter no:of elements\n");
    scanf("%d",&q);
    for(i=0;i<q;i++)
    {
        t=(struct node *)malloc(sizeof(struct node));
        scanf("%d",&t->data);
        if(start==NULL)
        {
            start=t;
        }
        else{
            last->ptr=t;
        }
        last=t;
    }
    last->ptr=start;
}

void insert()
{   int pos,ele,i;
    struct node *pptr;
   printf("Enter position and element\n");
   scanf("%d%d",&pos,&ele);
   t=(struct node *)malloc(sizeof(struct node));
   t->data=ele;
   if(pos==1)
   {
       for(last=start;last->ptr!=start;last=last->ptr)
       {
           t->ptr=start;
           start=t;
           last=t;
       }
   }
   else
   {
       pptr=start;
       for(i=2;i<pos&&pptr!=start;i++)
       {
           pptr=pptr->ptr;
       }
       t->ptr=pptr->ptr;
        pptr->ptr=t;
   }
}

void display()
{
    if(start!=NULL)
    {
        for(t=start;t->ptr!=start;t=t->ptr)
        {
            printf("%d\n",t->data);
        }
        printf("%d\n",t->data);
    }
    else
        printf("No elements in the array\n");
}
void search()
{   int ele,count=0;
    printf("Enter element to be searched\n");
    scanf("%d",&ele);
    if(start!=NULL)
    {
        for(t=start;t->ptr!=start;t=t->ptr)
        {   count++;
            if(t->data==ele)
            {
                printf("Element found at %d \n",count);
            }
        }
    }
    else
        printf("No elements in the array to search for\n");
}
void del()
{   int pos,i;
    struct node *t1;
    printf("Enter position to be deleted \n");
    scanf("%d",&pos);
    if(pos==1)
    {
        t=start;
        start=start->ptr;
        free(t);
        last->ptr=start;
    }
    else
    {
        t=start;
        for(i=1;i<pos&&t->ptr!=start;i++)
        {
            t1=t;
            t=t->ptr;
        }
        t1->ptr=t->ptr;
        free(t);
    }
}

