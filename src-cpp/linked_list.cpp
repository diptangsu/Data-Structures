#include<iostream>
using namespace std;


class node{
public:
    int data;
    node*next;

    node(int d){
        data = d;
        next = NULL;
    }
    ~node(){
        int temp = data;
        if(next!=NULL){
            delete next;
            next = NULL;
        }
        cout<<"Deleting node with data "<<temp<<endl;
    }
};
void insertAtHead(node * &head,int d){

    node  *n = new node(d);
    n->next = head;
    head = n;
}

void takeInput(node *&head){
    int d;
    cin>>d;
    while(d!=-1){
        insertAtHead(head,d);
        cin>>d;
    }
}
void print(node*head){
    while(head!=NULL){
        cout<<head->data<<"-->";
        head = head->next;
    }
    cout<<"NULL"<<endl;
}

int length(node *temp){
    int l=0;
    while(temp!=NULL){
        l++; temp = temp->next;
    }
    return l;
}
void insertInMiddle(node*&head,int d,int p){

    if(p==0){
        insertAtHead(head,d);
        return;
    }
    int jump=1;
    node*temp = head;
    while(jump<=p-1){
        jump++;
        temp = temp->next;
    }

    node*n = new node(d);
    n->next = temp->next;
    temp->next = n;

}

istream& operator>>(istream&is, node*&head){
    takeInput(head);
    return is;
}
ostream& operator<<(ostream&os, node*head){
    print(head);
    return os;
}

void deleteNode(node*&head,int d){
    node* prev = NULL;
    node* current = head;

    while(current!=NULL){
        if(current->data == d){
                if(prev==NULL){
                    ///Head Node
                    node*temp = head;
                    head = temp->next;
                    temp->next = NULL;
                    delete temp;
                    current = head;
                }
                else{
                    ///Some Middle Node
                    node*temp = current;
                    prev->next = current->next;
                    //temp->next = NULL;
                    temp->next = NULL;
                    delete temp;

                }

        }
        prev = current;
        current = current->next;
    }

}

int main(){
    node*head=NULL;
    cin>>head;
    cout<<head;


    cout<<"Enter data and postion ";
    int d,p;
    cin>>d>>p;
    insertInMiddle(head,d,p);
    cout<<head;


    cout<<"Enter the node to delete ";
    cin>>d;
    deleteNode(head,d);
    cout<<head;

    /*
    delete head;
    head = NULL;
    cout<<head;
    */
return 0;
}
