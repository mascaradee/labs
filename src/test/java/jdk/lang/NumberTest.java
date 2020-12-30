package jdk.lang;

import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(NumberTest.class);

//	@Test
	public void testObjcetNumberToPrimitiveType() {

		Integer i = new Integer(10);
		
		byte b = i.byteValue();
		short s = i.shortValue();
		int ii = i.intValue();
		long l = i.longValue();
		float f = i.floatValue();
		double d = i.doubleValue();
		
		int a = i.compareTo(new Integer (11));
		logger.debug("{}", a); // -1 :음수이면  좌변이 작은거
		
		
		logger.debug("{}", i.equals(10)); // false
		
	}
//	@Test 
	public void testConversion() {
		
		String s = new String("123");
		int convInt = Integer.parseInt(s);
		logger.debug("int: {}", convInt); // 123
		String ss = Integer.toString(convInt);
		logger.debug("String: {}", ss); // 123
		Integer bigInt = Integer.valueOf(convInt);
		logger.debug("Integer: {}", bigInt);
	}
	
	@Test
	public void testFormattingNumeric() {
		// 숫자타입을 포맷팅하기 위해서 `%converter`를 사용한다. 
		// `8%d' =  8자리 정수 
				
		  long n = 461012;
	      System.out.format("%d%n", n);      //  -->  "461012"
	      System.out.printf("%d%n", n);      //  -->  "461012"
	      
	      System.out.format("%08d%n", n);    //  -->  "00461012"
	      System.out.format("%+8d%n", n);    //  -->  " +461012"
	      System.out.format("%,8d%n", n);    // -->  " 461,012"
	      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
	      
	      double pi = Math.PI;

	      System.out.format("%f%n", pi);       // -->  "3.141593"
	      System.out.format("%.3f%n", pi);     // -->  "3.142"
	      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
	      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
	      
	      //로케일에 따라 소수점을 콤마로 표현하기도 한다. 
	      System.out.format(Locale.FRANCE,"%-10.4f%n%n", pi); // -->  "3,1416"

	      Calendar c = Calendar.getInstance();
	      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
	      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
	      System.out.format("%tD%n", c);    // -->  "05/29/06"
	}
}

