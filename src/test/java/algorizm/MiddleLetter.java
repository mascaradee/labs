package algorizm;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleLetter {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MiddleLetter.class);

    public String solution(String s) {
        String answer = "";
        
        // 짝수
        if (s.length() % 2 == 0) {
        	 answer = s.substring(s.length() / 2 - 1 , s.length() / 2 + 1);
        	
        } else {
        	answer = s.substring(s.length() / 2, s.length() / 2 + 1);
        }
        
        return answer;
    }
	
    @Test
    public void testMiddleLetter() {
    	
    	Assert.assertEquals("c", solution("abcde"));
    	Assert.assertEquals("we", solution("qwer"));
    }
}

/*
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s	return
abcde	c
qwer	we

*/
