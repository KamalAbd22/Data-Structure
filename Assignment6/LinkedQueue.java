package eg.edu.alexu.csd.datastructure.queue.cs52;

public class LinkedQueue implements IQueue {
	public class Node<Object>{
		Object value;
		Node next;
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	
	int size;
	Node head;
	Node tail;
	public LinkedQueue() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public void enqueue(Object item) {
		if(size==0) {
			head=new Node<Object>(item, null);
			tail=head;
			size++;
			return;
		}
		Node node =new Node<Object>(item, null);
		tail.setNext(node);
		tail=node;
		size++;
		return;
	}
	
	@Override
	public Object dequeue() {
		if(size==0) {
			System.out.println("error! underflow");return null;
		}
		Object save =head.value;
		head=head.next;
		size--;
		if(size==0) {
			tail=null;
		}
		return save;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}
	
	@Override
	public int size() {
		return size;
	}
}
