package algorizm;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameFailPercentage {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(GameFailPercentage.class);
	
	
    public int[] solution2(int N, int[] stages) {
        int[] answer = {};
        int temp = 0;
        
        for (int i = 0; i < stages.length; i++) {
        	for (int j = 0; j < stages.length; j++) {
//        		logger.debug("{}:{}", i, j);
            	if (stages[i] < stages [j]) {            		
            		temp =  stages[i]; 
            		stages[i] = stages [j];
            		stages [j] = temp;
            	}
            }
        }
        logger.debug("{}", Arrays.toString(stages));
        
        int[] list = {};
        int bf = 0;
        
		for (int i = 0; i < stages.length; i++) {
			for (int j = i + 1;j < stages.length; j++) {
				logger.debug("{}:{}", i, j);
				if (stages[i] == stages[j]) {
					logger.debug("{}", stages[i]);
				}
			}
			
		}
		logger.debug("{}", Arrays.toString(stages));
        
        return answer;
    }
    
    //실패율

    public int[] solution(int N, int[] stages) {
		int[] answer = new int[stages.length];
		int temp = 0;
		for (int i = 0; i < stages.length; i++) {
        	for (int j = 0; j < stages.length; j++) {
//        		logger.debug("{}:{}", i, j);
            	if (stages[i] < stages [j]) {            		
            		temp =  stages[i]; 
            		stages[i] = stages [j];
            		stages [j] = temp;
            	}
            }
        }
//		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < stages.length; i++ ) {
			
		}
		
		
		return answer;
	}
    @Test
    public void testCommonDivisor() {
    	Assert.assertArrayEquals(new int[] {3,4,2,1,5}, solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
    	Assert.assertArrayEquals(new int[] {4,1,2,3}, solution(4, new int[] {4,4,4,4,4}));
    }
}
