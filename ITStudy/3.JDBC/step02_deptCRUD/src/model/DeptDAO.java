package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {
	//��� �˻�
	//select * from dept
		public static ArrayList <DeptDTO> getAll() throws Exception{ //������ �޴°͵� ���ÿ� �����.
			Connection con = null; //finally���� ���� ���ؼ� try�� �ۿ��� ����
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<DeptDTO> datas = null; //ArrayList �迭 ���� �� �ʱ�ȭ
			
			try {
				con = DBUtil.getConnection(); //����
				stmt = con.createStatement(); //sql���� ���� �޼ҵ�. ����� con�� ���� ����� �ҷ��� �� ����
				rs = stmt.executeQuery("select * from dept01");
				
				datas = new ArrayList<DeptDTO>(); //select�� �̷���� ������ ���⼭ ��ü ����°� �� ���ٰ� ��.
				while(rs.next()) { //row���� Ȯ���ϴ� ��
					datas.add(new DeptDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
					//���⼭ �ε����� 1���� �����Ѵ�. �ε��� �ϳ��� �̾Ƽ� DeptDTO�� datas�� add�� �־� ���ο� ��ü ����� ����
					//�� ���� �� ��, 
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e; //catch ������ �ٽ� ������. �׷��߸� ������������ ��Ȳ���� ����. (��������, ������ ��ΰ� ��Ȳ�� �˾ƾ���)
			} finally { //try�� �־�߸� �� �� �ִ� ����
				DBUtil.close(con, stmt, rs);
			}
			return datas;
		}
	//deptno�� �ش� �μ� ���� �˻�
		
		public static DeptDTO getDeptInfoAll(int deptno) throws SQLException { 
				
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			DeptDTO datas = null;
					
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from dept01 where deptno = ?");
				
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
				datas = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getString(3));}
			} catch (SQLException e) {
				e.printStackTrace();
				
				throw e;
				
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
		
			return datas;
		}
	
	//���ο� �μ� ���� ����
		//insert into dept values (?, ?, ?)
		//insert into dept values(50, '�ѹ���', '����')
		// -> �̰ŷ� ��������, (�� ' ���� �� " " ���ڿ� �ȿ��ٰ� �� �־��ִ� ���� �߻��ؼ� �����ϴ�. �׷��� �̸� ������� PreparedStatement�� ���ְԵȴ�.
		public static boolean insert(DeptDTO newDept) throws SQLException { //DTO��ü�� �ƴ� ������ ������ �� �־��� ���� ������
			//( int deptno, String dname) ó��.. �׷���, ȿ���� ���鿡�� DTO ��ü
			
			//������ ��� �ڵ� ����, �׸��� ���� ���ϴ�
			
			Connection con = null; //finally���� ���� ���ؼ� try�� �ۿ��� ����
			PreparedStatement pstmt = null; //�� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����. ������ pstmt�� ����. (alt shift r�� �̸� ��ü �ٲ�)
			
			try {
				con = DBUtil.getConnection(); //����
				pstmt = con.prepareStatement("insert into dept01 values(?,?,?)"); //�ӵ��� ������ �̸� ����� statement. ���� ������ŭ ? �������ش�
				//?�� �����Ͱ� ���������� ����
				pstmt.setInt(1, newDept.getDeptno()); //1��° ����ǥ�� ���� �־��ְڴٴ� �ǹ�
				pstmt.setString(2, newDept.getDname()); //2��° ����ǥ
				pstmt.setString(3, newDept.getLoc()); //3��° ����ǥ
				
				//db�� ���� ����
				
				int result =pstmt.executeUpdate(); //insert/update/delete ���� �޼ҵ�
				if(result == 0) {
					return false; //finally���� �ڿ����� ��ȯ�ǰ� return�� ����.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally { //finally���� ����ǰ� return ����. �ᱹ �Ѵ� ����Ǵ� ����. ���� �߿��� ����.
				DBUtil.close(con, pstmt);
			}
			return true;
		}
		
	//deptno�� loc ����
		public static boolean update(int deptno, String newLoc) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			//ResultSet rs = null;
							
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("update dept01 set loc = ? where deptno = ?");
				pstmt.setString(1, newLoc);
				pstmt.setInt(2, deptno);
			//	rs = pstmt.executeQuery();
				
				int result =pstmt.executeUpdate(); 
				if(result == 0) {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
				throw e;
				
			} finally {
				DBUtil.close(con, pstmt);
			}
		
			return true;
		}
	
	
	//deptno�� �ش� �μ� ����
		public static boolean delete(int deptno) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
							
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from dept01 where deptno = ?");
				pstmt.setInt(1, deptno);
				
				int result =pstmt.executeUpdate(); 
				if(result == 0) {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
				
			} finally {
				DBUtil.close(con, pstmt);
			}
			return true;
		}
}