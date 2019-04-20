package eg.edu.alexu.csd.datastructure.linkedList;

public class SLinkedList implements ILinkedList{
	int size;
	Node head;
	public SLinkedList() {
		this.size=0;
		this.head=null;
	}
	
	public class Node<Object>{
		Object value;
		Node next;
		private Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		private Object getValue() {
			return value;
		}
		private void setValue(Object value) {
			this.value = value;
		}
		private Node getNext() {
			return next;
		}
		private void setNext(Node next) {
			this.next = next;
		}
		
		
	}

	@Override
	public void add(int index, Object element) {
		Node current=head;
		if(head==null && index==0) {
			head=new Node<Object>(element,null);size++;return;
		}else if(head==null && index>0) {
			System.out.println("Error!");return;}
		if(index>=size) {System.out.println("Error!");return;}
		int i=0;
		while(i!=index-1) {current=current.next;i++;}
		Node node=new Node<Object>(element,current.next);
		current.setNext(node);size++;
		return;
	}

	@Override
	public void add(Object element) {
		if(head==null) {
			head=new Node<Object>(element,null);
			size++;return;
		}
		Node current=head;
		while(current.next!=null) {current=current.next;}
		current.next=new Node<Object>(element,null);
		size++;return;
	}

	@Override
	public Object get(int index) {
		if(head==null) {return "Error! as list is empty";}
		else if(index>=size || index<0) {return "Error!";}
		int i=0;
		Node current=head;
		while(i!=index) {current=current.next;i++;}
		return current.value;
	}

	@Override
	public void set(int index, Object element) {
		Node current=head;
		if(size==0 || index<0 || index>=size) {
			System.out.println("Error!"); return;
		}
		int i=0;
		while(i!=index) {current=current.next;i++;}
		current.setValue(element);
		return;
		
	}

	@Override
	public void clear() {
		head=null;
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public void remove(int index) {
		Node current=head;
		if(size==0 || index<0 || index>=size) {
			System.out.println("Error!"); return;
		}
		else if(index==0 && size==1) {
			head=null;
			size=0;
			return;
		}
		else if(index==0 && size>1) {
			current=head;
			head=current.next;
			current.setNext(null);
			size--;return;
		}
		current=head;
		int i=0;
		while(i!=index-1) {current=current.next;i++;}
		Node delete=current.next;
		current.setNext(delete.next);
		delete.setNext(null);size--;
		return;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		Node current=head;
		int i=0;
		while(i!=fromIndex) {current=current.next;i++;}
		head=current;
		while(i!=toIndex) {current=current.next;i++;}
		current.setNext(null);
		size=toIndex-fromIndex+1;
		return SLinkedList.this;
	}

	@Override
	public boolean contains(Object o) {
		Node current=head;
		for (int i = 0; i < size; i++) {
			if(current.value==o) {return true;}
			current=current.next;
		}
		return false;
	}

}
