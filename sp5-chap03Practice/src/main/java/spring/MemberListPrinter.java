package spring;

import java.util.Collection;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
//		for (Member member : members) {
//			printer.print(member);
//		}
		members.forEach(m -> printer.print(m));
	}
	public String printAllS() {
		Collection<Member> members = memberDao.selectAll();
		String str = "";
		for (Member member : members) {
			str += printer.printS(member);
		}
		return str;
	}

}
