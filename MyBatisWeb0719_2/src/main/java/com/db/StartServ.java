package com.db;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Servlet implementation class AppObj
 */
@WebServlet("/start")
public class StartServ extends HttpServlet {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// 마이바티스 환경 설정 XML 파일 경로
			String resource = "resources/mybatis/config-mybatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				PrintWriter out = response.getWriter();
		// 세션 및 트랜잭션 시작
				SqlSession sqlSession = sqlSessionFactory.openSession();

				try {
					// 조회 매핑 구문 실행
					List<Object> num = sqlSession.selectList("org.mybatis.persistence.EmpMapper.selectGoods");
					System.out.println(num);
					request.setAttribute("list", num);
					request.getRequestDispatcher("index-result2.jsp")
					.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 세션 및 트랜잭션 종료
					sqlSession.close();
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
