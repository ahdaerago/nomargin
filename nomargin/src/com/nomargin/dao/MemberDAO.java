package com.nomargin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nomargin.common.DBManager;
import com.nomargin.dto.MemberDTO;



public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MemberDTO> list = new ArrayList<>();
	
	public int insertMember(MemberDTO mDto){
		int result = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO member2(id,pw,name,nick,addr,email,birth) VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mDto.getId());
			pstmt.setString(2,mDto.getPw());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4,mDto.getNick());
			pstmt.setString(5, mDto.getAddr());
			pstmt.setString(6, mDto.getEmail());
			pstmt.setString(7, mDto.getBirth());
			result = pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
		
		
		return result;
	}

	public ArrayList<MemberDTO> loginChk(String id) {
		// TODO Auto-generated method stub
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM member2 WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id2 = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				MemberDTO mDto = new MemberDTO(id, pw, name, addr);
				list.add(mDto);
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
			
		}
		
		return list;
	}
	public ArrayList<MemberDTO> loginChk(String id,String pw) {
		// TODO Auto-generated method stub
		try {
			list.clear();
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM member2 WHERE id = ? and pw=?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(pw);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id2 = rs.getString("id");
				String pw2 = rs.getString("pw");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				MemberDTO mDto = new MemberDTO(id2, pw2, name, addr);
				list.add(mDto);
				
			}
			
		System.out.println(list.size()+">");

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		
		}
		
		return list;
	}
}
