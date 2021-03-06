package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	

	public ArrayList<BoardDo> getBoardList(){
		conn = JdbcUtil.getConnection(); 
		
		ArrayList<BoardDo> aList = new ArrayList<BoardDo>();
		String sql = "select * from board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setTitle(rs.getString(2));
				bdo.setWriter(rs.getString(3));
				bdo.setContent(rs.getString(4));
				aList.add(bdo);
			}
			System.out.println("getBoardList() 처리 완료!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.closeConnection(rs, pstmt, conn);
		return aList;
	}
	
	public void updateBoard(BoardDo bdo) {
		
		conn = JdbcUtil.getConnection();
		String sql = "update board set title=?,content=? where seq =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bdo.getTitle());
			pstmt.setString(2,  bdo.getContent());
			pstmt.setInt(3,  bdo.getSeq());
			pstmt.executeUpdate();
			
			JdbcUtil.closeConnection(rs, pstmt, conn);
			
			System.out.println("updateBoard() 처리 완료!!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deletBoard(BoardDo bdo) {
		conn = JdbcUtil.getConnection();
		String sql = "delete from board where seq =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			pstmt.executeUpdate();
			conn.close();
			
			JdbcUtil.closeConnection(rs, pstmt, conn);
			
			System.out.println("deleteBoard() 처리 완료!!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
