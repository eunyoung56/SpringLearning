package com.spring.boardex.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.boardex.common.JdbcUtil;
import com.spring.boardex.impl.BoardDo;

public class BoardClient {
	public static void main(String[] main) {
//		테스트해보기 위해 사용한 것
//		JdbcUtil jutil = new JdbcUtil();
//		jutil.getConnection();
		
		ApplicationContext context = new GenericXmlApplicationContext("BoardSetting.xml"); //스프링 컨테이너 가져오기(객체...)
		
		BoardService bService = (BoardService)context.getBean("boardService");//BoardService객체 가져오기
		
		//글 목록 저장하기
		BoardDo bdo = new BoardDo();
		bdo.setTitle("Title");
		bdo.setWriter("Writer");
		bdo.setContent("content");
		bService.insertBoard(bdo);
		
		//글 목록 보기
//		ArrayList<BoardDo> aList = bService.getBoardList();
//		for(BoardDo temp : aList) {
//			System.out.println(temp.toString());
//		}
		
		//글 수정
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(2);
//		bdo.setTitle("글 제목 수정");
//		bdo.setContent("글 내용 수정");
//		bService.updateBoard(bdo);
//		
//		ArrayList<BoardDo> aList2 = bService.getBoardList();
//		for(BoardDo temp : aList2) {
//			System.out.println("(수정)-->" +temp.toString());
//		}
		
		//글 삭제
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(3);
//		bService.deleteBoard(bdo);
//		
//		ArrayList<BoardDo> aList3 = bService.getBoardList();
//		for(BoardDo temp : aList3) {
//			System.out.println("(삭제)-->" +temp.toString());
//		}
	}
}
