package algorizm;

import java.util.Arrays;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumOfDecimalSection {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SumOfDecimalSection.class);

    public long solution1(int a, int b) {
    	// 내 답
        long answer = 0;
        
        int[] tmp = {a, b};
        
        Arrays.sort(tmp);
        
        for (int i = 0; i < tmp.length; i++) {
        	
        	answer += tmp[i];
        	
        	if (tmp[i] == tmp[tmp.length - 1]) {
        		break;
        	}
        	answer += tmp[i] + 1;
        }
        
        return answer;
    }
    
    public long solution(int a, int b) {
    	// 로자 답
    	int start = a > b ? b : a;
    	int end = a > b ? a : b;
    	long answer = 0;
    	
    	for (int i = start; i <= end; i++) {
    		answer += i;
    	}
    	
    	return answer;
    }
    
    @Test
    public void testCommonDivisor() {
    	
    	StopWatch watch = new StopWatch("solution");
    	watch.start();
    	Assert.assertEquals(12, solution(3, 5));
    	Assert.assertEquals(3, solution(3, 3));
    	Assert.assertEquals(12, solution(5, 3));
    	Assert.assertEquals(-6, solution(-1, -3));
    	watch.stop();
    	logger.debug("{}", watch.getNanoTime());
    }
    
    @Test
    public void testCommonDivisor1() {
    	
    	StopWatch watch = new StopWatch("solution1");
    	watch.start();
    	Assert.assertEquals(12, solution1(3, 5));
    	Assert.assertEquals(3, solution1(3, 3));
    	Assert.assertEquals(12, solution1(5, 3));
    	Assert.assertEquals(-6, solution1(-1, -3));
    	watch.stop();
    	logger.debug("{}", watch.getNanoTime());
    }
    
    /*
문제 설명
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

제한 조건
a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
a와 b의 대소관계는 정해져있지 않습니다.
입출력 예
a	b	return
3	5	12
3	3	3
5	3	12
     */
}

