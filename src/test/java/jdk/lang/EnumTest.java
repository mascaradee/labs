package jdk.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(EnumTest.class);

	@Test
	public void testEnum() {
		
		for (Animal a : Animal.values()) {
			logger.debug("줄무늬가 있는 동물은 {}이다.", a);
			logger.debug(" --- 그 동물은 {}이다.", a.getEating());
			/*
			 줄무늬가 있는 동물은 TIGGER이다.
			  --- 그 동물은 육식이다.
		  	 줄무늬가 있는 동물은 ZIBRA이다.
		   	  ---  그 동물은 초식이다.
			 줄무늬가 있는 동물은 SQUIRREL이다.
			  --- 그 동물은 잡식이다.
			 * */
		}
	}
}
enum Animal {
	
	TIGGER("육식"), ZIBRA("초식"), SQUIRREL("잡식"); // enum Contstant : 필드나 생성자보다 먼저, 맨 처음에 선언되어야 하고 후에 필드나 생성자가 따라오면 꼭 세미콜론으로  마쳐야 한다.  

	private final String eating; // 클래스 필드
	
	Animal(String eating) { // 생성자 : 외부에서 직접 호출할 수는 없다. 
		this.eating = eating;
	}
	String getEating() {
		return this.eating;
	}
}
