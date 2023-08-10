package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import article.model.Writer;
import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ArticlePage;
import article.service.ListArticleService;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;

@Controller
public class ArticleController {

	@Autowired
	private ListArticleService listService;
	
	@Autowired
	private ModifyArticleService modifyService;
	
	@Autowired
	private ReadArticleService readService;
	
	@Autowired
	private WriteArticleService writeService;
	
	@GetMapping("/listArticle.do")
	public String list(Model model, @RequestParam String pageNoVal) {
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		model.addAttribute("articlePage", articlePage);
		return "listArticle";
	}
	
	@GetMapping("/modifyForm.do")
	public String modifyGet(Model model, @RequestParam String noVal, HttpServletRequest req, HttpServletResponse res) throws IOException{
		try {
			
			int no = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(no, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, articleData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
					articleData.getArticle().getTitle(),
					articleData.getContent());

			model.addAttribute("modReq", modReq);
			return "modifyGet";
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@PostMapping("/modifyForm.do")
	public String modifyPost(Model model, HttpServletRequest req, HttpServletResponse res) throws IOException{
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);

		ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
				req.getParameter("title"),
				req.getParameter("content"));
		model.addAttribute("modReq", modReq);

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return "modifyForm";
		}
		try {
			modifyService.modify(modReq);
			return "modifySuccess";
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
	
	@GetMapping("readArticle.do")
	public String read(Model model, @RequestParam String noVal, HttpServletRequest req, HttpServletResponse res) throws Exception{
		int articleNum = Integer.parseInt(noVal);
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			model.addAttribute("articleData", articleData);
			return "readArticle";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@GetMapping("/newArticleForm.do")
	public String writeGet() {
		return "newArticleForm";
	}
	
	@PostMapping("/newArticleForm.do")
	public String writePost(Model model, HttpServletRequest req) {
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return "newArticleForm";
		}
		
		int newArticleNo = writeService.write(writeReq);
		model.addAttribute("newArticleNo", newArticleNo);
		
		return "newArticleSuccess";
	}
	
	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
	
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new Writer(user.getId(), user.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}
	
}
