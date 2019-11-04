#include<iostream>
using namespace std;

struct node {
	int data;
	struct node *next;
};

struct node* front = NULL, *rear = NULL;

void enqueue()
{
	struct node* temp = (struct node* )malloc(sizeof(struct node));
	cout<<"Enter data: ";
	cin>>temp->data;
	temp->next = NULL;

	if (front == NULL)
	{
		front = rear = temp;
		return;
	}

	rear->next = temp;
	rear = temp;
}

void dequeue()
{
	if (front == NULL)
	{
		cout<<"Empty!\n";
		return;
	}
	struct node* temp = front;
	cout<<"data: \n"<<front->data<<endl;
	if (front == rear)
		front = rear = NULL;
	else 
		front = front->next;
	free(temp);
}

void atFront()
{
	if (front == NULL)
	{
		cout<<"Empty!\n";
		return;
	}
	cout<<"At the top: \n"<<front->data<<endl;
}
void travers()
{
	struct node* temp=front;
	while(temp)
	{
	  cout<<temp->data<<" ";
	  temp=temp->next;
	}
	cout<<"\n";
}


int main()
{
	int choice;
	
	while(1)
	{
		cout<<"1. Enqueue\n2. Dequeue\n3. At front\n4. travers\n5. Exit\n\nEnter Choice: ";
		cin>>choice;
		switch(choice)
		{
			case 1: 
				enqueue();
				break;
			case 2:
				dequeue();
				break;
			case 3:
				atFront();
				break;
			case 4:
				travers();
				break;
			default:
				exit(0);
		}
	}

}
