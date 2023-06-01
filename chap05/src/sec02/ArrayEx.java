package sec02;

public class ArrayEx {

	public static void main(String[] args) {
		String[] header = {"성명", "전화번호", "주소"};
		String[] content = new String[3];
		content[0] = "홍길동";
		content[1] = "010-1234-1234";
		content[2] = "서울 서대문구";
		
		for (int i = 0; i<3; i++) {
			System.out.print(header[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i<3; i++) {
			System.out.print(content[i] + "\t");
		}
		
	}

}
