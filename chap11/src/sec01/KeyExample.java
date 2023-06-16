package sec01;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {

		HashMap<Key, String> hashmap = new HashMap<>();
		
		hashmap.put(new Key(1), "홍길동");
		String name = hashmap.get(new Key(1));
		System.out.println(name);
		
//		Key key1 = new Key(100);
//		Key key2 = new Key(100);
//		
//		System.out.println(key1.hashCode());
//		System.out.println(key2.hashCode());

	}

}
