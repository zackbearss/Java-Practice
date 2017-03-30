import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTester {

//	@Test
//	public void testInsert() {
//		BinarySearchTree bst = new BinarySearchTree();
//		
//	}
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testPrintValues() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		bst.PrintValues();
		//assertEquals("3\n5\n6\n10\n15\n17\n20\n\r", outContent.toString());
	}

	@Test
	public void testDeleteTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		bst.DeleteTree();
		assertEquals("", outContent.toString());
	}

	@Test
	public void testIsInTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		assertEquals(true, bst.IsInTree(15));
		assertEquals(true, bst.IsInTree(3));
		assertEquals(true, bst.IsInTree(10));
		assertEquals(false, bst.IsInTree(11));
	}

	@Test
	public void testFindHeight() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		assertEquals(4, bst.FindHeight());
		bst.insert(18);
		assertEquals(5, bst.FindHeight());
	}

	@Test
	public void testGetMin() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		assertEquals(3, bst.GetMin());
		bst.insert(1);
		assertEquals(1, bst.GetMin());
	}

	@Test
	public void testGetMax() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(20);
		bst.insert(15);
		bst.insert(17);
		assertEquals(20, bst.GetMax());
		bst.insert(30);
		assertEquals(30, bst.GetMax());
	}

}
