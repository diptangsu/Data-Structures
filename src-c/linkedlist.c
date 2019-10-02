#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node* link;
};
struct node *last;
struct node* root=NULL;
int len;
void append(void);
void insert(void);
int length(void);
void display(void);
void del(void);
void search(void);
void sort(void);
void main()
{   int ch;
    while(1)
    {
        printf("Single operations:\n");
        printf("1.app\n");
        printf("2.insertion\n");
        printf("3.deletion\n");
        printf("4.search\n");
        printf("5.sort\n");
        printf("6.display\n");
        printf("7.length\n");
        printf("8.exit\n");
        scanf("%d",&ch);

        switch(ch)
        {
            case 1: append();
                    break;
            case 2: insert();
                    break;
            case 3: del();
                    break;
            case 4: search();
                    break;
            case 8: len=length();
                    printf("%d\n",len);
                    break;
            case 5: sort();
                    break;
            case 6: display();
                    break;
            case 7: exit(1);
            default: printf("Invalid choice\n");
        }
    }
}
void append()
{   int i,n;
    struct node* temp;
    temp=(struct node*)malloc(sizeof(struct node));
    printf("Enter node data\n");
    scanf("%d",&temp->data);
    temp->link=NULL;
    if(root==NULL)
    {
        root=temp;
    }
    else
    {
      struct node* p;
        p=root;
        while(p->link!=NULL)
        {
            p=p->link;
        }
        p->link=temp;
    }
}
int length()
{
    int count=0;
    struct node* temp;
    temp=root;
    while(temp!=NULL)
    {
     count++;
     temp=temp->link;
    }
    return count;
}
void display()
{

    struct node* temp;
    temp=root;
    if(temp==NULL)
    {
        printf("list empty\n");
    }
    else
    {
        while(temp!=NULL)
        {
            printf("%d\n",temp->data);
            temp=temp->link;
        }
    }
    printf("\n\n");
}
void insert()
{   int ele,pos,i;
    struct node *temp,*pptr;
    printf("Enter element as position\n");
    scanf("%d%d",&ele,&pos);
    temp=(struct node*)malloc(sizeof(struct node));
    temp->data=ele;
    if(pos==1)
    {
        temp->link=root;
        root=temp;
    }
    else
    {
        pptr=root;
        for(i=2;i<pos&&(pptr->link!=NULL);i++)
        {
            pptr=pptr->link;
        }
        temp->link=pptr->link;
        pptr->link=temp;

    }
}
void del()
{   int pos,i;
    struct node *temp,*pptr;
    printf("Enter the position to be deleted from\n");
    scanf("%d",&pos);
    if(pos==1)
    {
        temp=root;
        root=temp->link;
    }
    else
    {
        pptr=NULL;
        temp=root;
        for(i=1;i<pos&&(temp->link!=NULL);i++)
        {
            pptr=temp;
            temp=temp->link;
        }
        pptr->link=temp->link;
    }
    free(temp);
}

void search()
{   int a,count=0;
    struct node *temp;
    temp=root;
    printf("Enter data to be searched\n");
    scanf("%d",&a);
    while(temp!=NULL)
    {   count++;
        if(temp->data==a)
        {
            printf("Found at %d \n",count);
        }
        temp=temp->link;
    }
}

void sort()
{   int q;
    struct node *temp,*pptr;
    for(pptr=root;pptr->link!=NULL;pptr=pptr->link)
    {
        for(temp=pptr->link;temp!=NULL;temp=temp->link)
        {
            if((pptr->data)>(temp->data))
            {
                q=pptr->data;
                pptr->data=temp->data;
                temp->data=q;
            }
        }
    }
}
