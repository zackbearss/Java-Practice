package dynamicarray;

import static org.junit.Assert.*;

import java.io.Console;

import org.junit.Test;

public class DynamicArrayTesting {


	@Test
	public void testGetSizeEasy() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 6; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		assertEquals(test.getSize(),6);
	}

	@Test
	public void testGetSizeHard() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 48; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		assertEquals(test.getSize(),48);
	}

	
	@Test
	public void testGetCapacityEasy() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 6; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		assertEquals(test.getCapacity(),16);
	}
	
	@Test
	public void testGetCapacityHard() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 48; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		assertEquals(test.getCapacity(),64);
	}
	
	@Test
	public void testGetCapacityPop() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 48; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		for(int i = 47; i >= 12; i--){
			test.pop();
		}
		System.out.println(test.getCapacity());
		assertEquals(test.getCapacity(),32);
	}

	@Test
	public void testIs_empty() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		test.push(true);
		assertEquals(test.is_empty(),false);
		test.pop();
		assertEquals(test.is_empty(),true);
	}

	@Test
	public void testAt() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean testBool = false;
		for(int i = 0; i < 6; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		assertEquals(test.at(3),true);
	}

	@Test
	public void testPush() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		test.push(true);
		assertEquals(test.at(0), true);
	}

	@Test
	public void testInsert() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean[] testArray = new boolean[] {false, true, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true};
		//test basic case
		boolean testBool = false;
		for(int i = 0; i < 6; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		test.insert(2, true);
		for(int i = 0; i < 7; i++){
			assertEquals(testArray[i], test.at(i));
		}
		//test advanced case, where array has to grow
		for(int i = 7; i < 16; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		test.insert(16, true);
		for(int i = 0; i < 17; i++){
			assertEquals(testArray[i], test.at(i));
		}
		assertEquals(32, test.getCapacity());
		//test index out of range case
		test.insert(60, false);
		for(int i = 0; i < 17; i++){
			assertEquals(testArray[i], test.at(i));
		}
		assertEquals(17, test.getSize());
		assertEquals(32, test.getCapacity());
	}

	@Test
	public void testPrepend() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		boolean[] testArray = new boolean[] {true, false, true, false, true, false, true};
		//test basic case
		boolean testBool = false;
		for(int i = 0; i < 6; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		test.prepend(true);
		for(int i = 0; i < 7; i++){
			assertEquals(testArray[i], test.at(i));
		}
		//test advanced case, where array has to grow
		testArray = new boolean[] {true, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
		for(int i = 7; i < 16; i++){
			test.push(testBool);
			testBool = !testBool;
		}
		test.prepend(true);
		for(int i = 0; i < 17; i++){
			assertEquals(testArray[i], test.at(i));
		}
		assertEquals(32, test.getCapacity());
	}

	@Test
	public void testPop() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		test.push(true);
		assertEquals(test.pop(), true);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		DynamicArray<Boolean> test = new DynamicArray<Boolean>();
		//test basic case
		for(int i = 0; i < 6; i++){
			test.push(false);
		}
		test.push(true);
		assertEquals(6, test.find(true));
		//test failure
		test.pop();
		assertEquals(-1, test.find(true));
		
	}
}
