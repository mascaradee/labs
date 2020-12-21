package jdk.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerTest {
	private static final Logger logger = LoggerFactory.getLogger(IntegerTest.class);

	// rule no.1
	//	XXXTest : 클래스명명 규칙
	
	// rule no.2
	//	testXXX : 메소드명명 규칙
	
	int num1;
	@Test
	public void testDeclaration(){
//		int num2; // 메서드 로컬 변수인 경우 초기화 필수. 안 그럼  compile error
		int num2 = 0; 
		Assert.assertEquals(num2, 0);
	}	
	
}
