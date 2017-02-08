import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testPermutationIsAPalindrome() {
		StringHelper sh = new StringHelper();
		assertEquals(true, sh.PermutationIsAPalindrome("aco tcat"));
		assertEquals(false, sh.PermutationIsAPalindrome("aco tcatt"));
		assertEquals(true, sh.PermutationIsAPalindrome("howwoh"));
	}

}
