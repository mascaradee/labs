package jdk.lang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoxingTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(BoxingTest.class);

//	@Test
	public void testBoxing() {
		Integer i1 = 10;
		Integer i2 = Integer.valueOf(10);		
		Assert.assertEquals(i1, i2);
		Assert.assertTrue(i1 instanceof Integer);
		Assert.assertTrue(i2 instanceof Integer);
	}
	
	@Test
	public void testUnboxing() {
		
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i < 50; i += 2) {
			li.add(Integer.valueOf(i));
		}
		
	    int sum = 0;
	    for (Integer i: li) {
	    	if (i % 2 == 0) { // Integer 객체타입에 %, += 같은 연산자는 사용할 없지만 컴파일러가 자동으로 언박싱을 한다.  
	    		sum += i;
	    	}
	    }
	    logger.debug("{}", sum);
	    
	    /* 실제로 위 코드는 아래와 같이 i.intValue()로 언박싱이 일어나 컴파일 에러가 발생하지 않는다. 
	    for (Integer i: li) {
	    	if (i.intValue() % 2 == 0) {  
	    		sum += i.intValue();
	    	}
	    }
	    logger.debug("{}", sum);
	    */
	}
	
	@Test
	public void testUnboxing2() {
		
		Integer i = new Integer(-8);
		
		// 1. Unboxing through method invocation
		int absVal = absoluteValue(i);
		System.out.println("absolute value of " + i + " = " + absVal);
		
		List<Double> ld = new ArrayList<>();
		ld.add(3.1416);    // Π is autoboxed through method invocation.
		
		// 2. Unboxing through assignment
		double pi = ld.get(0);
		System.out.println("pi = " + pi);
	}
	public static int absoluteValue(int i) {
	        return (i < 0) ? -i : i;
    }
	
}
