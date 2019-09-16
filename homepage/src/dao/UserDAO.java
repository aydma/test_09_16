package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

import vo.UserVO;

public class UserDAO {
	
	// 회원가입
	public int insertUsers(UserVO vo){
		String sql = "insert into users values (? , ? , ? , ? ) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	// 회원정보수정
	public int updateUsers(UserVO vo){
		String sql = "update users set password = ? where id= ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getId());
			
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	// 로그인
	public UserVO loginUsers(UserVO vo){ // map구조도 사용가능
		String sql = "select * from users where id= ? and password= ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO users = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getId()); 
			ps.setString(2, vo.getPassword()); 
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			
			if (rs.next()) {
				users = new UserVO();
				users.setId(rs.getString("id"));
				users.setPassword(rs.getString("password"));
				users.setName(rs.getString("name"));
				users.setRole(rs.getString("role"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return users;
	}
	
	// 로그인
//	public int loginUsers(UserVO vo){ // map구조도 사용가능
//		String sql = "select * from users where id= ? and password= ? ";
//		
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		UserVO users = null;
//		int result = 0;
//		
//		try {
//			con = JDBCUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			// ?세팅
//			ps.setString(1, vo.getId()); 
//			ps.setString(2, vo.getPassword()); 
//			
//			// 실행 및 결과값 핸들링
//			rs = ps.executeQuery();
//			
//			if (rs.next()) {
//				result = 1;
//				
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(con, ps, rs);
//		}
//		return result;
//	}
	
	// 중복체크함수
	public int checkUsers(UserVO vo){ // map구조도 사용가능
		String sql = "select * from users where id= ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO users = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?세팅
			ps.setString(1, vo.getId()); 
			
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
				
			if (rs.next()) {
				result = 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return result;
	}

}
/*
insert into users values ('admin', '1234', '관리자', 'admin')  // 회원가입
update users set password = '1234' where id='java01'         // 회원정보수정
select * from users where id='java01' and password='java01'  // 로그인
*/