package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.BookMarkDTO;
import util.DBUtil;

public class BookMarkDAO {
	//숙소 리스트 모두 출력
		public static ArrayList<BookMarkDTO> getAll() throws Exception{
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ArrayList<BookMarkDTO> datas = null;
			try {
				con = DBUtil.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery("select idx, kind, num, a_name, a_tel, a_address, station from bookmark b, accommodation a where b.num in a.a_index and kind='숙소' order by idx");
				datas = new ArrayList<BookMarkDTO>();	//rs에 정상적으로 데이터가 저장되면 datas 객체를 생성
				
				while(rs.next()) {
					datas.add(new BookMarkDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));	
				}
				
				rs2 = stmt.executeQuery("select idx, kind, num, f_name, f_kind, f_tel, f_address, station from bookmark b, food f where b.num in f.f_index and kind='맛집' order by idx");
				while(rs2.next()) {
					datas.add(new BookMarkDTO(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8)));	
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;	//catch 내에서 throw 해야만 end user에게 상황전달 가능
			} finally {
				DBUtil.close(con, stmt, rs);
			}
			
			return datas;
		}
		
		
		
		//북마크 추가
		public static boolean insert(BookMarkDTO newData) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DBUtil.getConnection();
				//고정된 문장으로 sql 실행 객체 생성
				pstmt = con.prepareStatement("insert into bookmark values(seq_bookmark_idx.nextval,?,?)");
				//?에 데이터값 순차적으로 셋팅
				pstmt.setString(1, newData.getKind());
				pstmt.setInt(2, newData.getNum());
	
				
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
		
		
		//북마크 삭제
	public static boolean delete(int index) throws SQLException{
			
			Connection con = null;
			PreparedStatement pstmt = null;	//alt+shift+r -> 변수명 한번에 바꾸기
			
			try {
				con = DBUtil.getConnection();
				//고정된 문장으로 sql 실행 객체 생성
				pstmt = con.prepareStatement("delete from bookmark where idx=?");
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
