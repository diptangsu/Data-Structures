public class CircularLinkedList {

	public int size = 0;
	public Node head = null;
	public Node tail = null;

	public void addNodeAtStart(int data) 
	{
		Node n = new Node(data);
		
		if (size == 0) 
		{	
			head = n;
			tail = n;
			n.next = head;
		} 
		else 
		{
			Node temp = head;
			n.next = temp;
			head = n;
			tail.next = head;
		}
		size++;
	}

	public void addNodeAtEnd(int data) {
		
		if (size == 0) 
		{
			addNodeAtStart(data);
		} 
		else 
		{
			Node n = new Node(data);
			tail.next = n;
			tail = n;
			tail.next = head;
			size++;
		}
	}

	public void deleteNodeFromStart() {
		
		if (size == 0) 
		{
			System.out.println("Nothing to Delete");
		} 
		else 
		{
			head = head.next;
			tail.next = head;
			size--;
		}
	}

	public int elementAt(int index) {
		
		if (index > size) 
		{
			return -1;
		}
		Node n = head;
		while (index - 1 != 0) 
		{
			n = n.next;
			index--;
		}
		
		return n.data;
	}

	public void print() {
		
		System.out.print("CircularLinked List:");
		Node temp = head;
		
		if (size <= 0) 
		{
			System.out.print("List is empty");
		} 
		else 
		{
			do 
			{
				System.out.print(" " + temp.data);
				temp = temp.next;
			} while (temp != head);
		}
		System.out.print("\n");
	}

	public int getSize() {
		return size;
	}
}
