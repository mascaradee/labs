package algorizm;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Budget {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Budget.class);

	public int solution(int[] d, int budget) {
		int answer = 0;
		
//		Arrays.sort(d);
		
		for (int i = 0; i < d.length; i++) {
			budget = budget - d[i];
			if(budget < 0) {
				break;
			}
			answer++;
		}
		return answer;
	}

    
    @Test
    public void testCommonDivisor() {
    	Assert.assertEquals(3, solution(new int[]{1,3,2,5,4}, 9));
    	Assert.assertEquals(4, solution(new int[]{2,2,3,3}, 10));
    }
}
