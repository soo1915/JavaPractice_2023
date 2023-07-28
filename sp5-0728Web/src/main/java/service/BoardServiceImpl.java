package service;

import java.util.ArrayList;

import dao.BoardDao;
import dao.BoardDto;

public class BoardServiceImpl implements BoardService{

	BoardDao dao;
	
	//생성자 방식
	public BoardServiceImpl(BoardDao dao) {
		this.dao = dao;
	}

	// setter 방식
//	public void setDao(BoardDao dao) {
//		this.dao = dao;
//	}

	@Override
	public ArrayList<BoardDto> findAll() {
		return dao.selectList();
	}

	@Override
	public BoardDto findOne(Long num, boolean incHits) {
		if (incHits) {
			dao.updateHits(num);
		}
		return dao.selectOne(num, incHits);
	}

	@Override
	public void saveOne(BoardDto dto) {
		dao.insertOne(dto);
		
	}

	@Override
	public void modifyOne(BoardDto dto) {
		dao.updateOne(dto);
		
	}

	@Override
	public void cancelOne(Long num) {
		dao.deleteOne(num);
		
	}

	@Override
	public boolean hasArticle(Long num) {
		BoardDto dto = dao.selectOne(num, false);
		if (dto == null) {
			return false;
		}
		return true;
	}
	
}
