package jdk.expression;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMethodTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DefaultMethodTest.class);

	interface Person {
		public abstract void think(); // jdk 8 이전 버전
		
		// jdk 8 이후부터 가능
		// default, static 메소드는 인터페이스 내에서 구현을 할 수 있다. 
		public default void speak() {
			logger.debug("I can speak!");
		}
		public static void smile() {
			logger.debug("I can smile!");
		}
	}
	
	class Personality implements Person {

		@Override
		public void think() {
			logger.debug("I implement Person's think");
		}		
	}
	
	@Test
	public void testDefaultMethod() {
		Personality p = new Personality();
		p.think(); // Personality 클래스에서 구현한 내용이 나온다.
		p.speak(); // Personality 클래스에서 구현하지 않아도 Person인터페이스에서 이미 구현되 내용이 나온다. 
		Person.smile(); // static 메서드 호출 방법: 인터페이스명.메서드명
	}

}
