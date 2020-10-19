package jdk.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTest {
	private static final Logger logger = LoggerFactory.getLogger(StringTest.class);

	// rule no.1
	//	XXXTest : 클래스명명 규칙
	
	// rule no.2
	//	testXXX : 메소드명명 규칙

	@Test
	public void testIndexOF(){
		String a = "12345"; 
		Assert.assertEquals(2, a.indexOf("3"));
	}
	
}
