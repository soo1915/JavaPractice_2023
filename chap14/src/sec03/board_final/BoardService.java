package sec03.board_final;

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
	private List<Board> list = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
	private int idxnum;
	
	public void showMenu() throws Exception {
		//writeList();
		list = readList();
		while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("1.등록 | 2.보기  | 3.수정 | 4.삭제  | 5.저장  | 6.종료");
			System.out.println("------------------------------------------------");
			
			System.out.print("선택: ");
			String selectNo = scanner.nextLine();
			switch(selectNo) {
				case "1": 
					registList();
					break;
				case "2": showBoard(); break;
				case "3": 
					updateBoard();
					break;
				case "4": 
					System.out.println("삭제하실 인덱스를 선택해주세요.");
					idxnum = Integer.parseInt(scanner.nextLine());
					removeBoard(idxnum);
					System.out.println((idxnum-1)+"번 인덱스를 삭제했습니다.");
					break;
				case "5": 
					writeList();
					System.out.println("내용을 DB에 저장합니다.");
					break;
				case "6":
					System.out.println("종료합니다.");
					return;
			}
		}
	}
	
	public void registList() {
		Board board = null;
		System.out.println("제목 : ");
		String title = scanner.nextLine();
		System.out.println("내용 : ");
		String content = scanner.nextLine();
		System.out.println("작성자 : ");
		String writer = scanner.nextLine();
		board = new Board(list.size()+1, title, content, writer, new Date());
		list.add(board);
	}
	
	public List<Board> readList() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/board1.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Board> list = (List<Board>) ois.readObject();
		return list;
	}
	
	public void showBoard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		list.stream().forEach(s-> {
			System.out.println(
					s.getBno() + "\t" + s.getTitle() + "\t" + 
					s.getContent() + "\t" + s.getWriter() + "\t" +
					sdf.format(s.getDate())
				);
		});
//		for(Board board : list) {
//			System.out.println(
//				board.getBno() + "\t" + board.getTitle() + "\t" + 
//				board.getContent() + "\t" + board.getWriter() + "\t" +
//				sdf.format(board.getDate())
//			);
//		}
	}
	
	public void writeList() throws Exception {
		//List<Board> list = new ArrayList<>();
		
		FileOutputStream fos = new FileOutputStream("C:/Temp/board1.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public void updateBoard() {
		Board board1 = null;
		System.out.println("수정을 원하는 인덱스를 입력해주세요.");
		idxnum = Integer.parseInt(scanner.nextLine());
		System.out.println("제목 : ");
		String title = scanner.nextLine();
		System.out.println("내용 : ");
		String content = scanner.nextLine();
		System.out.println("작성자 : ");
		String writer = scanner.nextLine();
		list.set(idxnum-1, new Board(idxnum, title, content, writer, new Date()));
	}
	public void removeBoard(int i) {
		list.remove(i-1);
	}
//	
//	public void updateList() {
//		list.set(1, board = new Board(list.size(), title, content, writer, new Date()));
//	}
}
