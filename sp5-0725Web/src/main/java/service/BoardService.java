package service;

import java.util.ArrayList;

import dao.BoardDto;

public interface BoardService {
	ArrayList<BoardDto> findAll();
	BoardDto findOne(Long num, boolean incHits);
	void saveOne(BoardDto dto);
	void modifyOne(BoardDto dto);
	void cancelOne(Long num);
}
