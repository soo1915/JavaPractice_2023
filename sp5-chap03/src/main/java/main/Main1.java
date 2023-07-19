package main;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Main1 {

	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();
		MemberRegisterService regSvc = new MemberRegisterService(memberDao);
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

}
