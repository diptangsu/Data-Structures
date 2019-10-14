/* Implementation of Stack in C++
    Using Array */
#include <bits/stdc++.h> 
  
using namespace std; 
  
#define MAX 5000 
  
class Stack { 
    int top; 
  
public: 
    int a[MAX]; 
  
    Stack() { 
        top = -1; 
        
    } 
    void push(int x); 
    int pop(); 
    int peek(); 
    bool isEmpty(); 
}; 
  
void Stack::push(int x) 
{ 
    if (top >= (MAX - 1)) { 
        cout << "Stack Overflow"; 
        return;
    } 
    else { 
        a[++top] = x; 
        cout << x << " pushed into stack\n"; 
    } 
} 
  
int Stack::pop() 
{ 
    if (top < 0) { 
        cout << "Stack Underflow"; 
        return 0; 
    } 
    else { 
        int x = a[top--]; 
        return x; 
    } 
} 
int Stack::peek() 
{ 
    if (top < 0) { 
        cout << "Stack is Empty"; 
        return 0; 
    } 
    else { 
        int x = a[top]; 
        return x; 
    } 
} 
  
bool Stack::isEmpty() 
{ 
    if(top < 0) return true;
    else return false;
} 
  
// main fuction  
int main() 
{ 
    class Stack st; 
    st.push(5); 
    st.push(15); 
    st.push(45);
    st.push(55);
    cout << st.pop() << " Popped from stack\n"; 
  
    return 0; 
} 