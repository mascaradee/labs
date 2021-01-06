package jdk.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

	@Test
	public void testArrayList() {
		// 생성
		ArrayList<String> days = new ArrayList<>();
		
		// 추가
		days.add("월");
		days.add("화");
		days.add("수");
		days.add("금");
		days.add("토");
		days.add("일");
		days.add(3, "목"); // 원하는 위치에 추가 가능 하지만 그 위치 이후 요소들이 다 밀려난다.
		
		// 삭제
		days.remove(4);
		logger.debug("{}", days); // [월, 화, 수, 금, 토, 일] - toString()이 자동으로 
		boolean b = days.remove("가"); // 삭제할 대상이 없으면 false 반환하고 리스트는 변경사항이 없다. 
		logger.debug("{}", b);
		
		// 데이터 가져오기 
		logger.debug("{}", days.get(1));
		
		// 반복1
		Iterator<String> it = days.iterator();
		
		while(it.hasNext()) {
			logger.debug("{}", it.next());
		}
		
		// 반복2
		for (String s : days) {
			logger.debug("{}", s);
		}
		
		
		// 사이즈 
		logger.debug("{}", days.size()); // 6
		
		// 데이터 위치 찾기 
		logger.debug("{}", days.indexOf("일")); // 5 
		
		
	}
//	@Test
	public void testLinkedList() {
		LinkedList days = new LinkedList();
		days.add("월");
		days.add("화");
		days.add("수");
		days.add("목");
		days.add("금");
		days.add("토");
		days.add("일");
		days.remove(3);
		logger.debug("{}", days); // [월, 화, 수, 금, 토, 일]
	}
	
}
