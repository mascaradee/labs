package algorizm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivideAndSort {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DivideAndSort.class);

    public int[] solution1(int[] arr, int divisor) {
    	//  내 답 
    	
        int[] answer = {};
       
        // 나머지가 0인 배열 정렬
        int i = 0;
        for (int ele : arr) {
        	if (ele % divisor == 0) {
        		i++;
        	}
		}
        // 없는 경우 -1
        if (i == 0) {
        	answer = new int[1];
        	answer[0] = -1;
        	return answer;
        }
        
        answer = new int[i];
        
        int j = 0;
        for (int ele : arr) {
        	if (ele % divisor == 0) {
        		answer[j] = ele;
				j++;
        	}
		}

        // 정렬
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int[] solution(int[] arr, int divisor) {
    	
    	// 로자 답 
    	
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        boolean b = false;
        for (int ele : arr) {
			if (ele % divisor == 0) {
				b = true;
				list.add(ele);
				continue;
			}
			
		}
        if (!b) {
        	return new int[] {-1};
        }
        
        list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? 1 : (o1 < o2 ? -1 : 0);
			}
		});
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    	
    }
    
    @Test
    public void testCommonDivisor() {
    	Assert.assertArrayEquals(new int[]{5, 10}, solution(new int[]{5, 9, 7, 10}, 5));
    	Assert.assertArrayEquals(new int[]{1, 2, 3, 36}, solution(new int[]{2, 36, 1, 3}, 1));
    	Assert.assertArrayEquals(new int[]{-1}, solution(new int[]{3,2,6}, 10));
    }
    
    /*
     문제 설명
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	
	제한사항
	arr은 자연수를 담은 배열입니다.
	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	divisor는 자연수입니다.
	array는 길이 1 이상인 배열입니다.
	입출력 예
	arr	divisor	return
	[5, 9, 7, 10]	5	[5, 10]
	[2, 36, 1, 3]	1	[1, 2, 3, 36]
	[3,2,6]	10	[-1]
	입출력 예 설명
	입출력 예#1
	arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
	
	입출력 예#2
	arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
	
	입출력 예#3
	3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
     */
}

