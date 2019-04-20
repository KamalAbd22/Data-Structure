package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLinkedListTest {
	DLinkedList list;
	@Before
	public void setUp() throws Exception {
		list=new DLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}

	@Test
	public void test1() {
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
	}
	
	@Test
	public void test2() {
		list.add(2, 6);
		assertEquals(6, list.get(2));
	}
	
	@Test
	public void test3() {
		list.set(0, 10);
		assertEquals(10, list.get(0));
	}
	
	@Test
	public void test4() {
		list.sublist(1, 3);
		assertEquals(3, list.size);
	}
	
	@Test
	public void test5() {
		list.remove(4);
		assertEquals(4, list.size);
	}
	
	@Test
	public void test6() {
		assertEquals(true, list.contains(3));
		assertEquals(false, list.contains(77));
	}
	
	@Test
	public void test7() {
		list.clear();
		assertEquals(true, list.isEmpty());
	}

}
