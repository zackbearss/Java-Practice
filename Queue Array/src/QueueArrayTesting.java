import static org.junit.Assert.*;

import org.junit.Test;

public class QueueArrayTesting {

	@Test
	public void testEnqueue() {
		QueueArray<Integer> qa = new QueueArray<>(5);
		assertEquals(true, qa.empty());
		qa.enqueue(10);
		assertEquals(false, qa.empty());
		qa.enqueue(10);
		qa.enqueue(1);
		qa.enqueue(0);
		qa.enqueue(5);
		assertEquals(true, qa.full());
	}

	@Test
	public void testDequeue() {
		QueueArray<Integer> qa = new QueueArray<>(5);
		assertEquals(true, qa.empty());
		qa.enqueue(10);
		qa.enqueue(10);
		qa.enqueue(1);
		qa.enqueue(0);
		qa.enqueue(5);
		assertEquals(true, qa.full());
		assertEquals(10, (int)qa.dequeue());
		assertEquals(10, (int)qa.dequeue());
		assertEquals(1, (int)qa.dequeue());
		assertEquals(0, (int)qa.dequeue());
		assertEquals(5, (int)qa.dequeue());
		assertEquals(false, qa.full());
		assertEquals(true, qa.empty());
	}

	@Test
	public void testEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testFull() {
		fail("Not yet implemented");
	}

}
