package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.domain.CustomerDTO;
import util.DBUtil;

public class CustomerDAO {
	//모든 고객 검색 메소드
	
	public static ArrayList<CustomerDTO> allsearch() throws Exception { //select만 할거니까 ()
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CustomerDTO> data = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer");
			rset = pstmt.executeQuery();
			
			data = new ArrayList<CustomerDTO>();
			//객체 생성이 중요하다. 여기서 많이 실수함
			
			while(rset.next()) {
			data.add(new CustomerDTO(rset.getString(1), rset.getString(2), rset.getString(3)));	
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}
	
	
	//login 검증 - id/pw 값으로 name 반환
	//select : query
	public static String loginCheck(String id, String pw) throws Exception { //catch 문장을 아예 없애고 throws로 보냄. 이런 형태가 요즘 많음. try 문에서 처리 안하겠다
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select name from customer where id = ? and pw = ?");
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				name = rset.getString(1);
				
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return name;
	}

	//해당 고객만의 정보 수정(id값으로 이름 수정)
	//update : DML
	
	public static boolean update(String id, String newName) throws Exception {  //catch 문장을 아예 없애고 throws로 보냄. 이런 형태가 요즘 많음. try 문에서 처리 안하겠다
		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;
			
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update customer set name = ? where id = ?");
			
			pstmt.setString(1, newName);
			pstmt.setString(2, id);

			int r = pstmt.executeUpdate(); //insert, update, delete 실행 , 값 받아서 int 값 있는지 없는지 여부를 보겠다.
			
			if(r != 0) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	
	}
}
