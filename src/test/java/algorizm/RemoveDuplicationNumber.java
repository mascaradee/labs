package algorizm;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveDuplicationNumber {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicationNumber.class);
 
	public int[] solution(int []arr) {
 
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        list.add(arr[0]);
        
        for (int i = 0; i < arr.length; i++) {
        	
        	if (arr[i] != arr[i + 1]) {
    			list.add(arr[i + 1]);
    		} 

		}
        logger.debug("{}", list);
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
	
	
    @Test
    public void testAddDecimal() {
    	
    	Assert.assertArrayEquals(new int[] {1, 3, 0, 1}, solution(new int[] {1, 1, 3, 3, 0, 1, 1}));
    	Assert.assertArrayEquals(new int[] {4, 3}, solution(new int[] {4, 4, 4, 3, 3}));
    }
}
/*
배열 arr가 주어집니다. 
배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 
예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 */