# Data-Structures
---
This contains all the programs for data structures that are a part of the syllabus of MAKAUT 2nd year Computer Science and engineering course.

- [C](https://github.com/diptangsu/Data-Structures/blob/master/src-c)
- [C++](https://github.com/diptangsu/Data-Structures/blob/master/src-cpp)
- [Java](https://github.com/diptangsu/Data-Structures/blob/master/src-java)
- [Javascript](https://github.com/diptangsu/Data-Structures/blob/master/src-javascript)
- [Python](https://github.com/diptangsu/Data-Structures/blob/master/src-python) :snake:
- [Php](https://github.com/diptangsu/Data-Structures/blob/master/src-php)

---
# Stack
Stack is a linear data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out).

### Main methods
- Push(new item)
    - Inserts new element at the "top" of the Stack.
    - Need to send the new item as argument.
- Pop() 
    - Takes out the most top element from the Stack.
    - No arguments needed.

---
# Linked List
A linked list is a sequence of data structures, which are connected together via links.
Linked List is a sequence of links which contains items. Each link contains a connection to another link. Linked list is the second most-used data structure after array.
### Main methods
- Get
    - getFirst()
        - Gets the first element of the List.
    - getLast()
        - Gets the last element of the List.
    - getAt(index)
        - Gets the element at the index provided or null otherwise.
- Insert
    - insertFirst(new_item)
        - Inserts the new item in the first index of the List, the previous first takes second place.
    - insertLast(new_item)
        - Inserts the new item at the new last index (previous last index + 1) of the List.
    - insertAt(new_item, index)
        - Inserts the new item at the provided index if size_of_list >= index and index > 0.
- Remove
    - removeFirst()
        - Removes the item on the first index of the List, so the item on the second index takes the first place.
    - removeLast()
        - Removes the item in the last index of the List
    - removeAt(index)
        - Removes the item at the provided index if size_of_list >= index and index > 0.
### Subtypes
#### Double Linked List
It's a subtype of Linked List where each node is not only connected to the next node, but also to the previous node. Everything else is the same as a Linked List.
##### Circular Linked List
A linked list is a sequence of data structures, which are connected together via links. Linked List is a sequence of links which contains items. Each link contains a connection to another link. The main property of the Circular Linked List, which is also the main difference with the Linked List, is that the last nodes is linked to the first one.
#### Circular Double Linked List
Takes the best of the two previous subtypes, the first and last nodes are linked, and links between the nodes are in both ways.

---
# Queue
A Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO).
### Main methods
- Enqueue(new_item)
    - Inserting the new item at the beginning of the Queue.
- Dequeue()
    - Taking out the last item of the Queue.
- Peek()
    - Get the last item of the Queue without remove it.
- IsEmpty()
    - Verify if Queue is empty.

---
# Tree :deciduous_tree:
 Tree is a widely used abstract data type that simulates a hierarchical tree structure, with a root value and subtrees of children with a parent node, represented as a set of linked nodes.
### Main methods
- Insert(new_item)
    - Inserts the new item in the correct tree node
- Get
    - Pre-Order()
    - In-Order()
    - Post-Order()

---
## Contributing :octocat:
To start contributing, check out [CONTRIBUTING.md](https://github.com/diptangsu/Data-Structures/blob/master/CONTRIBUTING.MD). New contributors are always welcome to support this project. Check out issues labelled as `Hacktoberfest` if you are up for some grabs! :)
