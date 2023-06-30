package maria0630;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDto {

	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	public int hits;
	

	
}
