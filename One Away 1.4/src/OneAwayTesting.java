import static org.junit.Assert.*;

import org.junit.Test;

public class OneAwayTesting {

	@Test
	public void testIsOneAway() {
		StringHelper sh = new StringHelper();
		assertEquals(true, sh.IsOneAway("pale", "ple"));
		assertEquals(true, sh.IsOneAway("pales", "pale"));
		assertEquals(true, sh.IsOneAway("pale", "bale"));
		assertEquals(false, sh.IsOneAway("pale", "bake"));
	}

}
