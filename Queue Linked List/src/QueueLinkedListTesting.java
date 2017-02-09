import static org.junit.Assert.*;

import org.junit.Test;

public class QueueLinkedListTesting {

	@Test
	public void enqueueTest() {
		QueueLinkedList<Integer> qll = new QueueLinkedList<>();
		assertEquals(true, qll.empty());
		qll.enqueue(10);
		assertEquals(false, qll.empty());
		qll.enqueue(12);
		assertEquals(false, qll.empty());
	}
	
	@Test
	public void dequeueTest() {
		QueueLinkedList<Integer> qll = new QueueLinkedList<>();
		qll.enqueue(10);
		qll.enqueue(12);
		assertEquals(10, (int)qll.dequeue());
		assertEquals(12, (int)qll.dequeue());
	}
	
	@Test
	public void emptyTest() {
		QueueLinkedList<Integer> qll = new QueueLinkedList<>();
		assertEquals(true, qll.empty());
		qll.enqueue(10);
		assertEquals(false, qll.empty());
		qll.enqueue(12);
		assertEquals(false, qll.empty());
		qll.dequeue();
		assertEquals(false, qll.empty());
		qll.dequeue();
		assertEquals(true, qll.empty());
	}

}
