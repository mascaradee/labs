package jdk.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionalClassTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(OptionalClassTest.class);

//	@Test
	public void testOptionalClass() {
		
		// of() : Optional 객체를 생성할 수 있지만 null은 허용하지 않는다. 
		//Optional<String> op = Optional.of(null); // java.lang.NullPointerException
				
		// ofNullable() : Optional 객체를 생성할 수 있지만 null은 허용하지 않는다. 
		Optional<String> op1 = Optional.ofNullable(null);
		//logger.debug("{}", op1.get()); // get() 사용 시  null이 있는 경우 java.util.NoSuchElementException: No value present
		if (op1.isPresent()) { // 위 에러를 피하기 위해서 value값을 먼저 체크한다.  
			logger.debug("{}", op1.get());
		} else {
			logger.debug("{}", "null이여");
		}
		
		Optional<String> op2 = Optional.ofNullable("안녕");
		logger.debug("{}", op2.get());
		
		List<String> list = new ArrayList<>();
		list.add("일");
		list.add("이");
		list.add(null);
		list.add("사");
		
		Optional<List<String>> op3 = Optional.ofNullable(list);
		logger.debug("{}", op3.get()); // [일, 이, null, 사]
	}
//	@Test
	public void testOptionalClass2() {
		Optional<String> op4 = Optional.empty();  // Optional 객체 초기화	
		logger.debug("{}",op4.orElse("null이 있어부러야"));
		logger.debug("{}", op4.orElseGet(() -> {
			String str = new String();
			str = "null이 또 이써야";
			return str;
		}));	
	}
	
	@Test
	public void testOptionalClass3() {
		OptionalInt op = OptionalInt.of(10);
		logger.debug("{}", op); //  OptionalInt[10]
		logger.debug("{}", op.getAsInt()); // 10
	}
}
