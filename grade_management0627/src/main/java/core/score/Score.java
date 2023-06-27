package core.score;

public class Score {

	private Long sid;
	private Integer seq;
	private String subject;
	private Integer score;

	public Score(Long sid, Integer seq, String subject, Integer score) {
		super();
		this.sid = sid;
		this.seq = seq;
		this.subject = subject;
		this.score = score;
	}

	public Long getSid() {
		return sid;
	}



	public void setSid(Long sid) {
		this.sid = sid;
	}



	public Integer getSeq() {
		return seq;
	}



	public void setSeq(Integer seq) {
		this.seq = seq;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "Score [sid=" + sid + ", seq=" + seq + ", subject=" + subject + ", score=" + score + "]";
	}
	
	
}
