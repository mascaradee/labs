package algorizm;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BorrowChoths {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(BorrowChoths.class);

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
       
        for (int i = 0; i < reserve.length ; i++) {
        	for (int j = 0; j < lost.length ; j++) {
        		if( lost [j]  == reserve[i] - 1) {
        			lost = ArrayUtils.remove(lost, j);
        		} else if (lost [j] == reserve[i] + 1) {
        			lost = ArrayUtils.remove(lost, j);
        		}
        		answer = n - lost.length; 
        	}
        }
        return answer;
    }
    
    
    @Test
    public void testCommonDivisor() {
    	Assert.assertEquals(5, solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    	Assert.assertEquals(4, solution(5, new int[]{2, 4}, new int[]{3}));
    	Assert.assertEquals(2, solution(3, new int[]{3}, new int[]{1}));
    }
}

