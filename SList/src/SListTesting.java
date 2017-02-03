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
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(2));
		assertNull(ll.value_at(3));
		ll.pop_back();
		ll.pop_back();
		assertEquals(10, (int)ll.value_at(0));
		ll.pop_back();
		assertNull(ll.value_at(0));
	}
	
	@Test
	public void testPush_front() {
		SList<Integer> ll = new SList<Integer>();
		ll.push_front(10);
		ll.push_front(4);
		ll.push_front(6);
		assertEquals(10, (int)ll.value_at(2));
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(0));
	}
	
	@Test
	public void testPop_front() {
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(10, (int)ll.pop_front());
		assertEquals(4, (int)ll.pop_front());
		assertEquals(6, (int)ll.pop_front());
		assertNull(ll.pop_front());
	}
		
	@Test
	public void testPush_back() {
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(10, (int)ll.value_at(0));
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(2));
	}
	
	@Test
	public void testPop_back() {
		SList<Integer> ll = new SList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(6, (int)ll.pop_back());
		assertEquals(4, (int)ll.pop_back());
		assertEquals(10, (int)ll.pop_back());
		assertNull(ll.pop_back());
	}
	
	@Test
	public void testFront() {
		SList<Integer> ll = new SList<Integer>();
		assertNull(ll.front());
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(10, (int)ll.front());
	}
	
	@Test
	public void testBack() {
		SList<Integer> ll = new SList<Integer>();
		assertNull(ll.back());
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(6, (int)ll.back());
	}
	
	@Test
	public void testInsert() {
		SList<Integer> ll = new SList<Integer>();
		ll.insert(10, 5);
		ll.insert(0, 10);
		ll.push_back(4);
		ll.push_back(6);
		ll.insert(2, 99);
		assertEquals(10, (int)ll.value_at(0));
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(99, (int)ll.value_at(2));
		assertEquals(6, (int)ll.value_at(3));
	}
	
	@Test
	public void testErase() {
		SList<Integer> ll = new SList<Integer>();
		ll.erase(0);
		ll.insert(0, 10);
		ll.push_back(4);
		ll.push_back(6);
		ll.insert(2, 99);
		ll.erase(0);
		assertEquals(4, (int)ll.value_at(0));
		assertEquals(99, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(2));
		assertNull(ll.value_at(3));
		ll.erase(1);
		assertEquals(4, (int)ll.value_at(0));
		assertEquals(6, (int)ll.value_at(1));
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
