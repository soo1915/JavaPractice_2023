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

	        request.setAttribute("dto", dto);
	        request.setAttribute("num", num);
	        view = "view2.jsp";
        } else if (com.equals("/write")) {
        	String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp)
                                                        : 0;
            BoardDao dao = null;
            BoardDto dto = null;
            // 글 번호가 주어졌으면, 글 수정 모드
            if (num > 0) {
        		dao = new BoardDao();
        		dto = dao.selectOne(num, false);
        		request.setAttribute("dto", dto);
                request.setAttribute("action", conPath+"/update?num="+num);
                //request.setAttribute("action", conPath+"/update");
                view = "write2.jsp";
            } else {
            	request.setAttribute("action", conPath + "/insert");
            	view = "write2.jsp";
            }
        } else if (com.equals("/insert")) {
        	request.setCharacterEncoding("utf-8");

        	// 양식에 입력되었던 값 읽기
        	String writer  = request.getParameter("writer" );
        	String title   = request.getParameter("title"  );
        	String content = request.getParameter("content");
        	
        	// 빈 칸이 하나라도 있으면 오류 출력하고 종료
        	if (writer  == null || writer.length()  == 0 ||
                title   == null || title.length()   == 0 ||
                content == null || content.length() == 0) {
        		request.setAttribute("errorMessage", "모든 항목이 빈칸 없이 입력되어야 합니다.");
        		view="errorBack.jsp";
        	} else {
        		BoardDto dto = new BoardDto();
        		dto.setWriter(writer);
        		dto.setTitle(title);
        		dto.setContent(content);
        		BoardDao dao = new BoardDao();
        		dao.insertOne(dto);
        		view = "redirect:" + conPath + "/list";
        	}
        	
        } else if (com.equals("/update"))  {
        	request.setCharacterEncoding("utf-8");
        	// 글 번호가 주어졌으면, 글 수정 모드
        	int    num     = Integer.parseInt(request.getParameter("num"));
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");
            if (writer  == null || writer.length()  == 0 ||
                title   == null || title.length()   == 0 ||
                content == null || content.length() == 0) {
        		request.setAttribute("errorMessage", "모든 항목이 빈칸 없이 입력되어야 합니다.");
        		view="errorBack.jsp";
            } else {
            	BoardDto dto = new BoardDto();
	            dto.setNum(num);
	        	dto.setWriter(writer);
	        	dto.setTitle(title);
	        	dto.setContent(content);
	            BoardDao dao = new BoardDao();
	            dao.updateOne(dto);

		        request.setAttribute("num", num);
		        view = "redirect:view?num=" + num;
            }
        } else if (com.equals("/delete")) {
        	// 지정된 글 번호 얻기
            int num = Integer.parseInt(request.getParameter("num"));

        	BoardDao dao = new BoardDao();
        	dao.deleteOne(num);
        	view = "redirect:" + conPath + "/list";
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