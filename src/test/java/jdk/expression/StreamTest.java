package jdk.expression;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StreamTest.class);
	
//	@Test
	public void testStream1() {
		//1. 컬렉션 타입의 스트림 생성 
		
		// 리스트는 컬렉션인터페이스를 상속하여  컬렉션의 stream()을 사용한다. 		
		List<String> list = new ArrayList<>();
		list.add("일");
		list.add("이");
		list.add("삼");
		list.add("사");

		Stream<String> stream = list.stream(); // Collection.stream()를 호출해 스트림 생성 
		stream.forEach(logger::debug); 
		/*
		[결과] stream()은 순차적으로 결과를 반환한다.
		|-DEBUG jdk.expression.StreamTest#forEachRemaining: 일
		|-DEBUG jdk.expression.StreamTest#forEachRemaining: 이
		|-DEBUG jdk.expression.StreamTest#forEachRemaining: 삼
		|-DEBUG jdk.expression.StreamTest#forEachRemaining: 사
		 */

		// 같은 stream을 재 사용할 경우  에러가 발생한다. stream은 일회용이다.
		//stream.forEach(logger::debug); // 에러 메시지: java.lang.IllegalStateException: stream has already been operated upon or closed

		// 하지만 원본 데이터 list는 변경이 되지 않으므로 재 사용할 수 있다. 
		Stream<String> stream2 = list.parallelStream();
		stream2.forEach(logger::debug);		
		/*
		[결과] parallelStream()은 결과를 병렬로 반환한다. 내부의 thread 가 데이터의 크기만큼 생성되어 동시에 실행 결과를 반환한다. 
		|-DEBUG jdk.expression.StreamTest#accept: 삼
		|-DEBUG jdk.expression.StreamTest#accept: 사
		|-DEBUG jdk.expression.StreamTest#accept: 이
		|-DEBUG jdk.expression.StreamTest#accept: 일
		 */
	}
	
//	@Test
	public void testStream2() {
		//2. 배열 타입의 스트림 생성 
		
		// Arrays에는 다양한 형태의 stream() 메소드가 있다. 
		// 기본 타입 숫자형의 별도 스트림이 존재한다. 
		// IntStream, LongStream, DoubleStream 인터페이스로 각각 제공
		
		String[] arr1 = new String[]{"a", "b", "c", "d"};
		
		Stream<String> stream1 = Arrays.stream(arr1);
		stream1.forEach(logger::debug); // a, b, c, d
		
		Stream<String> stream2 = Arrays.stream(arr1, 1, 3);
		stream2.forEach(logger::debug); // b, c
		
		int [] arr2 = new int[]{-2, -1, 0, 1, 2};
		IntStream stream3 = Arrays.stream(arr2, 1, 3);
		stream3.forEach(System.out::println); // -1, 0
		
		double [] arr3  = new double[]{1.1, 2.1, -3.1, -4.1};
		DoubleStream stream4 = Arrays.stream(arr3, 0, 4); 
		stream4.forEach(System.out::println); // 1.1, 2.1, -3.1, -4.1
	}
	
//	@Test
	public void testStream3() {
		// 3. 가변 매개변수의 스트림 생성 
		
		// 가변 매개변수를 Stream.of()를 이용해 stream으로 반환한다. 
		// 어떤 타입의 매개변수를 넣던 상관없다. 
		Stream<Integer> stream1 = Stream.of(100, 80, 90, 70);
		stream1.forEach(System.out::println);
		
		Stream<String> stream2 = Stream.of("일", "이", "삼");
		stream2.forEach(System.out::println);
		
		String[] arr1 = new String[]{"사과", "바나나", "오렌지", "포도"};
		Stream<String> stream3 = Stream.of(arr1);
		stream3.forEach(System.out::println);
	}
	
//	@Test
	public void testStream4() {
		// 4. 지정된 범위의 연속된 정수의 스트림 생성 
		
		// int타입  -> IntStream
		// long타입  -> LongStream
		
		// 지정된 범위의 연속된 정수를 스트림으로 생성, 시작인덱스(포함) ~ 종료인덱스(미포함)
		LongStream lStream1 = LongStream.range(0, 5);
		lStream1.forEach(System.out::println); // 0 1 2 3 4
		
		// 지정된 범위의 연속된 정수를 스트림으로 생성, 시작인덱스(포함) ~ 종료인덱스(포함)
		LongStream lStream2 = LongStream.rangeClosed(0, 5);
		lStream2.forEach(System.out::println); // 0 1 2 3 4 5
	}
	
