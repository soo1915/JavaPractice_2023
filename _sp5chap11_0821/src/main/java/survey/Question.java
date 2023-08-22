package survey;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Question {

	private String title;
	private List<String> options;
	
	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}
	
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
	
	public boolean isTest() {
		return true;
	}
	
	public String getTest1() {
		return "연습";
	}
}
