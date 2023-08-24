package main;

import java.util.regex.Pattern;

public class RegexEx { // 정규표현식

	public static void main(String[] args) {

		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";; // 숫자만
		String val = "1234sa@naver.com"; // 대상문자열
		
		Pattern.compile(pattern);
		boolean regex = Pattern.matches(pattern, val);
		System.out.println(regex);
	}

}
