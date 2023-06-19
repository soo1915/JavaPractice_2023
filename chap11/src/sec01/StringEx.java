package sec01;

public class StringEx {

	public static void main(String[] args) {
		
		String str = "자바 프로그래밍";
		
		int location = "여기에 없는".indexOf("프로그래밍");
		System.out.println(str.indexOf("프로그래밍"));
		System.out.println(location);
		
		System.out.println(str.length());
		String str1 = str.replace("자바", "코볼");
		System.out.println("----");
		System.out.println(str1);
		System.out.println(str);
		System.out.println("----");
		String ssn = "880815-1234567";
		String fn = ssn.substring(0,6);
		System.out.println(fn);
		System.out.println("----");
		String tel1 = "              9        8       7         ";
		System.out.println(tel1.trim());
		System.out.println("----");
		String num = "10";
		int a1 = Integer.parseInt(num);
		System.out.println(a1);
		String a11 = String.valueOf(a1);
		System.out.println(a11);
	}

}
