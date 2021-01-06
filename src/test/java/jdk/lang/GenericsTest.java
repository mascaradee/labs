package jdk.lang;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericsTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(GenericsTest.class);
	
//	@Test
	public void testGenericType() {
		// 원시 타입 
		Box box = new Box(); // 제네릭이 아닌 클래스처럼 선언하고 인스턴스화 시킬수 있지만 Box는 raw 타입을 제네릭타입의 인수로 넘긴것이다.
		
		Box<Integer> intBox = new Box<>(); // 제네릭 타입인자에  Integer타입을 인수로 넣어 인스턴스를 생성한다. 
		Box box1 = intBox; // raw type에 Box<Integer>클래스를 매개변수화하여 할당할수 있다. 
		//box1.set(1); // warning: unchecked invocation to set(T) 실제로 이 부분은 아예 컴파일 에러가 난다.. -> 바뀐듯 
		
		Box box2 = new Box();
		Box<String> strBox = box2; // 위와 반대로  제네릭 타입에 raw 타입을 넣으면 warning이 뜬다 
								   // warning: The expression of type GenericsTest.Box needs 
		                           // unchecked conversion to conform to GenericsTest.Box<String>
	}

//	@Test
	public void testGenericMethod() {
		// 제네릭 메서드
		Box<String> fruit = new Box<>(); // Box<String> fruit = new Box<String>(); 와 동일
		fruit.set("사과");
		Box<Integer> price = new Box<>(); // Box<Integer> price = new Box<Integer>(); 와 동일
		price.set(500);
		String result = PrintGeneric.<String, Integer>print(fruit, price);
		String result2 = PrintGeneric.print(fruit, price);
		logger.debug("{}, {}", result, result2);
	}
	
	@Test
	public void testBoundedTypeParameters() {
		// 제네릭 클래스 타입 제한 1
		RestrictedGeneric<Integer> r1 = new RestrictedGeneric<>();
//		RestrictedGeneric<String> r2 = new RestrictedGeneric<>(); // Bound mismatch
		
		
		// 제네릭 메서드 타입 제한
		String fruit = new String("사과"); 
//		String price = new String("500");
//		String result = RestrictedGenericMethod.print(fruit, price); // The method print(K, V) in the type RestrictedGenericMethod is not applicable for the arguments (String, String)
		
	}
	
	
	@Test
	public void testInheritance() {
		Box<Number> box = new Box<Number>();
		box.add(new Integer(10));   // OK
		box.add(new Double(10.1));  // OK
		
		InheritanceTest ih = new InheritanceTest();
		ih.boxTest(new Box<Number>());
		//ih.boxTest(new Box<Integer>()); // The method boxTest(Box<Number>) in the type InheritanceTest is not applicable for the arguments (Box<Integer>)
	}

	@Test
	public void testSubTyping() {
		PayloadList<String,Integer> p = new PayloadListImpl<>();
	}
}

interface PayloadList<E, P> extends List<E>{
	
}

class PayloadListImpl<E,P> implements PayloadList<E,P> {
	@Override public int size() {  return 0; }  @Override public boolean isEmpty() {  return false; }  @Override public boolean contains(Object o) {  return false; }  @Override public Iterator<E> iterator() {  return null; }  @Override public Object[] toArray() {  return null; }  @Override public <T> T[] toArray(T[] a) {  return null; }  @Override public boolean add(E e) {  return false; }  @Override public boolean remove(Object o) {  return false; }  @Override public boolean containsAll(Collection<?> c) {  return false; }  @Override public boolean addAll(Collection<? extends E> c) {  return false; }  @Override public boolean addAll(int index, Collection<? extends E> c) {  return false; }  @Override public boolean removeAll(Collection<?> c) {  return false; }  @Override public boolean retainAll(Collection<?> c) {  return false; }  @Override public void clear() {   }  @Override public E get(int index) {  return null; }  @Override public E set(int index, E element) {  return null; }  @Override public void add(int index, E element) {   }  @Override public E remove(int index) {  return null; }  @Override public int indexOf(Object o) {  return 0; }  @Override public int lastIndexOf(Object o) {  return 0; }  @Override public ListIterator<E> listIterator() {  return null; }  @Override public ListIterator<E> listIterator(int index) {  return null; }  @Override public List<E> subList(int fromIndex, int toIndex) {  return null; }
}

class InheritanceTest {
	public void boxTest(Box<Number> n) { 
	}
}

class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public void add(Number n) {}
	public T get() { return t; }
}

class PrintGeneric {
	public static <K, V> String print(Box<String> fruit, Box<Integer> price) {
		return fruit.get() + "는 맛있어. 맛있으면 "  + price.get() + "원";
	}	
}

class RestrictedGeneric<A extends Number> {
	private A n;
	
	public boolean isEven() {
		return n.intValue() % 2 == 0;
	}
}
class RestrictedGenericMethod {
	public static <K, V extends Number> String print(K fruit, V price) {
		return fruit + "는 맛있어. 맛있으면 "  + price + "원";
	}
}
