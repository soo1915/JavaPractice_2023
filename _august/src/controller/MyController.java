package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.Writer;
import auth.service.LoginService;
import member.dao.MemberDao;
import member.model.Member;
import member.service.ChangePasswordService;
import mybatis.dao.MemberDAO;

@Controller
public class MyController {
	
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private ArticleContentDao articleContentDao;
	
	@Autowired
	private MemberDAO memberDAO; 
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping("/count")
	public String countMember() {
		Writer wr = new Writer("test2", "홍길동");
		Article art = new Article(0, wr, "홍길동의 테스트", null, null, 0);
		memberDAO.insertArticle(art);
		System.out.println(art);
//		ArticleContent artc1 = new ArticleContent(104, "천사랑");
//		memberDAO.insertArtCont(artc1);
//		memberDAO.updateArticle("글제목33333", 2);
//		Member member = memberDAO.selectById("test3");
//		System.out.println(member);
		
//		System.out.println(memberDAO.selectCount());
//		List<Member> list = memberDAO.selectList();
//		for (Member member : list) {
//			System.out.println(member);
//		}
		
//		articleDao.update(1, "글제목1111");
//		System.out.println(articleDao.selectById(1));
//		Writer writer = new Writer("test4", "권율");
//		Article article = new Article(null, writer, "권율의 글1", null, null, 0);
//		Article article2 = articleDao.insert(article);
//		System.out.println(article2);
//		articleContentDao.update(101, "게시글 내용");
//		ArticleContent ac3 = articleContentDao.selectById(100);
//		System.out.println(ac3);
//		ArticleContent ac1 = new ArticleContent(101, "글의 내용101");
//		ArticleContent ac2 = articleContentDao.insert(ac1);
//		System.out.println(ac2);
//		List<Member> list = memberDAO.selectAll();
//		System.out.println(list);
//		User user = loginService.login("test", "4567");
//		System.out.println(user.getId()+","+user.getName());
//		changePasswordService.changePassword("test", "4567", "1234");
		return "count";
	}
	
	@GetMapping("/all")
	public String all(Model model) {
		List<Member> list = memberDao.selectAll();
//		for (Member member : list) {
//			System.out.println(member);
//		}
		model.addAttribute("list", list);
		return "all";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/gugu")
	public String gugu() {
		return "guguForm";
	}
	
	@PostMapping("/gugu")
	public String guguResult(Model model, @RequestParam String dan) {
		List<String> list = new ArrayList<>();
		int num = Integer.parseInt(dan);
		for (int i=1; i <= 9; i++) {
			String res 
					= String.format("%d X %d = %d", num, i, i*num);
			list.add(res);
		}
//		for (String s : list) {
//			System.out.println(s);
//		}
		model.addAttribute("list", list);
		return "guguResult";
	}
}




