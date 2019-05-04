package eg.edu.alexu.csd.datastructure.queue.cs52;

public interface IQueue {
	public void enqueue(Object item);
	public Object dequeue();
	public boolean isEmpty();
	public int size();
}