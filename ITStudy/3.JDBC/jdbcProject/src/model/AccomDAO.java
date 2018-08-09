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
	
	//���� ����Ʈ ��� ���
	public static ArrayList<AccomDTO> getAll() throws Exception{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AccomDTO> datas = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from accommodation order by a_index");
			datas = new ArrayList<AccomDTO>();	//rs�� ���������� �����Ͱ� ����Ǹ� datas ��ü�� ����
			
			while(rs.next()) {
				datas.add(new AccomDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));	//�迭���� �ٸ��� �ε����� 1���� ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;	//catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
		} finally {
			DBUtil.close(con, stmt, rs);
		}
		
		return datas;
	}
	
	
	//���� ��õ
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
			throw e;	//catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
		} finally {
			DBUtil.close(con, pstmt,rs);
		}
		
		return datas;
	}
	
	//���� �߰�
	public static boolean insert(AccomDTO newAccom) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			//������ �������� sql ���� ��ü ����
			pstmt = con.prepareStatement("insert into accommodation values(seq_accommodation_a_index.nextval,?,?,?,?)");
			//?�� �����Ͱ� ���������� ����
			pstmt.setString(1, newAccom.getA_name());
			pstmt.setString(2, newAccom.getA_tel());
			pstmt.setString(3, newAccom.getA_address());
			pstmt.setString(4, newAccom.getStation());
			
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
	
	
public static boolean delete(int index) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;	//alt+shift+r -> ������ �ѹ��� �ٲٱ�
		
		try {
			con = DBUtil.getConnection();
			//������ �������� sql ���� ��ü ����
			pstmt = con.prepareStatement("delete from accommodation where a_index=?");
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
