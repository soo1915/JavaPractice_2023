package sec01;

import java.util.HashMap;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "한국");
		map.put(2, "미국");
		map.put(3, "일본");
		String val = map.get(1);
		System.out.println(val);

	}

}
