package sec01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();
		
		set.add("123");
		set.add("가나다");
		set.add("홍길동");
		
//		Iterator<String> it = set.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		for(String str : set) {
			System.out.println(str);
		}
	}

}
