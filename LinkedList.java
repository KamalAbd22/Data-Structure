
public class LinkedList {

	Node head;
	
	public LinkedList() {
		head=null;
	}
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		//l.head=insertionSort(l.head);
		//l.head=reverse(l.head);
		/*double[] results=new double[5];
		results=summary(l.head);
		System.out.println(results[0]);
		System.out.println(results[1]);
		System.out.println(results[2]);
		System.out.println(results[3]);
		System.out.println(results[4]);*/
		//l.head=evenIndexedElements(l.head);
		//l.head=removeCentralNode(l.head);
		boolean b;
		b=palindrome(l.head);
		System.out.println(b);
		//l.display(l);
	}
	
	public void append(int value) {
		if(head==null) {
			head=new Node(value,null);
			return;
		}
		
		Node current=head;
		while(current.next!=null) {
			current=current.next;
		}
		current.next=new Node(value,null);
	}

	public  void display(LinkedList l) {

		Node current=head;
		while(true) {
			System.out.println(current.value);
			current=current.next;
			if(current.next==null) {
				System.out.println(current.value);
				break;
			}
		}
	}
	
	public static Node reverse(Node head) {
		Node holdc=null;
		Node holdp=null;
		Node current =head;
		while(true) {
			if(current==head) {
				holdc=current;
				current =current.next;
				holdc.setNext(null);
				holdp=holdc;
				continue;
			}
			holdc=current;
			if(current.next==null) {
				current.setNext(holdp);
				return current;
			}
			current =current.next;
			holdc.setNext(holdp);
			holdp=holdc;
			
		}

		
	}

	public static double[] summary(Node head) {
		double[] results=new double[5];
		Node current=head;
		double sum=0;int counter=0;
		while(current!=null) {
			sum+=current.value;
			current=current.next;
			counter++;
		}
		results[0]=sum;
		results[1]=sum/counter;
		
		double[] arr=new double[counter];int i=0;int j=0;
		current =head;
		while(current!=null) {
			arr[i]=current.value;i++;
			current=current.next;
		}
		i=0;double k=0.0;
		while(j==0) {
			j=5;
			for (i = 0; i < arr.length-1; i++) {
				if(arr[i]>arr[i+1]) {
					k=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=k;
					j=0;
				}
			}
		}
		if(counter%2!=0) {
			results[2]=arr[(counter/2)];
		}else {
			results[2]=(arr[counter/2]+arr[(counter/2)-1])/2;
		}
		results[3]=arr[counter-1];
		results[4]=arr[0];
		return results;
	}

	public static Node insertionSort(Node head) {
		Node current =head;int i=0;
		while(current!=null) {
			i++;current=current.next;
		}
		int arr[]=new int[i];
		current=head;i=0;
		while(current!=null) {
			arr[i]=current.value;i++;
			current=current.next;
		}
		int j=0;
		for (i = 1; i < arr.length; i++) {
			int key=arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		i=0;current=head;
		while(current!=null) {
			current.setValue(arr[i]);
			i++;
			current=current.next;
		}
		return head;
	}

	public static Node evenIndexedElements(Node head) {
		Node current =head;
		while(current!=null) {
			if(current.next==null) {
				return head;
			}
			current.setNext(current.next.next);
			current=current.next;
		}
		return head;
	}

	public static Node removeCentralNode(Node head) {
		Node current=head;
		int n=0;
		while(current!=null) {
			n++;
			current=current.next;
		}
		int i=0;
		current=head;
		while(true) {
			if(n%2==1) {
				if(i==n/2-1) {
					current.setNext(current.next.next);
					return head;
				}
			}else {
				if(i==n/2-2) {
					current.setNext(current.next.next);
					return head;
				}
			}
			i++;
			current=current.next;
		}
	}

	public static boolean palindrome(Node head) {
		Node current=head;
		int n=0;
		while(current!=null) {
			n++;
			current=current.next;
		}
		int[] arr=new int[n];
		int i=0;
		current=head;
		while(current!=null) {
			arr[i]=current.value;
			i++;
			current=current.next;
		}
		for (int j= 0;  j<n/2; j++) {
			if(arr[j]!=arr[n-j-1]) {
				return false;
			}
		}
		return true;
	}
}
		

