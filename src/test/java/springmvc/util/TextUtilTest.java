package springmvc.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextUtilTest {

	@Test
	public void test() {		
		assertEquals("꺼억", TextUtil.trim(1));
		assertEquals("꺼억꺼억", TextUtil.trim(2));
		assertEquals("꺼억꺼억꺼억", TextUtil.trim(3));
		assertEquals("꺼억꺼억꺼억꺼억", TextUtil.trim(4));
	}

}
