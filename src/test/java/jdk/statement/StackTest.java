package jdk.statement;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StackTest.class);

//	@Test
	public void testStackEmpty() {
		Stack<Integer> s = new Stack<Integer>();
		Assert.assertEquals(true, s.empty());
	}
	

	@Test
	public void testStackPush() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		int r = s.push(3);
		logger.debug("{}", r); // 스택에 들어가 항목을 반환해 준다. 
		logger.debug("{}", s); // [1, 2, 3]
		
	}
	
//	@Test
	public void testStackPeek() {
		Stack<Integer> s = new Stack<Integer>();
		//int r1 = s.peek(); 
		//logger.debug("{}", r1); // java.util.EmptyStackException
		
		s.push(1);
		s.push(2);
		s.push(3);
		int r2 = s.peek(); 
		Assert.assertEquals(3, r2); // 마지막에 들어간 3이 가장 먼저 리턴 되었다. 스택에서 제거되는 것은 아니다.
	}
	
//	@Test
	public void testStackPop() {
		Stack<Integer> s = new Stack<Integer>();
		//int r1 = s.pop();
		//logger.debug("{}", s);  // java.util.EmptyStackException
		
		s.push(1);
		s.push(2);
		s.push(3);
		
		int r2 = s.pop();
		Assert.assertEquals(3, r2); // 마지막에 들어간 3이 제거되고 그 값이 리턴된다. 
		logger.debug("{}", s); // [1, 2]
	}
	
//	@Test
	public void testStackSearch() {
		Stack<String> s = new Stack<String>();
		int r1 = s.search("이");
		Assert.assertEquals(-1, r1); // 원하는 결과가 없으면 -1을 리턴한다. 
		
		s.push("일");
		s.push("이");
		s.push("삼");
		
		int r2 = s.search("이");
		Assert.assertEquals(2, r2); // 원하는 객체의 위치를 반환한다. 이때 위치는 인덱스가 아닌 1부터 시작하는 위치이다. 	
		
	}
}
