package test;

import java.util.Optional;

public class Ex3 {

	public static void main(String[] args) {
//		
//		int x = 10;
//		Integer y = 30;
//		Optional<String> ss = Optional.of("abcd");		
		Optional<String> ss = Optional.empty();
		System.out.println(ss); // 값 찍어보기
		System.out.println(ss.isPresent()); // 값 존재 여부 확인 (boolean)
		System.out.println(ss.orElse("값 없음")); // null인 경우에 해당 메시지 출력
//		System.out.println(ss.get()); // 값 가져오기
//		String ss = null;
//		if (ss.equals(null)) {
//			System.out.println(ss.charAt(0));		
//		} else {
//			System.out.println("값 없음");
//		}

	}

}
