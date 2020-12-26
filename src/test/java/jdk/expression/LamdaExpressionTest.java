package jdk.expression;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LamdaExpressionTest {
	private static final Logger logger = LoggerFactory.getLogger(LamdaExpressionTest.class);

	// rule no.1
	//	XXXTest : 클래스명명 규칙
	
	// rule no.2
	//	testXXX : 메소드명명 규칙

	@Test
	public void testLamdaExpression(){

		new Thread(new Runnable() {
		    public void run() {
		        System.out.println("전통적인 방식의 일회용 스레드 생성");
		    }
		}).start();

		new Thread(()->{
		    System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
		}).start();
	}
	
	@Test
	public void testAnonymousClass(){

		Object obj = new Object() {
			int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		Assert.assertNotNull(obj);
	}
	
	@Test
	public void testMethodReference(){
		List<String> list = Arrays.asList(new String[] { "하나", "둘", "셋" });
		Stream<String> stream = list.stream();
//		stream.forEach((ele) -> { 
//			System.out.println(ele); 
//		}); // 요건 아래와 같고
//		stream.forEach(System.out::println); // 스태틱 멤버라서 클래스를 명시한 것 뿐임.
		
//		stream.forEach((ele) -> { 
//			logger.debug(ele); 
//		}); // 얘도 아래와 같음
		stream.forEach(logger::debug); 
		// 콜백 함수에서 콜러가 넘겨줄 파라미터를 그대로 사용할 경우 이렇게 단축하여 표현할 수 있음
	}
	
	@Test
	public void testMethodReference2(){
		// 아래 넷은 모두 결과가 같다.
		
		// #1 내부 클래스를 이용하는 방식
		InnerInf inf = new InnerInf() {
			@Override
			public void saySomething(String str) {
				logger.debug(str);				
			}
		};
		InnerClass.doSomething(inf);
		
		// #2 익명 클래스를 이용하는 방식
		InnerClass.doSomething(new InnerInf() {
			@Override
			public void saySomething(String str) {
				logger.debug(str);				
			}
		});
		
		// #3 1, 2를 줄여서 쓸 수 있게 나온게 람다 표현식
		InnerClass.doSomething((str) -> {
			logger.debug(str);
		}); // 아래와 같다.
		
		// #4 3을 줄여서 나온게 메서드 참조
		InnerClass.doSomething(logger::debug);		
//		InnerClass.doSomething(System.out::println);		
	}
	
	static class InnerClass {
		static void doSomething(InnerInf inf) {
			String str = "hello";
			inf.saySomething(str);
		}
	}
	
	interface InnerInf {
		void saySomething(String str);
	}
	
	/**
	 * 메서드 참조를 사용할 수 없는 경우
	 * 
	 * @author masca
	 */
	@Test
	public void testMethodReference3(){
		InnerClass.doSomething((str) -> {
			logger.debug(str);
			logger.info(str);
		});
		// 위의 경우 메서드 참조로 작성할 수 없음.
		// 메서드 참조는, 람다 표현식의 바디에서 단 하나의 호출 표현식만 작성할 경우에만 적용할 수 있다.
		InnerClass.doSomething(logger::debug);
		//InnerClass.doSomething(logger::debug, logger::info);
	}
}