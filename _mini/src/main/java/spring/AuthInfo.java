package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AuthInfo {

	// 세션 등록 DTO
	private int id;
	private String name;
	
}
