package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Ex3 {
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

	public static void main(String[] args) {
		// 세션 및 트랜잭션 시작
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			// 조회 매핑 구문 실행
			//sqlSession.selectList("org.mybatis.persistence.EmpMapper.list2");
			int res = sqlSession.insert("org.mybatis.persistence.EmpMapper.insertGoods",new Goods(0,"양말",null));
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
