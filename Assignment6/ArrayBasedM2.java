package eg.edu.alexu.csd.datastructure.queue.cs52;

public class ArrayBasedM2 implements IQueue {
	Object[] s;
	int f;
	int r;
	public ArrayBasedM2(int n) {
		this.s = new Object[n+1];
		this.f = 0;
		this.r = 0;
	}

	/*public static void main(String[] args) {
		ArrayBasedM2 l=new ArrayBasedM2(5);
		l.enqueue(1);l.enqueue(2);l.enqueue(3);l.enqueue(4);l.enqueue(5);l.dequeue();l.enqueue(5);l.enqueue(8);
		System.out.println(l.size());
	}*/
	@Override
	public void enqueue(Object item) {
		if(f==(r+1)%s.length) {
			System.out.println("error! overflow");
			return;
		}
		s[r]=item;
		r=(r+1)%s.length;
		return;
	}

	@Override
	public Object dequeue() {
		if(f==r) {
			System.out.println("error! underflow");
			return null;
		}
		Object save =s[f];
		s[f]=null;
		f=(f+1)%s.length;
		return save;
	}

	@Override
	public boolean isEmpty() {
		return (f==r);
	}

	@Override
	public int size() {
		return ((s.length-f+r)%s.length);
	}
}
