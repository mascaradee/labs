package algorizm;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddDecimal {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AddDecimal.class);

    public int[] solution(int[] numbers) {
        
        if (numbers.length == 1) {
        	return numbers;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
			for (int j = numbers.length-1; j > i; j--) {
				set.add(numbers[i] + numbers[j]);
				logger.debug("{},{}", i, j);
			}
		}
        
        int [] answer = new int[set.size()];
        answer = set.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
	
	
    @Test
    public void testAddDecimal() {
    	
    	Assert.assertArrayEquals(new int[] {2,3,4,5,6,7}, solution(new int[] {2,1,3,4,1}));
    	Assert.assertArrayEquals(new int[] {2,5,7,9,12}, solution(new int[] {5,0,2,7}));
    	Assert.assertArrayEquals(new int[] {0}, solution(new int[] {0}));
    }
}

/*
 
문제 설명
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
입출력 예
numbers		result
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]
입출력 예 설명
입출력 예 #1

2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
3 = 2 + 1 입니다.
4 = 1 + 3 입니다.
5 = 1 + 4 = 2 + 3 입니다.
6 = 2 + 4 입니다.
7 = 3 + 4 입니다.
따라서 [2,3,4,5,6,7] 을 return 해야 합니다.
입출력 예 #2

2 = 0 + 2 입니다.
5 = 5 + 0 입니다.
7 = 0 + 7 = 5 + 2 입니다.
9 = 2 + 7 입니다.
12 = 5 + 7 입니다.
따라서 [2,5,7,9,12] 를 return 해야 합니다.
 */