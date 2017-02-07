import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderTest {

	@Test
	public void IsUnique()
	{
		StringBuilder test = new StringBuilder("value");
		assertEquals(true, test.IsPermutation("lavue"));
		assertEquals(false, test.IsPermutation("lavuet"));
		assertEquals(false, test.IsPermutation("lavuee"));
		assertEquals(false, test.IsPermutation("lavee"));
		assertEquals(false, test.IsPermutation("gavue"));
	}
}
