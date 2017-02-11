import static org.junit.Assert.*;

import org.junit.Test;

public class StringCompressionTesting {

	@Test
	public void testCompress() {
		StringHelper sh = new StringHelper();
		assertEquals("a4b2c4d1", sh.Compress("aaaabbccccd"));
		assertEquals("abcd", sh.Compress("abcd"));
	}

}
