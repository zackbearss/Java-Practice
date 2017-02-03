import static org.junit.Assert.*;

import org.junit.Test;

public class SListTesting {

	@Test
	public void testSize() {
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(3, ll.size());
		ll.pop_back();
		assertEquals(2, ll.size());
		ll.push_front(3);
		ll.push_front(5);
		assertEquals(4, ll.size());
		ll.insert(2, 99);
		assertEquals(5, ll.size());
		ll.erase(4);
		assertEquals(4, ll.size());
		ll.pop_front();
		assertEquals(3, ll.size());
		ll.remove_value(99);
		assertEquals(2, ll.size());
	}
	
	@Test
	public void testEmpty() {
		SList<Integer> ll = new SList<Integer>();
		assertEquals(true, ll.empty());
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(false, ll.empty());
		ll.pop_back();
		ll.pop_back();
		ll.pop_back();
		assertEquals(true, ll.empty());
	}
	
	@Test
	public void testValue_at() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPush_front() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPop_front() {
		fail("Not yet implemented");
	}
		
	@Test
	public void testPush_back() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPop_back() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFront() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBack() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testErase() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testValue_n_from_end() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemove_value() {
		fail("Not yet implemented");
	}

}
