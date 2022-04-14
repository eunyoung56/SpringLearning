package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDAO")
public class BoardDao {
	private Connection conn = null; //����
	private PreparedStatement pstmt = null; //���� ����,����
	private ResultSet rs = null; //ó����� ����
	
	//DO�� �Ѿ���� �����͸� �޾Ƽ� DB�� ����
	public void insertBoard(BoardDo bdo) {
		
		try {
			conn = JdbcUtil.getConnection(); //db����
			String sql = "insert into board(title, writer, content) values" + "(?,?,?)"; //sql�� �ϼ�
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getWriter());
			pstmt.setString(3, bdo.getContent());
			
			pstmt.executeUpdate(); //sql����
			
			System.out.println("insertBoard() ���� �Ϸ�!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JdbcUtil.closeConnection(rs, pstmt, conn);
	}
}