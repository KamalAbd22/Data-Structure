package eg.edu.alexu.csd.datastructure.linkedList;

public class DLinkedList implements ILinkedList{
	int size;
	DNode head;
	DNode tail;
	public class DNode<Object>{
		Object value;
		DNode next;
		DNode prev;
		public DNode(Object value, DNode next, DNode prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		private Object getValue() {
			return value;
		}
		private void setValue(Object value) {
			this.value = value;
		}
		private DNode getNext() {
			return next;
		}
		private void setNext(DNode next) {
			this.next = next;
		}
		private DNode getPrev() {
			return prev;
		}
		private void setPrev(DNode prev) {
			this.prev = prev;
		}
	}

	public DLinkedList() {
		size = 0;
		head = new DNode(null,null,null);
		tail = new DNode(null,null,head);
		head.setNext(tail);
	}

	@Override
	public void add(int index,Object element) {
		int i=-1;
		DNode current=head;
		while(i!=index) {current=current.next;i++;}
		DNode node =new DNode(element,current,current.prev);
		current.prev.setNext(node);
		current.setPrev(node);
		size++;return;
	}

	@Override
	public void add(Object element) {
		DNode current=head;
		while(current.next!=tail) {current=current.next;}
		DNode node =new DNode(element,tail,current);
		tail.setPrev(node);
		current.setNext(node);
		size++;return;
	}

	@Override
	public Object get(int index) {
		int i=-1;
		DNode current=head;
		while(i!=index) {current=current.next;i++;}
		return current.value;
	}

	@Override
	public void set(int index,Object element) {
		int i=-1;
		DNode current=head;
		while(i!=index) {current=current.next;i++;}
		current.setValue(element);
		return;
	}

	@Override
	public void clear() {
		size = 0;
		head = new DNode(null,null,null);
		tail = new DNode(null,null,head);
		head.setNext(tail);
		
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public void remove(int index) {
		int i=-1;
		DNode current=head;
		while(i!=index) {current=current.next;i++;}
		current.prev.setNext(current.next);
		current.next.setPrev(current.prev);
		current.setNext(null);current.setPrev(null);
		size--;return;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		int i=-1;
		DNode current=head;
		if(fromIndex!=0) {
			while(i!=fromIndex) {current=current.next;i++;}
			head.next.setPrev(null);current.prev.setNext(null);
			head.setNext(current);current.setPrev(head);
		}
		if(toIndex!=size-1) {
			while(i!=fromIndex) {current=current.next;i++;}
			tail.prev.setNext(null);current.next.setPrev(null);
			current.setNext(tail);tail.setPrev(current);
		}
		size=toIndex-fromIndex+1;
		return DLinkedList.this;
	}

	@Override
	public boolean contains(Object o) {
		DNode current=head.next;
		for (int i = 0; i < size; i++) {
			if(current.value==o) {return true;}
			current=current.next;
		}
		return false;
	}

}
