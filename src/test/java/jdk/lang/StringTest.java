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

//	@Test
	public void testIndexOF(){
		String a = "12345"; 
		Assert.assertEquals(2, a.indexOf("3"));
	}
	
//	@Test
	public void testCreationString(){
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
		String helloString = new String(helloArray);
		logger.debug("{}", helloString);
	}

//	@Test
	public void testStringLength(){
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
		String helloString = new String(helloArray);
		
		// length()
		int len = helloString.length();
		logger.debug("{}", len);
	}
//	@Test
	public void testStringGetChars(){
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
		String helloString = new String(helloArray);
		
		int len = helloString.length();
		char[] helloArray1 = new char[len];
		
		// getChars()
		helloString.getChars(0, len, helloArray1, 0); // char로 반환하는 메서드
		logger.debug("{}", helloArray1); // [h, e, l, l, o, .]
	}

//	@Test
	public void testStringConcatenating(){
		String s1 = new String("abc");
		String s2 = new String("def");
		
		// concat()
		String newString = s1.concat(s2);
		logger.debug("{}", newString);
		logger.debug("{}", s1);
		logger.debug("{}", s2);
		
		// 문자열 + 리터럴
		String newString1 = newString.concat("나는 한글");
		logger.debug("{}", newString1);
		
		// '+'
		String newString2 = "I am" + " Ironman.";
		logger.debug("{}", newString2);
	}
	
//	@Test
	public void testStringToNumber() {
		Float bf = Float.valueOf("4.5"); // 래퍼 클래스 타입
		float sf = bf.floatValue(); // 원시 숫자 타입
		
		Integer bi = Integer.valueOf("82");
		int si = bi.intValue();        
	}
	
//	@Test
	public void testNumberToString() {
		// "" 붙여서 String 타입으로 변경 
		int i = 90;
		String s1 = "" + i;
		Assert.assertEquals(true, s1 instanceof String);
		
		// 래퍼 클래스.toString()
		String s2 = Integer.toString(i);
		Assert.assertEquals(true, s2 instanceof String);
	}
	
	
//	@Test
	public void testSubstring() {
		String s = "영일이삼사오육칠팔구십";
		String r1 = s.substring(3);
		String r2 = s.substring(6, 8); // endIndex는 불포함
		Assert.assertEquals("삼사오육칠팔구십", s.substring(3));
		Assert.assertEquals("육칠", s.substring(6, 8));
	}
	
//	@Test
	public void testSplit() {
		String s = "영|일|이삼";
		String[] r1 = s.split("|");
		String[] r2 = s.split("|", 2); // 2번째 인수는 배열의 크기, 2개로 쪼개라
		
		for (String a : r1) {
			logger.debug("{}", a);
			/*
			  영
			 |
			  일
		 	 |
			  이
		           삼
			 */
		}
		for (String a : r2) {
			logger.debug("{}", a);
			/*
			 영
			 |일|이삼 
			 */
		}
	}
	
//	@Test
	public void testSubSequence() {
		String s = "영|일|이삼";
		CharSequence r1 = s.subSequence(0, 4); // substring이랑 다를바 없지만 반환 타입이 다르다. 참고로  CharSequence는 인터페이스로 String은 이것을 구현한 클래스이다.  
		logger.debug("{}", r1);
	}
	
//	@Test
	public void testTrim() {
		String s = " 영일 이삼사 오 육     칠   팔  구 십   ";
		String r1 = s.trim();
		Assert.assertEquals("영일 이삼사 오 육     칠   팔  구 십", r1);
	}
	
//	@Test
	public void testChangeCase() {
		String s = "Hello world1!!";
		String r1 = s.toUpperCase();
		String r2 = s.toLowerCase();
		Assert.assertEquals("HELLO WORLD1!!", r1);
		Assert.assertEquals("hello world1!!", r2);
	}
	
//	@Test
	public void testSerchCharacters() {
		String s = "Hello!@ world@!!";
		
		int r1 = s.indexOf("!");
		Assert.assertEquals(5, r1);
		
		int r2 = s.indexOf("!", 6);
		Assert.assertEquals(14, r2);
		
		int r3 = s.indexOf(72);
		Assert.assertEquals(0, r3);
		
		int r4 = s.lastIndexOf("@");
		Assert.assertEquals(13, r4);
		
		int r5 = s.lastIndexOf("o", 8);
		Assert.assertEquals(4, r5);

		int r6 = s.lastIndexOf("$");	
		Assert.assertEquals(-1, r6);
	}
	
//	@Test
	public void testContains() {
		String s = "Hello, hi!";
		boolean r1 = s.contains("lo");
		Assert.assertTrue(r1);
		
		boolean r2 = s.contains("ro");
		Assert.assertFalse(r2);
	}
	
	@Test
	public void testReplaceString() {
		String s = "Hello, Hello, world.";
	
		String r1 = s.replace('.', '!');
		Assert.assertEquals("Hello, Hello, world!", r1);
		
		String r2 = s.replace("hello", "hi");
		Assert.assertNotEquals("hi, world.", r2); // 대소문자를 가림
		
		String r3 = s.replace("Hello", "hi");
		Assert.assertEquals("hi, hi, world.", r3);

		String r4 = s.replaceAll(" ", "-");
		Assert.assertEquals("Hello,-Hello,-world.", r4);
		
		String r5 = s.replaceAll("[l]", "*"); // l문자 를 *로 바꾼다. 
		Assert.assertEquals("He**o, He**o, wor*d.", r5);
		
		String r6 = s.replaceFirst(" ", "-");
		Assert.assertEquals("Hello,-Hello, world.", r6);		
	}
}
