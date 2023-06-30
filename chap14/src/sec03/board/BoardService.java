package sec03.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardService {

	private List<Board> list = new ArrayList<Board>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
	private int idxnum;
	
	public void showMenu() throws Exception{
		//writeList();
		list = readList();
		while(true)	{
			System.out.println("--------------------------------------------------");
			System.out.println("1. 등록 | 2. 보기 | 3. 수정 | 4. 삭제 | 5. 저장 | 6. 종료");
			System.out.println("--------------------------------------------------");
			
			System.out.print("선택 : ");
			String selectNo = scanner.nextLine();
			
			switch(selectNo) {
			case "1" : break;
			case "2" :  showBoard(); break;
			case "3" :  break;
			case "4" :  
				System.out.println("삭제하실 인덱스를 선택해주세요.");
				idxnum = Integer.parseInt(scanner.nextLine());
				removeBoard(idxnum);
				System.out.println(idxnum+"번 인덱스를 삭제했습니다.");
				break;
			case "5" :  break;
			case "6" : 
				System.out.println("종료합니다.");
				return;
			}
		}
	}
	
//	public void registerBoard() {
//		try {
//			Board board = new Board() ;
//			board.setBno(++counter);
//			
//			System.out.print("제목 : ");
//			board.setTitle(scanner.nextLine());
//			
//			System.out.print("내용 : ");
//			board.setContent(scanner.nextLine());
//			
//			System.out.print("작성자 :");
//			board.setWriter(scanner.nextLine());
//			
//			list.add(board);
//			
//			FileOutputStream fos = new FileOutputStream("C:/Temp/board.db");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(list);
//			oos.flush();
//			oos.close();
//		} catch(Exception e) {
//			System.out.println("등록 에러 " + e.getMessage());
//		}
//	}
	public List<Board> readList() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/board.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Board> list = (List<Board>) ois.readObject();
		return list;
	}
	
	public void showBoard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Board board : list) {
			System.out.println(
				board.getBno() + "\t" + board.getTitle() + "\t" + board.getContent() + "\t" + board.getWriter() + "\t" + sdf.format(board.getDate())
					
			);
		}
	}
	
	public void removeBoard(int i) {
		list.remove(i);
	}
	
//	public static void writeList() throws Exception {
//		List<Board> list = new ArrayList<Board>();
//		
//		list.add(new Board(1, "제목1", "내용1", "글쓴이1", new Date()));
//		list.add(new Board(2, "제목2", "내용2", "글쓴이2", new Date()));
//		list.add(new Board(3, "제목3", "내용3", "글쓴이3", new Date()));
//		
//		FileOutputStream fos = new FileOutputStream("C:/Temp/board1.db");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(list);
//		oos.flush();
//		oos.close();
//	}
}
