package swing0619;

public class BoardDto {

	private int num ;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	
	
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}


	public BoardDto(int num, String writer, String title, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}
