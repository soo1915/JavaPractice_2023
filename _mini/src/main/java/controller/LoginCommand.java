package controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {
	//id, 비번 검증하기
	private int id;
	private String password;
}
