import static org.junit.Assert.*;

import org.junit.Test;

public class DListTesting {

	@Test
	public void testSize() {
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
		ll.push_front(10);
		ll.push_front(4);
		ll.push_front(6);
		assertEquals(10, (int)ll.value_at(2));
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(0));
	}
	
	@Test
	public void testPop_front() {
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(10, (int)ll.value_at(0));
		assertEquals(4, (int)ll.value_at(1));
		assertEquals(6, (int)ll.value_at(2));
	}
	
	@Test
	public void testPop_back() {
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
		assertNull(ll.front());
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(10, (int)ll.front());
	}
	
	@Test
	public void testBack() {
		DList<Integer> ll = new DList<Integer>();
		assertNull(ll.back());
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		assertEquals(6, (int)ll.back());
	}
	
	@Test
	public void testInsert() {
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
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
		DList<Integer> ll = new DList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		ll.push_back(2);
		ll.push_back(56);
		ll.push_back(234);
		assertEquals(4, (int)ll.value_n_from_end(4));
		assertNull(ll.value_n_from_end(6));
	}
	
	@Test
	public void testReverse() {
		DList<Integer> ll = new DList<Integer>();
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(6);
		ll.push_back(2);
		ll.push_back(56);
		ll.push_back(234);
		ll.reverse();
		assertEquals(234, (int)ll.value_at(0));
		assertEquals(56, (int)ll.value_at(1));
		assertEquals(2, (int)ll.value_at(2));
		assertEquals(6, (int)ll.value_at(3));
		assertEquals(4, (int)ll.value_at(4));
		assertEquals(10, (int)ll.value_at(5));
	}
	
	@Test
	public void testRemove_value() {
		DList<Integer> ll = new DList<Integer>();
		ll.remove_value(10);
		ll.push_back(10);
		ll.push_back(4);
		ll.push_back(10);
		ll.push_back(2);
		ll.push_back(56);
		ll.push_back(234);
		ll.remove_value(10);
		assertEquals(4, (int)ll.value_at(0));
		assertEquals(10, (int)ll.value_at(1));
		assertEquals(2, (int)ll.value_at(2));
		assertEquals(56, (int)ll.value_at(3));
		assertEquals(234, (int)ll.value_at(4));
	}

}
