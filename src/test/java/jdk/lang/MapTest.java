package jdk.lang;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MapTest.class);

	@Test
	public void testMap() {
		// 생성
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("나이", "2");
		hm1.put("종류", "웰시코기");	
		hm1.put("색상", "얼룩");	
		
		HashMap<String, String> hm2 = new HashMap<String, String>();
		logger.debug("{}", hm2); // {}

		// 데이터 추가	
		hm2.put("이름", "박땡땡");
		hm2.put("이름", "박땡"); // 같은 키의 다른 값을 넣으면 나중에 넣은 값으로 엎어진다. 
		hm2.putAll(hm1);
		logger.debug("{}", hm2); // {색상=얼룩, 이름=박땡, 나이=2, 종류=웰시코기} // 순서가 유지 되지 않는 걸 확인할 수 있다.
		
		// 데이터 가져오기
		Assert.assertEquals("웰시코기", hm2.get("종류")); 
		Assert.assertEquals("모름", hm2.getOrDefault("부모", "모름")); 
		
		// 데이터 삭제 
		hm2.remove("색상");
		boolean b = hm2.remove("나이", 3); // 키, 값을 항께 인수로 넘기면 둘 다 맞아야만 삭제 가능 
		logger.debug("{} : {}", hm2, b); // {이름=박땡, 나이=2, 종류=웰시코기} : false
		
		// 키, 값 존재 확인
		Assert.assertFalse(hm2.containsKey("색상"));
		Assert.assertTrue(hm2.containsKey("이름"));
		Assert.assertFalse(hm2.containsValue("색상"));
		Assert.assertTrue(hm2.containsValue("웰시코기"));
		
		// 맵 요소 개수
		Assert.assertEquals(3, hm2.size());
		
		// 맵에 요소 존재 여부
		Assert.assertFalse(hm2.isEmpty());
	}
}
