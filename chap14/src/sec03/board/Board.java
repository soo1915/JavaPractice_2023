package sec03.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Board implements Serializable{
	
	public Board(int i, String string, String string2, String string3, Date date2) {
		// TODO Auto-generated constructor stub
	}
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;
	
	
}
