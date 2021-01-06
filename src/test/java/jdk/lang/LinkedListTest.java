package jdk.lang;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LinkedListTest.class);

//	@Test
	public void testLikedList() {
		LinkedList<Integer> lnList = new LinkedList<>();
		
		// 데이터 추가
		lnList.add(3);
		lnList.add(2);
		lnList.add(5);
		lnList.add(5);
		lnList.add(6);
		lnList.add(1, 4);
		lnList.addFirst(12);
		lnList.addLast(1);
		logger.debug("{}", lnList); // [12, 3, 4, 2, 5, 5, 6, 1]
		
		// 데이터 삭제
		lnList.remove(); // 첫 노드를 삭제 
		logger.debug("{}", lnList); // [3, 4, 2, 5, 5, 6, 1]
		lnList.remove(1); // 주어진 인덱스의 노드를 삭제 
		logger.debug("{}", lnList); // [3, 2, 5, 5, 6, 1]
		lnList.removeFirst(); // 첫 노드를 삭제 
		logger.debug("{}", lnList); // [2, 5, 5, 6, 1]
		lnList.removeLast(); // 마지막 노드를 삭제 
		logger.debug("{}", lnList); // [2, 5, 5, 6]
		lnList.removeFirstOccurrence(new Integer(5)); // 주어진 객체와 동일한 첫 노드를 삭제, 없으면 무시
		logger.debug("{}", lnList); // [2, 5, 6]
		lnList.removeLastOccurrence(new Integer(3)); // 주어진 객체와 동일한 마지막 노드를 삭제, 없으면 무시
		logger.debug("{}", lnList); // [2, 5, 6]
		lnList.clear(); // 전체 노드 삭제 
		logger.debug("{}", lnList); // []
		
		// 데이터 가져오기 
		lnList.add(3);
		lnList.add(2);
		lnList.add(5);
		lnList.add(6);
		
		logger.debug("{}", lnList.get(2)); // 5
		logger.debug("{}", lnList.getFirst()); // 3
		logger.debug("{}", lnList.getLast()); // 6
	}
	
	@Test
	public void testLinkedListIterator() {
		
		LinkedList<Integer> lnList = new LinkedList<>(Arrays.asList(3,2,5,6));
		
		// 데이터 반복
		Iterator<Integer> it = lnList.iterator();

		while(it.hasNext()) { // 다음요소가 있는지 체크 true/false
			logger.debug("{}", it.next()); // 요소를 순서대로 반환  3 2 5 6
		}
		
		for (Integer i : lnList) {
			logger.debug("{}", i); // 3 2 5 6
		}
		
		// 데이터 사이즈 
		logger.debug("{}", lnList.size()); // 4
		
		// 데이터 위치 찾기 
		logger.debug("{}", lnList.indexOf(5)); // 2번째 인덱스에 있다. 
	}
}
