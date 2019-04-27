package eg.edu.alexu.csd.datastructure.stack.cs52;

import java.util.Scanner;
/**
 * this class to implement the interface IStack
 * 
 * @author Kamal Rashid
 *
 */
public class Stack implements IStack {
	/**
	 * this class represent the element in Stack
	 * 
	 * @author Kamal
	 *
	 * @param <Object> the element to insert
	 */
	public class Node<Object>{
		Object value;
		Node next;
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

	Node head;
	int size;
	public Stack() {
		this.head = null;
		this.size = 0;
	}

	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Stack stack=new Stack();
		while(true) {
			System.out.println("====================================");
			System.out.println("choose an action:");
			System.out.println("1:push");
			System.out.println("2:pop");
			System.out.println("3:peek");
			System.out.println("4:get size");
			System.out.println("5:check if empty");
			System.out.println("====================================");
			int x=scan.nextInt();
			switch (x) {
			case 1:{
				System.out.println("enter an Object");
				scan.nextLine();
				stack.push(scan.nextLine());
				break;}

			case 2:{
				System.out.println(stack.pop());
				break;
			}
			case 3:{
				System.out.println(stack.peek());
				break;
			}
			case 4:{
				System.out.println(stack.size);
				break;
			}
			case 5:{
				System.out.println(stack.isEmpty());
				break;
			}
			default:
				System.out.println("error!");
				break;
			}
		}
	}
	
	@Override
	public Object pop() {
		if(head==null) {
			System.out.println("Error! under flow");return null;
		}
		Node save=head;
		head=head.next;
		save.setNext(null);
		size--;
		return save.value;
	}

	@Override
	public Object peek() {
		if(size==0) {
			System.out.println("error! under flow");return null;
		}
		return head.value;
	}

	@Override
	public void push(Object element) {
		Node save=head;
		head=new Node<Object>(element, save);
		size++;
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
