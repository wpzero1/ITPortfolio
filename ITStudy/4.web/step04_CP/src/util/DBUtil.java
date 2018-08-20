package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds = null; //여기서 선언을 해줘야 전체적으로 ds를 쓴다.
	
	static {
		Context initContext;
		try {
			//서버의 설정 파일 정보 활용 가능한 자바 객체
			//설정 별칭으로 자원 받아서 검색 및 활용
			//java:/comp/env - java component environment
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); //lookup : 검색..
			ds = (DataSource)envContext.lookup("jdbc/myoracle"); //몇만명이 모여도 얘가 데이터소스 관리, 변수 선언은 멤버로.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException { 
		return ds.getConnection();
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(stmt != null) { 
				stmt.close();
				stmt = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt != null) { 
				stmt.close();
				stmt = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