//	@Test
	public void testStream5() {
		// 5. 특정 타입의 난수들의 스트림 생성 
		
		// int, long, double 타입의 난수로 스트림 생성한다. 
		
		// double 타입의 난수로  사이즈 3인 스트림  생성
		DoubleStream dStream1 = new Random().doubles(3);
		dStream1.forEach(System.out::println); 
		/*
		 	0.38434323931443837
			0.06228834365606606
			0.7796684376090923
			0.4812742990023451
			0.0176082316364643
		 */
		// double 타입의 난수로  사이즈 3이고 지정된 범위의 난수로 스트림  생성
		DoubleStream dStream2 = new Random().doubles(3, 0, 5);
		dStream2.forEach(System.out::println); 
		/*
		  4.302398241260798
		  3.5919174282230233
		  4.699447706075691
		 */
	}
	
//	@Test
	public void testStream6() {
		// 6. 람다 표현식으로 스트림 생성 
		
		// 무한대 순서대로 스트림이 생성
		Stream<Integer> stream = Stream.iterate(2, n -> n + 2).limit(5);
		stream.forEach(System.out::println);  //  2 4 6 8 10 -> limit이 없으면 무한대 
		
		// 무한대 순서없이 스트림이 생성
		Stream<Double> stream1 = Stream.generate(Math::random).limit(5);
		stream1.forEach(System.out::println); 
		/* limit이 없으면 무한대 
		 0.8500387237760662
		 0.43955966963566606
		 0.9991392315545777
		 0.2321134847333718
		 0.5490946597736491
		 * */
	}
	
//	@Test
	public void testStream7() throws IOException {
		// 7. 파일로 스트림 생성 
		
		String fileName = "C:/Users/masca/Desktop/readFile.txt";
		Stream<String> stream = Files.lines(Paths.get(fileName), Charset.forName("euc_kr")); // java.nio.file.Files, java.nio.file.Paths ->  신규 패키지
		stream.forEach(System.out::println);
	}
	
//	@Test
	public void testStream8() {
		// 8. 빈 스트림 생성
		// 아무 요소도 가지지 않는 빈 스트림은 Stream 클래스의 empty() 메소드를 사용하여 생성할 수 있습니다.
		Stream<Object> stream = Stream.empty();
		System.out.println(stream.count()); // 0 : 스트림의 요소의 총 개수를 출력함.
	}
	
	
	/******************************************************************************************/
	// 스트림 중개 연산 
	
//	@Test
	public void testStream9() {
		// filter(함수) : 조건에 맞는 요소만으로 재구성한 스트림을 반환한다. 
		IntStream iStream = IntStream.of(6, 7, 8, 9, 10);
		iStream.filter(n -> n % 2 == 0).forEach(System.out::println); // 6 8 10  짝수만 골라라 		
		
		LongStream lStream = LongStream.of(13, 14, 18, 16, 17, 110);
		lStream.filter(n -> n % 2 != 0).forEach(System.out::println); // 13 17  홀수만 골라라 		
		
		DoubleStream dStream = DoubleStream.of( 5.6, 3.4, 1.2, 4.5);
		dStream.filter(n -> n < 4).forEach(System.out::println); // 3.4 1.2 4이하만 골라라
	}
	
//	@Test
	public void testStream10() {
		// distinct() : 중복요소가 있으면 제거한 스트림을 반환한다. 
		IntStream stream = IntStream.of(1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5);
		stream.distinct().forEach(e-> logger.debug("distinct: {}", e)); // 1 2 3 4 5
	}
	
//	@Test
	public void testStream11() {
		// map(함수) : 스트림 요소를 주어진 함수의 조건에 맞춰 스트림을 재구성해서 반환한다. 
		Stream<String> stream = Stream.of("Hi", "hello", "happy","harmony");
		stream.map(e -> e.length()).forEach(e -> logger.debug("map: {}", e));
		
		// filter()와 map()은 둘다 주어진 함수의 조건에 맞춰 스트림을 재구성하지만 
		// filter()는 주어진 조건에 맞지 않는 요소는 버리고 스트림을 구성한다. 조건의 결과가 true/false가 되어야 한다. 
		// map()은 버리는 요소 없이 모든 요소에 조건을 적용하여 요소의 값이 변형이 있을 지 모르지만 모두 반환한다.  
		IntStream iStream = IntStream.of(6, 7, 8, 9, 10);
		iStream.map(n -> n % 2).forEach(e -> logger.debug("compare to map and filter: {}", e)); // 0 1 0 1 0
	}
	
	@Test
	public void testStream12() {
		// flatMap(함수) : 해당 스트림의 요소가 배열일 경우, 배열의 각 요소를 주어진 함수에 인수로 전달하여, 그 반환값으로 이루어진 새로운 스트림을 반환함.
		String[] arr = {"I missed you", "You need me", "We will be happy"};	 
		Stream<String> stream = Stream.of(arr); // Arrays.stream(arr);		
		stream.flatMap(s -> Stream.of(s.split(" +"))).forEach(e -> logger.debug("flatMap: {}", String.valueOf(e))); // 공백이 하나 이상 있으면 split해서 스트림을 만들어라.
	}
		
	
}
