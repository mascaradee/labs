package springmvc.util;

public class TextUtil {
	public static String trim(int a) {
		String x = "꺼억";
		StringBuilder xx = new StringBuilder();
		for (int i = 0; i < a; i++) {
			xx.append(x);
		}
		return xx.toString();
	}
}
