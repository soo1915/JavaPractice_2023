package oracle0703;

import lombok.Data;

@Data

public class Board {

	int num;
	String writer;
	String title;
	String content;
	String regtime;
	int hits;
}
