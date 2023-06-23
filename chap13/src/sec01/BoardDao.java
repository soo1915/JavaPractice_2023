package sec01;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	List<Board> getBoardList() {
		List<Board> list = new ArrayList<>();
		
		list.add(new Board("제목 1", "내용 1"));
		list.add(new Board("제목 2", "내용 2"));
		list.add(new Board("제목 3", "내용 3"));
		
		return list;
	}
}
