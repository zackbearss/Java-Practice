import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderTest {

	@Test
	public void IsUnique()
	{
		StringBuilder test = new StringBuilder("value");
		assertEquals(true, test.IsUnique());
		assertEquals(true, test.IsUnique2());
		test = new StringBuilder("zaack");
		assertEquals(false, test.IsUnique());
		assertEquals(false, test.IsUnique2());
		test = new StringBuilder("zAack");
		assertEquals(true, test.IsUnique());
		assertEquals(true, test.IsUnique2());
		test = new StringBuilder("ajdkla");
		assertEquals(false, test.IsUnique());
		assertEquals(false, test.IsUnique2());
	}
}
