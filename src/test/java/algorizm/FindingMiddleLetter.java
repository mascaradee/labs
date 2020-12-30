package algorizm;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindingMiddleLetter {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FindingMiddleLetter.class);

    public String solution(String s) {
        String answer = "";
        
        int middle = s.length()/ 2;
        int remain = s.length() % 2;
        
        if (remain == 0) {
        	answer = s.substring(middle - 1, middle + 1);
        } else {
        	answer = s.substring(Math.round(middle), Math.round(middle) + 1);
        }
        return answer;
    }
    
	@Test
    public void testFindingMiddleLetter() {
    	Assert.assertEquals(new String("c"), solution("abcde"));
    	Assert.assertEquals(new String("we"), solution("qwer"));
    }
}
