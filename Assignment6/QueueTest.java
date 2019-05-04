package eg.edu.alexu.csd.datastructure.queue.cs52;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	LinkedQueue l=new LinkedQueue();
	ArrayBasedM1 a1=new ArrayBasedM1(4);
	ArrayBasedM2 a2=new ArrayBasedM2(5);
	
	@BeforeEach
	void setUp() throws Exception {
		l.enqueue(0);l.enqueue(1);l.enqueue(2);
		a1.enqueue(1);a1.enqueue(2);a1.enqueue(3);
		a2.enqueue(4);a2.enqueue(5);a2.enqueue(6);a2.enqueue(7);a2.enqueue(8);
		
	}

	@Test
	void test1() {
		assertEquals(0,l.dequeue());
		assertEquals(1,l.dequeue());
		assertEquals(2,l.dequeue());
		assertEquals(null,l.dequeue());
	}
	@Test
	void test2() {
		assertEquals(3,l.size());
	}
	@Test
	void test3() {
		assertEquals(false ,l.isEmpty());
	}
	@Test
	void test4() {
		assertEquals(1,a1.dequeue());
		assertEquals(4,a2.dequeue());
	}
	@Test
	void test5() {
		assertEquals(3,a1.size());
		assertEquals(5,a2.size());
	}
	@Test
	void test6() {
		assertEquals(false , a1.isEmpty());
		assertEquals(false,a2.isEmpty());
	}

}
