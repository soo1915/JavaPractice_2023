package spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SimpleBBS {

	private int id;
	private String writer;
	private String title;
	private String content;
	private int user_id;
	
	public SimpleBBS(int id, String writer, String title) {
		this.id = id;
		this.writer = writer;
		this.title = title;
	}
}
