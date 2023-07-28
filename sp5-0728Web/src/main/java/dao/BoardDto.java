package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDto {

	private Long num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private Integer hits;
}
