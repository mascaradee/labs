package algorizm;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NatualNumber {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(NatualNumber.class);

	public int solution(int n) {
		int answer = 0;
		char[] c = String.valueOf(n).toCharArray();
		
		for (char cc : c) {
			answer += Integer.valueOf(String.valueOf(cc));
		}
		return answer;
	}
	
	// 인수로 전달된 숫자의 각 자리수를 더하라.
    
    @Test
    public void testCommonDivisor() {
    	Assert.assertEquals(6, solution(123)); 
    	Assert.assertEquals(24, solution(987));
    }
}

