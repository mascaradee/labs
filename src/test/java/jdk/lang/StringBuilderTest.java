package jdk.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringBuilderTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StringBuilderTest.class);


//	@Test
	public void testCreateStringBuilter() {
		StringBuilder sb = new StringBuilder();
		logger.debug("{}", sb.length()); // 0
		logger.debug("{}", sb.capacity()); // 16 - 초기 capacity
		sb.append("abcdefghi");
		logger.debug("{}", sb.length()); // 9
		logger.debug("{}", sb.capacity()); //16 - 길이가 16이 넘지 않아서 길이가 추가되지 않음 
		sb.append("abcdefghijklmnopqrstuvwxyz");
		logger.debug("{}", sb.length()); // 35
		logger.debug("{}", sb.capacity()); // 35 - 길이와 같은 크기로 추가됨
		sb.append("a");
		logger.debug("{}", sb.length()); // 36
		logger.debug("{}", sb.capacity()); // 72 - 길이보다 큰 크기로 추가됨
	
		StringBuilder sb1 = new StringBuilder("안녕하세요");
		logger.debug("{}", sb1.length()); // 5
		logger.debug("{}", sb1.capacity()); // 21
		
		StringBuilder sb2 = new StringBuilder(1);
		logger.debug("{}", sb2.length()); // 0
		logger.debug("{}", sb2.capacity()); // 1 - 기본 16이 아닌 인수로 넘어온 값으로 capacity 크기 결정
	}
	
//	@Test
	public void testSetLengh() {
		StringBuilder sb = new StringBuilder("안녕");
		sb.setLength(3);
		logger.debug("{}", sb); // 문자열의 길이보다 큰 길이로 세팅하여 모두 출력
		sb.setLength(1);
		logger.debug("{}", sb); // 문자열의 길이보다 작은 길이로 세팅하여 문자열의 길이가 그 만큼 잘림
	}
//	@Test
	public void testEnsureCapacity() {
		StringBuilder sb = new StringBuilder();
		sb.ensureCapacity(16);
		logger.debug("{}", sb.capacity()); // 16 - 기본과 동일한 크기
		sb.ensureCapacity(18);
		logger.debug("{}", sb.capacity()); // 34 - 기본보다 큰 최소크기가 인수로 들어와서 capacity가 커진것을 알수 있다. 
	}
	
//	@Test
	public void testAddString() {
		StringBuilder sb = new StringBuilder("안녕");
		sb.append("시오");
		sb.append("!");
		sb.append(321);
		Assert.assertEquals("안녕시오!321", sb.toString());
		
		sb.insert(2, "하");
		Assert.assertEquals("안녕하시오!321", sb.toString());
	}
	
//	@Test
	public void testDeleteString() {
		StringBuilder sb = new StringBuilder("안녕하시오");
		sb.delete(3, 4); // 시작인덱스 부터 종료인덱스 -1까지 삭제
		Assert.assertEquals("안녕하오", sb.toString());
		
		sb.deleteCharAt(2); // 해당 인덱스만 삭제
		Assert.assertEquals("안녕오", sb.toString());
	}

//	@Test
	public void testReplaceString() {
		
		StringBuilder sb = new StringBuilder("안녕하시오");
		sb.replace(3, 5, "세요"); // 시작인덱스 부터 종료인덱스 -1까지 대체
		Assert.assertEquals("안녕하세요", sb.toString());
		
		sb.setCharAt(2, '*'); // 해당 인덱스만 대체
		Assert.assertEquals("안녕*세요", sb.toString());
	}
	
	@Test
	public void testReverseString() {
		
		StringBuilder sb = new StringBuilder("다 간다~ 이 일요일이 다 간다~");
		sb.reverse();
		Assert.assertEquals("~다간 다 이일요일 이 ~다간 다", sb.toString());
	}
	
	int test;
	@Test
	public void testInt(){
		int test1;		
		System.out.println(test); // 0
//		System.out.println(test1); // The local variable test1 may not have been initialized
	}

}
