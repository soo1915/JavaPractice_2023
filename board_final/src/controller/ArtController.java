package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

///article/write.do=article.command.WriteArticleHandler
///article/list.do=article.command.ListArticleHandler
///article/read.do=article.command.ReadArticleHandler
///article/modify.do=article.command.ModifyArticleHandler

@Controller
public class ArtController {

	@Autowired
	private ListArticleService listService;
	
	@Autowired
	private ModifyArticleService modifyService;
	
	@Autowired
	private ReadArticleService readService;
	
	@Autowired
	private WriteArticleService writeService;

	@GetMapping("/article/list.do")
	public String listArticle(HttpServletRequest req) {
		
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		req.setAttribute("articlePage", articlePage);
		
		return "listArticle";
	}
	
	@GetMapping("/article/read.do")
	public String readArticle(HttpServletRequest req, HttpServletResponse res) {
		
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			return "readArticle";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			try {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	@GetMapping("/article/write.do")
	public String writeArticle1() {
		return "newArticleForm";
	}
	
	@PostMapping("/article/write.do")
	public String writeArticle2(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return "newArticleForm";
		}
		
		int newArticleNo = writeService.write(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);
		
		return "newArticleSuccess";

	}
	
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new Writer(user.getId(), user.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}
	
	@GetMapping("/article/modify.do")
	public String modifyArticle1(HttpServletRequest req, HttpServletResponse res) {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(no, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, articleData)) {
				try {
					res.sendError(HttpServletResponse.SC_FORBIDDEN);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
					articleData.getArticle().getTitle(),
					articleData.getContent());

			req.setAttribute("modReq", modReq);
			return "modifyForm";
		} catch (ArticleNotFoundException e) {
			try {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	
	@PostMapping("/article/modify.do")
	public String modifyArticle2(HttpServletRequest req, HttpServletResponse res) {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);

		ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
				req.getParameter("title"),
				req.getParameter("content"));
		req.setAttribute("modReq", modReq);

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
			try {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		} catch (PermissionDeniedException e) {
			try {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
	
}
