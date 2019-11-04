#include<iostream>
using namespace std;
struct node
{
	int data;
	node* next;
};
node* head;
void push(int x)
{
	node* temp=new node();
	temp->data=x;
	temp->next=NULL;
	if(head==NULL){
		head=temp;
		return;
	}

	temp->next=head;
	head=temp;
}
void top()
{
	node* temp=head;
	cout<<"Top elements is: "<<temp->data<<endl;
}
void print(node* p)
{
	if(p==NULL) return;
	cout<<p->data<<" ";
	print(p->next);
}
int main()
{
	head=NULL;
	int n,x;
	cout<<"How many numbers:";
	cin>>n;
	for (int i = 0; i < n; ++i)
	{
		cout<<"Enter numbers you want to push into stack: ";
		cin>>x;
		push(x);
	}
	print(head);
	cout<<""<<endl;
	top();
	cout<<""<<endl;
	return 0;
}