package jdk.expression;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeClassTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DateTimeClassTest.class);

//	@Test
	public void testLocalDateTimeNow() {
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.now(Clock.systemDefaultZone());
		LocalDate ld3 = LocalDate.now(ZoneId.systemDefault());
		logger.debug("{}", ld1); // 2020-12-28
		logger.debug("{}", ld2); // 2020-12-28
		logger.debug("{}", ld3); // 2020-12-28
		
		LocalTime lt = LocalTime.now();		
		logger.debug("{}", lt); // 15:14:56.932
	}
	
//	@Test
	public void testLocalDateTimeOf() {
		LocalDate ld1 = LocalDate.of(1982, 9, 1);
		LocalTime lt1 = LocalTime.of(12, 11, 22, 100000000);
		logger.debug("{} {}", ld1, lt1); // 1982-09-01 12:11:22.100
	}

//	@Test
	public void testLocalDateTimeInstance() {
		LocalDate ld = LocalDate.now();
		int year = ld.getYear();
		Month month = ld.getMonth();
		int month1 = ld.getMonthValue();
		int day = ld.getDayOfMonth();		
		logger.debug("{} {} {} {}", year, month, month1, day); // 2020 DECEMBER 12 28
		
		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		int min = lt.getMinute();
		int sec = lt.getSecond();
		int nano = lt.getNano();
		logger.debug("{}:{}:{}.{}", hour, min, sec, nano); // 15:55:9.587000000
	}

//	@Test
	public void testLocalDateTimeTemporalField() {
		LocalDateTime ldt = LocalDateTime.now();
		int year = ldt.get(ChronoField.YEAR);
		int month = ldt.get(ChronoField.MONTH_OF_YEAR);
		int day = ldt.get(ChronoField.DAY_OF_MONTH);
		long epochDay = ldt.getLong(ChronoField.EPOCH_DAY);
		
		logger.debug("지금은 {}년 {}월 {}일이고 1970년 1월 1일로부터 {}째 날이다. ", year, month, day, epochDay);
	}
	
//	@Test
	public void testLocalDateTimeChange() {
		// with() : 전달한 인수대로 변경 
		LocalDateTime ldt = LocalDateTime.now();
		logger.debug("오늘은 {}", ldt); //  오늘은 2020-12-28T16:20:52.063
		LocalDateTime changedD = ldt.withYear(2030);
		changedD = changedD.withHour(20);
		logger.debug("바뀐 날짜는 {}", changedD); // 바뀐 날짜는 2030-12-28T20:20:52.063
		
		// plus(), minus() : 전달한 인수로 계산을 해서 변경
		changedD = changedD.plusMinutes(20);
		logger.debug("바뀐 분은 {}", changedD); // 바뀐 분은 2030-12-28T20:40:52.063
		changedD = changedD.minusSeconds(10);
		logger.debug("바뀐 초는 {}", changedD); // 바뀐 초는 2030-12-28T20:40:42.063
	}
	
	@Test
	public void testLocalDateTimeCompare() {
		LocalDate ld = LocalDate.now();		
		LocalDate ld1 = LocalDate.of(1999, 1, 1);
		logger.debug("{}", ld.compareTo(ld1)); //  21 year 비교?
		logger.debug("{}", ld.isEqual(ld1)); // false
		logger.debug("{}", ld.isBefore(ld1)); // false
		logger.debug("{}", ld.isAfter(ld1)); // true
	}
}
