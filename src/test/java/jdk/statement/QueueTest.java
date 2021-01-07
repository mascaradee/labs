package jdk.statement;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(QueueTest.class);

	@Test
	public void testQueueAdd() {
		Queue<String> q = new LinkedList<>();
		logger.debug("{}", q); //[]
		q.add("일");
		q.add("이");
		q.offer("삼");
		logger.debug("{}", q);
	}
	
	@Test
	public void testQueueRemove() {
		Queue<String> q = new LinkedList<>();
		q.add("일");
		q.add("이");		
		
		String r1 = q.remove();
		logger.debug("{}", r1); // 일 -> 제거된 맨 앞의 요소가 리턴
		logger.debug("{}", q); // [이] -> 맨 앞의 요소인 일이 제거된 결과
		
		String r2 = q.poll();
		logger.debug("{}", r2); // 이
		logger.debug("{}", q); // []
		
		//q.remove(); // java.util.NoSuchElementException -> 요소 제거 실패 시 예외 발생 
		logger.debug("{}", q.poll()); // null -> 요소 제거 실패 시 null 리턴
	}
	
	@Test
	public void testQueueElement() {
		Queue<Integer> q = new LinkedList<>();
		q.add(100);
		q.add(200);
		
		int r1 = q.element();
		logger.debug("{}", r1); // 100 -> 맨 앞의 요소를 리턴
		int r2 = q.peek();
		logger.debug("{}", r2); // 100 -> 맨 앞의 요소를 리턴		
	}
}

