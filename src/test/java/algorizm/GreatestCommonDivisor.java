package algorizm;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreatestCommonDivisor {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(GreatestCommonDivisor.class);
	
	// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        BigInteger bi1 = BigInteger.valueOf(n);
        BigInteger bi2 = BigInteger.valueOf(m);
        
        BigInteger gcd = bi1.gcd(bi2);
        BigInteger lcm = bi1.multiply(bi2).divide(gcd);
        
        answer[0] = gcd.intValue();
        answer[1] = lcm.intValue();
        
        return answer;
    }
    
    @Test
    public void testCommonDivisor() {
    	Assert.assertArrayEquals(new int[] {3, 12}, solution(3, 12));
    	Assert.assertArrayEquals(new int[] {1, 10}, solution(2, 5));
    }
}
