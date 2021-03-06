package com.spring.boardex.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardex.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao dbao;

	@Override
	public void insertBoard(BoardDo bdo) {
		dbao.insertBoard(bdo);
	}

	@Override
	public ArrayList<BoardDo> getBoardList() {
		return dbao.getBoardList();
	}
	@Override
	public void updateBoard(BoardDo bdo) {
		dbao.updateBoard(bdo);
	}
	@Override
	public void deleteBoard(BoardDo bdo) {
		dbao.deletBoard(bdo);
	}

}
