package jdk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IoTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(IoTest.class);
	
//	@Test
	public void testByteStream() throws IOException {
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try {
			fi = new FileInputStream("C://dev/input.txt"); // HELLO
			fo = new FileOutputStream("C://dev/output.txt");
			int cnt;
			
			while ((cnt = fi.read()) != -1) {
				fo.write(cnt);
				logger.debug("{}", cnt); // 72  69  76  76  79 -> 아스키코드값이 하나씩 돌면서 출력됨
			}
		} finally {
			if(fi != null) {
				fi.close(); // 스트림은 사용이 끝나면 꼭 닫아야 한다. 
			}
			if(fo != null) {
				fo.close(); // 스트림은 사용이 끝나면 꼭 닫아야 한다. 
			}
		}
		
	}
	
//	@Test
	public void testCharacterStream() throws IOException {
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("C://dev/input.txt");
			fw = new FileWriter("C://dev/character-output.txt");
			int cnt;
			
			while ((cnt = fr.read()) != -1) {
				fw.write(cnt);
				logger.debug("{}", cnt);
			}
		} finally {
			if(fr != null) {
				fr.close();
			}
			if(fw != null) {
				fw.close();
			}
		}
	}
	
//	@Test
	public void testBufferedStream() throws IOException {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("C://dev/input.txt"));
			bw = new BufferedWriter(new FileWriter("C://dev/buffer-output.txt"));
			int cnt;
			
			while ((cnt = br.read()) != -1) {
				bw.write(cnt);
				logger.debug("{}", cnt);
			}
		} finally {
			if(br != null) {
				br.close();
			}
			if(bw != null) {
				bw.close();
			}
		}
	}

	
//	@Test
	public void testScanner() throws IOException {
		Scanner s = null;
		try {
			//s = new Scanner(new BufferedReader(new FileReader("C://dev/input.txt"))); // String
			s = new Scanner(new BufferedReader(new FileReader("C://dev/int-input.txt"))); // int
			
			while(s.hasNext()) {
				logger.debug("{}", s.next()); // char 타입을 제외한 모든 원시 타입을 구분해서 지원한다. BigDecimal, BigInteger 지원
				/*
					HELLO,
					This
					is
					speaking.
					Who
					are
					you?
					I'm
					Java.
					How
					are
					you?
					Good.
				 */
				/*
				 int-intpu.txt
				 45,000,000으로 천단위를 구분한다. 
				 */
			}
		} finally {
			if(s != null) {
				s.close(); // 스트림은 아니지만 스캐너가 완료되었음 나타내기 위해 필요
			}
		}
	}
	
	@Test
	public void testFormatter() {		
		int i = 100;
		String s = "백";				
		System.out.format("숫자 %d은 한글로는 %s라고 쓴다.%n", i, s);
	}
	
	
	@Test
	public void testStandaradStream() {
		
		
	}
}
