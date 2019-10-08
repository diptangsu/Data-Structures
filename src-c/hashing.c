#include<stdio.h>
int arr[10] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
int f1(int key)
{
return key%10;
}
int f2(int key)
{
return 7-(key%7);
}
int fun(int key, int n)
{
int i;
i = (f1(key)+(n*f2(key)))%10;
return i;
}
void insert()
{
int num,i;
printf("Enter the number: ");
scanf("%d",&num);
i = f1(num);
if(arr[i] == -1)
arr[i] = num;
else
{
int i,ind;
for(i=1; i<=10; i++)
{
ind = fun(num,i);
if(arr[ind] == -1)
{
arr[ind] = num;
break;
}
}
if(i == 11)
printf("Element cannot be inserted\n");
}
}
void display()
{
int i;
for(i=0; i<10; i++)
{
if(arr[i] == -1)
printf("\n%d -> \n",i);
else
printf("%d -> %d\n",i,arr[i]);
}
}


void main()
{
int che;
do{
printf("\nEnter your choice\n1.Insert\n2.Display\n0.Exit\nEnter element:\t ");
scanf("%d",&che);
switch(che)
{
case 1 : insert();
break;
case 2 : display();
break;
case 3 : printf("Exiting");
break;
}
}while(che != 3);
}

