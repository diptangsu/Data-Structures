#include <stdio.h>
int main()
{   int q,a[100],n=0,size=100,inspos,insele,i,delpos,delele,temp,slow,sup,sele,x;
    while(1)
    {
        printf("1.create\n");
        printf("2.insert\n");
        printf("3.delete\n");
        printf("4.sort\n");
        printf("5.search\n");
        printf("6.display\n");
        printf("7.quit\n");
        scanf("%d",&q);
        switch(q)
        {
            case 1: printf("Enter no:of elements to insert");
                    scanf("%d",&n);
                    for(i=0;i<n;i++)
                    {
                        scanf("%d",&a[i]);
                    }
                    break;

            case 2: printf("Enter position and element\n");
                    scanf("%d%d",&inspos,&insele);
                    if(n<=size-1&&inspos>=1&&inspos<=(n+2))
                    {
                        for(i=n;i>=inspos-1;i--)
                        {
                            a[i+1]=a[i];
                        }
                        a[inspos-1]=insele;
                        n++;
                    }
                    else
                        printf(("Can't enter\n"));
                    break;
            case 3: printf("Enter position and element\n");
                    scanf("%d%d",&delpos,&delele);
                    if(n!=-1&&delpos>=1&&delpos<=n+1)
                    {
                        for(i=delpos-1;i<n;i++)
                        {
                            a[i]=a[i+1];
                        }
                        n--;
                    }
                    else
                        printf("Cant delete\n");
                    break;

            case 4: for(i=0;i<n;i++)
                    {
                        if(a[i]>a[i+1])
                        {
                            temp=a[i+1];
                            a[i+1]=a[i];
                            a[i]=temp;
                        }
                    }
                    break;

            case 5: slow=0;
                    sup=n;
                    printf("Enter element to be searched\n");
                    scanf("%d",&sele);
                    x=search(a,n,slow,sup,sele);
                    printf("%d\n",x);
                    break;

            case 6: if(n!=0)
                    {
                        for(i=0;i<n;i++)
                        {
                            printf("%d\n",a[i]);
                        }
                    }
                    else
                    {
                        printf("No elements in the array\n");
                    }
                    break;
            case 7:
                    exit(1);
                    break;
            default: printf("Invalid entry\n");
        }
    }
}
int search(int a[],int n,int slow,int sup,int sele)
{   int smid,x;
    if(slow<=sup)
        {
            smid=(slow+sup)/2;
            if(sele>a[smid])
                {
                    slow=smid+1;
                    x=search(a,n,slow,sup,sele);
                }
            else if(sele<a[smid])
            {
              sup=smid-1;
              x=search(a,n,slow,sup,sele);
            }
            else
                return smid;
            return x;
        }
    else if(slow>sup)
    {
        return -1;
    }
}
