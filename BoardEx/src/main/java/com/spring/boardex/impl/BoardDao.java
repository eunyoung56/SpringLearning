package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDAO")
public class BoardDao {
	private Connection conn = null; //연결
	private PreparedStatement pstmt = null; //쿼리 구성,실행
	private ResultSet rs = null; //처리결과 저장
	
	//DO로 넘어오는 데이터를 받아서 DB에 저장
	public void insertBoard(BoardDo bdo) {
		
		try {
			conn = JdbcUtil.getConnection(); //db연결
			String sql = "insert into board(title, writer, content) values" + "(?,?,?)"; //sql문 완성
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getWriter());
			pstmt.setString(3, bdo.getContent());
			
			pstmt.executeUpdate(); //sql실행
			
			System.out.println("insertBoard() 실행 완료!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JdbcUtil.closeConnection(rs, pstmt, conn);
	}
}
