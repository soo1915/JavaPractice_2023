package sec01;

import java.io.IOException;

public class KeyBoardToStringEx {

	public static void main(String[] args) throws IOException {
		
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes);
		
		System.out.println(readByteNo); // \r, \n(캐리지 리턴)이 기본적으로 들어가기 때문에 length + 2로 출력
		
		String str = new String(bytes, 0, readByteNo-2); // \r, \n(캐리지 리턴)이 들어가기 때문에 길이에서 2를 빼고 입력
		
		System.out.println(str);
	}

}
