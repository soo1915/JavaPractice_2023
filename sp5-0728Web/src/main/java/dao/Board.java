package dao;

import java.util.ArrayList;

public interface Board {
	ArrayList<BoardDto> selectList();
	BoardDto selectOne(Long num, boolean incHits);
	void insertOne(BoardDto dto);
	void updateOne(BoardDto dto);
	void deleteOne(Long num);
	void updateHits(Long num);
}