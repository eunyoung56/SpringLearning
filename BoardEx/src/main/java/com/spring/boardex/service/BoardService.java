package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	void insertBoard(BoardDo bdo);//글 등록
	ArrayList<BoardDo> getBoardList(); //
	void updateBoard(BoardDo bdo);//글 수정
	void deleteBoard(BoardDo bdo);//글 삭제
}
