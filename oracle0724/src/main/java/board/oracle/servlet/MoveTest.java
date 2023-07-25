package board.oracle.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.oracle.BoardDao;
import board.oracle.BoardDto;

@WebServlet("/")
public class MoveTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public MoveTest() {
        super();
    }

    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                                 throws ServletException, IOException {
        String view = "";
        
        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        
        // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/list") || com.equals("/") || "".equals(com)) {
        	BoardDao dao = new BoardDao();
        	ArrayList<BoardDto> list = dao.selectList();
        	request.setAttribute("list", list);
            view = "list2.jsp";
        } else if (com.equals("/view")) {
        	// 지정된 글 번호 얻기
            int num = Integer.parseInt(request.getParameter("num"));
        	BoardDao dao = new BoardDao();
        	BoardDto dto = dao.selectOne(num, true);

            // 게시글 데이터를 담을 변수 정의
//            String writer  = dto.getWriter();
//            String title   = dto.getTitle();
//            String content = dto.getContent();
//            String regtime = dto.getRegtime();
//            int    hits    = dto.getHits();
	        request.setAttribute("dto", dto);
	        request.setAttribute("num", num);
	        
	        view = "view2.jsp";
        } else if (com.equals("/write")) {
        	view = "redirect:write2.jsp";
        } 
        
        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }       
    }

    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                                  throws ServletException, IOException {
        doGet(request, response);
    }
}