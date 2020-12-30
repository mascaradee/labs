package jdk.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CharacterTest.class);

//	@Test
	public void testCharacter() {
		// 자바의 한 문자는 char 타입으로 홑따옴표로 값을 할당한다. 
		char ch = 'a'; 
		// Unicode for uppercase Greek omega character
		char uniChar = '\u03A9';
		// an array of chars
		char[] charArray = { 'a', 'b', 'c', 'd', 'e' };
		
		logger.debug("{}\n{}\n{}", ch, uniChar, charArray);
	}
	
	@Test
	public void testCharacterClass() {
			
		Character ch1 = new Character('a');
		Character ch2 = Character.toUpperCase(ch1);
		logger.debug("{}", ch2); // A
		Character ch3 = Character.toLowerCase(ch2);
		logger.debug("{}", ch3); // a
	}
	@Test
	public void testEscapeSequence() {
		logger.debug("{}", "She said \"Hello!\" to me.");
	}
	
	
	
	
}
