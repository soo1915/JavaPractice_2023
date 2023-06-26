package sec01;

import java.io.*;
import java.util.ArrayList;

class Member {
	String name;
	int age;
	String addr;
	String phone;
	
	public Member(String name, int age, String addr, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
	
}

public class StringSplitEx {
	
	static ArrayList<Member> list = new ArrayList<>();

	public static void strSplit(String str) {
		String[] array = str.split(",");

		int age = Integer.parseInt(array[1]);
		Member member = new Member(array[0], age, array[2], array[3]);
		list.add(member);
		
	}
	
	public static void main(String[] args) throws Exception {

		Reader reader = new FileReader(
			"C:/Temp/test7.txt"
		);
		
		BufferedReader br = new BufferedReader(reader);
		
		while(true) {
			String data = br.readLine();
			if(data == null) break;
			strSplit(data);
//			System.out.println(data);
			
		}
		br.close();
		
		for(Member m1 : list) {
			System.out.println(m1.toString());
		}
		
//		String str = "A,B,C,D" ;
//		String[] array = str.split(",");
//		for (String s1 : array) {
//			System.out.println(s1);
//		}
	}

}
