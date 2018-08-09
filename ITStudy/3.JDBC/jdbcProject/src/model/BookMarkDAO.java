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
	//���� ����Ʈ ��� ���
		public static ArrayList<BookMarkDTO> getAll() throws Exception{
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ArrayList<BookMarkDTO> datas = null;
			try {
				con = DBUtil.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery("select idx, kind, num, a_name, a_tel, a_address, station from bookmark b, accommodation a where b.num in a.a_index and kind='����' order by idx");
				datas = new ArrayList<BookMarkDTO>();	//rs�� ���������� �����Ͱ� ����Ǹ� datas ��ü�� ����
				
				while(rs.next()) {
					datas.add(new BookMarkDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));	
				}
				
				rs2 = stmt.executeQuery("select idx, kind, num, f_name, f_kind, f_tel, f_address, station from bookmark b, food f where b.num in f.f_index and kind='����' order by idx");
				while(rs2.next()) {
					datas.add(new BookMarkDTO(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8)));	
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;	//catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
			} finally {
				DBUtil.close(con, stmt, rs);
			}
			
			return datas;
		}
		
		
		
		//�ϸ�ũ �߰�
		public static boolean insert(BookMarkDTO newData) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DBUtil.getConnection();
				//������ �������� sql ���� ��ü ����
				pstmt = con.prepareStatement("insert into bookmark values(seq_bookmark_idx.nextval,?,?)");
				//?�� �����Ͱ� ���������� ����
				pstmt.setString(1, newData.getKind());
				pstmt.setInt(2, newData.getNum());
	
				
				//db�� ���� ����
				int result = pstmt.executeUpdate();	//insert/update/delete ���� �޼ҵ�
				if(result == 0) {
					return false;
				}
			} catch (SQLException e) {
				//e.printStackTrace();
				throw e;	//catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
			} finally {
				DBUtil.close(con, pstmt);
			}
			
			return true;
		}
		
		
		//�ϸ�ũ ����
	public static boolean delete(int index) throws SQLException{
			
			Connection con = null;
			PreparedStatement pstmt = null;	//alt+shift+r -> ������ �ѹ��� �ٲٱ�
			
			try {
				con = DBUtil.getConnection();
				//������ �������� sql ���� ��ü ����
				pstmt = con.prepareStatement("delete from bookmark where idx=?");
				//?�� �����Ͱ� ���������� ����
				pstmt.setInt(1, index);
			
				
				//db�� ���� ����
				int result = pstmt.executeUpdate();	//insert/update/delete ���� �޼ҵ�
				if(result == 0) {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;	//catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
			} finally {
				DBUtil.close(con, pstmt);
			}
			
			return true;
		}
}
