package servlet0714;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveTest
 */
@WebServlet("/")
public class MoveTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // /servlet0714/list
		String conPath = request.getContextPath(); //  /servlet0714
		String com = uri.substring(conPath.length());// /list
		
//		System.out.println(uri);
//		System.out.println(conPath);
//		System.out.println(com);
		
		if(com.equals("/a") || com.equals("/")) {
			request.getRequestDispatcher("a.jsp").forward(request, response);
		} else if (com.equals("/b")) {
			response.sendRedirect("b.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
