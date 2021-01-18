package algorizm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringDescending {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StringDescending.class);

    
    public String solution(String s) {
        String answer = "";
        
        char[] c = s.toCharArray();
        Arrays.sort(c);
        
        int n = s.length();
        
        char[] temp = new char[n];
        
        for (int i = 0; i < n; i++) {
            temp[n - i - 1] = c[i];
        }
        answer = new String(temp);
        
        return answer;
    }
    

    
    @Test
    public void testStringDescending() {
    	
    	Assert.assertEquals("gfedcbZ", solution("Zbcdefg"));
    }
}
/*
문자열 내림차순으로 배치하기
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
입출력 예
s	return
Zbcdefg	gfedcbZ
 */