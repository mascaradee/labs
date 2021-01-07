package jdk.statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterfaceTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(InterfaceTest.class);

	@Test
	public void testInterface() {
		
	}
}

interface Draw {
	void drawLine();
	void drawCircle();
	default String getColor(String color) {
		return color;
	}
}

interface DrawOilPaint extends Draw{
	void color(); // 상속받은 default 메서드는 다시 추상화 가능하다. 
}

interface DrawWarterPaint extends Draw{
	default String color(String color) {
		String red = "빨강";
		return red; //  상속받은 default 메서드는 재정의도 가능한다. 
	}
}

