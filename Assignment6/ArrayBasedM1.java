package eg.edu.alexu.csd.datastructure.queue.cs52;

public class ArrayBasedM1 implements IQueue {
	Object[] s;
	
	int f;
	int r;
	int count;
	public ArrayBasedM1(int n) {
		this.s = new Object[n];
		this.f = 0;
		this.r = 0;
		this.count=0;
	}

	@Override
	public void enqueue(Object item) {
		if(count==s.length) {
			System.out.println("error! overflow");
			return;
		}
		s[r]=item;r++;
		if(r==s.length) {r=0;}
		count++;
		return;
	}

	@Override
	public Object dequeue() {
		if(count==0) {
			System.out.println("error! underflow");
			return null;
		}
		Object save=s[f];
		s[f]=null;f++;
		if(f==s.length) {f=0;}
		count--;
		return save;
	}

	@Override
	public boolean isEmpty() {
		return (count==0);
	}

	@Override
	public int size() {
		return count;
	}
}
