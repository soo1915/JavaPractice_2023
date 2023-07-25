package service;

import java.util.ArrayList;

import dao.BoardDao;
import dao.BoardDto;

public class BoardServiceImpl implements BoardService{

	BoardDao dao = new BoardDao();
	
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

}
