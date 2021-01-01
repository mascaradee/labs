package jdk.lang;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArrayTest.class);

//	@Test
	public void testArray() {
		// 생성
		int[] arr1 = new int[3];
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;

		int[] arr2 = new int[] { 1, 2, 3 };
		int[] arr3 = { 1, 2, 3 };

		Assert.assertArrayEquals(arr2, arr1);

		String[] strArr1 = new String[3];
		strArr1[0] = "하나";
		strArr1[1] = "둘";
		strArr1[2] = "셋";
		String[] strArr2 = new String[] { "하나", "둘", "셋" };
		String[] strArr3 = { "하나", "둘", "셋" };

		Assert.assertArrayEquals(strArr1, strArr2);
	}

//	@Test
	public void testArray1() {
		// 꺼내 쓰기
		String[] strArr = { "하나", "둘", "셋" };
		logger.debug("{}", strArr[0]);
		logger.debug("{}", strArr[1]);
		logger.debug("{}", strArr[2]);
		logger.debug("{}", strArr.length); // length : 데이터의 숫자가 아닌 초기에 정한 배열의 크기

		// 수정
		strArr[0] = "넷";
		logger.debug("{}", strArr[0]);
	}

//	@Test
	public void testArray2() {
		String[] strArr = { "하나", "둘", "셋" };
		for (int i = 0; i < strArr.length; i++) {
			logger.debug("이건 그냥 for문 : {}", strArr[i]);
		}
		for (String s : strArr) {
			logger.debug("이건 향상된 for문: {}", s);
		}
	}

//	@Test
	public void testArray3() {
		// 배열의 원하는 요소를 삭제하는 방법 1
		// ArrayUtils.remove(array, index)는 array의 원하는 index 요소를 지운 뒤 새로운 객체로 반환을 한다.
		String[] strArr = { "하나", "둘", "셋" };
		
		for(int i = 0; i < strArr.length; i++) {
			if (strArr[i] == "하나") {
				strArr = ArrayUtils.remove(strArr, i);	 
			}
		}
		logger.debug("{}", Arrays.toString(strArr)); // array 요소들을 로그 찍을때는 요걸 사용해야 원하는대로 나온다. 
	}
	
//	@Test
	public void testArray4() {
		// 배열의 원하는 요소를 삭제하는 방법 2
		String[] strArr = { "하나", "둘", "셋" };
		String[] copy = new String[strArr.length - 1];

		for (int i = 0, j = 0; i < strArr.length; i++) {
			logger.debug("{}:{}", i, j);
		    if (strArr[i] != "둘") {
		        copy[j++] = strArr[i];
		    }
		}
		logger.debug("{}", Arrays.toString(copy));
		logger.debug("{}", strArr.length);
	}
	
//	@Test
	public void testArrayCopy() {
		char[] copyFrom = {'u','n','e','m','p','l','o','y','e','d'};
		char[] copyTo = new char[8];
		System.arraycopy(copyFrom, 2, copyTo, 0, 8);
		logger.debug("{}", copyTo[0]);
		logger.debug("{}", copyTo[1]);
		logger.debug("{}", copyTo[2]);
		logger.debug("{}", copyTo[3]);
		logger.debug("{}", copyTo[4]);
		logger.debug("{}", copyTo[5]);
		logger.debug("{}", copyTo[6]);
		logger.debug("{}", copyTo[7]);
		logger.debug("{}", copyTo[8]);		
		Assert.assertEquals("employed", new String(copyTo));
	}
	
	@Test
	public void testArrayCopy2() {
		char[] copyFrom = {'u','n','e','m','p','l','o','y','e','d'};
		char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 10);		
		Assert.assertEquals("employed", new String(copyTo));
	}
}
