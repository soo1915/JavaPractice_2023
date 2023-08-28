package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AuthInfo {

	private Long id;
	private String email;
	private String name;
	
}
