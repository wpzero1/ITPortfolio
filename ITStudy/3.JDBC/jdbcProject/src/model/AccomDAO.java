package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.AccomDTO;
import util.DBUtil;

public class AccomDAO {
	
	//숙소 리스트 모두 출력
	public static ArrayList<AccomDTO> getAll() throws Exception{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AccomDTO> datas = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from accommodation order by a_index");
			datas = new ArrayList<AccomDTO>();	//rs에 정상적으로 데이터가 저장되면 datas 객체를 생성
			
			while(rs.next()) {
				datas.add(new AccomDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));	//배열과는 다르게 인덱스가 1부터 시작
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;	//catch 내에서 throw 해야만 end user에게 상황전달 가능
		} finally {
			DBUtil.close(con, stmt, rs);
		}
		
		return datas;
	}
	
	
	//숙소 추천
	public static ArrayList<AccomDTO> getAccom(String station) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<AccomDTO> datas = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			datas = new ArrayList<AccomDTO>();
			pstmt = con.prepareStatement("select * from accommodation where station=?");
			pstmt.setString(1, station);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas.add(new AccomDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;	//catch 내에서 throw 해야만 end user에게 상황전달 가능
		} finally {
			DBUtil.close(con, pstmt,rs);
		}
		
		return datas;
	}
	
	//숙소 추가
	public static boolean insert(AccomDTO newAccom) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			//고정된 문장으로 sql 실행 객체 생성
			pstmt = con.prepareStatement("insert into accommodation values(seq_accommodation_a_index.nextval,?,?,?,?)");
			//?에 데이터값 순차적으로 셋팅
			pstmt.setString(1, newAccom.getA_name());
			pstmt.setString(2, newAccom.getA_tel());
			pstmt.setString(3, newAccom.getA_address());
			pstmt.setString(4, newAccom.getStation());
			
			//db에 실제 실행
			int result = pstmt.executeUpdate();	//insert/update/delete 실행 메소드
			if(result == 0) {
				return false;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;	//catch 내에서 throw 해야만 end user에게 상황전달 가능
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return true;
	}
	
	
public static boolean delete(int index) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;	//alt+shift+r -> 변수명 한번에 바꾸기
		
		try {
			con = DBUtil.getConnection();
			//고정된 문장으로 sql 실행 객체 생성
			pstmt = con.prepareStatement("delete from accommodation where a_index=?");
			//?에 데이터값 순차적으로 셋팅
			pstmt.setInt(1, index);
		
			
			//db에 실제 실행
			int result = pstmt.executeUpdate();	//insert/update/delete 실행 메소드
			if(result == 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;	//catch 내에서 throw 해야만 end user에게 상황전달 가능
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return true;
	}
}
