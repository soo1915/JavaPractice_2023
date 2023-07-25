package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements Board{
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
	
	@Override
	public ArrayList<BoardDto> selectList() {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			// 조회 매핑 구문 실행
			List list = sqlSession.selectList("org.mybatis.persistence.EmpMapper.boardList");
			//System.out.println(list);
			ArrayList<BoardDto> list2 = (ArrayList<BoardDto>) list;
//			for (BoardDto dto : list2) {
//				System.out.println(dto);
//			}
			return list2;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 세션 및 트랜잭션 종료
			sqlSession.close();
		}
		return null;
	}

	@Override
	public BoardDto selectOne(int num, boolean incHits) {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDto dto = null;
		try {
			// 조회 매핑 구문 실행
			 dto = sqlSession.selectOne("org.mybatis.persistence.EmpMapper.boardListOne", num);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 세션 및 트랜잭션 종료
			sqlSession.close();
		}
		return null;
	}

	@Override
	public void insertOne(BoardDto dto) {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 조회 매핑 구문 실행
			int res = sqlSession.insert("org.mybatis.persistence.EmpMapper.insertBoard", dto);
			System.out.println(res);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 세션 및 트랜잭션 종료
			sqlSession.close();
		}
	}

	@Override
	public void updateOne(BoardDto dto) {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 조회 매핑 구문 실행
			int res = sqlSession.update("org.mybatis.persistence.EmpMapper.updateBoard", dto);
			System.out.println(res);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 세션 및 트랜잭션 종료
			sqlSession.close();
		}
	}

	@Override
	public void deleteOne(Long num) {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 조회 매핑 구문 실행
			int res = sqlSession.delete("org.mybatis.persistence.EmpMapper.deleteBoard", num);
			System.out.println(res);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 세션 및 트랜잭션 종료
			sqlSession.close();
		}
		
	}

	
}
