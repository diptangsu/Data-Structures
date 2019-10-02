# include <stdio.h>
int q[3][5];
int fr[3][2]={-1,-1,-1,-1,-1,-1};

int row = 3;
int size = 5;

insertionPQ(int ele,int prio)
{
    if(fr[prio][0]==(fr[prio][1]+1)%size)
        printf("Overflow\n");
    else if(fr[prio][0]==-1)
    {
        fr[prio][0]=fr[prio][1]=0;
        q[prio][0] = ele;
    }
    else
    {
        fr[prio][1] = (fr[prio][1]+1)%size;
        q[prio][fr[prio][1]] = ele;
    }
}

deletionPQ(int prio)
{
    int i;
    for( i=0;i<row;i++)
    {
        if(fr[prio][0]!=-1)
        {
          printf("%d",q[prio][fr[prio][0]]);
          fr[prio][0] = (fr[prio][0]+1)%size;
          break;
        }
        else if(fr[prio][0]==fr[prio][1])
        {
            printf("%d",q[prio][fr[prio][0]]);
            fr[prio][0] = fr[prio][1]= -1;
            break;
        }
    }
    if(i==row)
        printf("Underflow");
}

    void display()
    {

        for(int i =0;i<row;i++)
        {
            for(int j=fr[i][0];j!=fr[i][1];j=(j+1)%size)
            {
                printf("%d ",q[i][j]);
            }
            printf("%d\n" ,q[i][fr[i][1]]);
        }
    }

    int main()
    {
        int choice,ele,prio;
        do
        {
            printf("1-enque\n2-deque\n3-display\n enter choice :");
            scanf("%d",&choice);

            switch(choice){
            case 1 :
            printf("Enter element and prio\n");
            scanf("%d%d",&ele,&prio);
            insertionPQ(ele,prio);
            break;
        case 2:
            printf("enter priority");
            scanf("%d",&prio);
            deletionPQ(prio);
            break;
        case 3:
            display();
            break;
        case 4:
            return 0;
        }
        }
        while(choice!=4);
        return 0;
    }

