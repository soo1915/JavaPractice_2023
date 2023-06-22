package sec01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEntryEx {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		// 해시맵 이라고 부른다 (key, value)
		map.put("김", 100);
		map.put("이", 95);
		map.put("박", 90);
//		System.out.println(map.get("김"));
		
		Set<Map.Entry<String, Integer>> es = map.entrySet(); // 해시맵을 set로 변경시킴
		Iterator<Map.Entry<String, Integer>> it = es.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> a1 = it.next();
			System.out.println(a1.getKey());
			System.out.println(a1.getValue());
		}
		
//		for(Map.Entry<String, Integer> a1 : es) {
//			System.out.println(a1.getKey());
//			System.out.println(a1.getValue());
//		}
	}

}
