package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class MemberListController {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memerDao) {
		this.memberDao = memerDao;
	}
	
	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand, Model model) {
		if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberDao.selebtByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
