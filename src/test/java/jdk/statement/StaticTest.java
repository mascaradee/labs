package jdk.statement;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StaticTest.class);

	@Test
	public void testInitializingBlocks() {
		logger.debug("{}", Imstatic.text);
		Imstatic i = new Imstatic();
		Assert.assertTrue("a10".equals(i.str));
		Assert.assertEquals("a10", i.str);
	}
}

class Imstatic {
	public static final String text;
	static {
		String aa = Thread.currentThread().toString();
		System.out.println(aa);
		// aa를 가공
		text = aa;
	}

	public final String str;
	{
		str = "a" + Integer.valueOf(10).toString();
	}
}