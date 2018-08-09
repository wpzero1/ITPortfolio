/* oracle driver�� �ε� -> Connection -> Statement -> sql���� ����
 * -> ResultSet or int -> ����� Ȱ�� -> �ڿ���ȯ
 * (ojdbc6.jar -> oracle.jdbc.driver -> OracleDriver.class)
 */

package step01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//try catch�� �ۿ����� ����ϴϱ� ���� ������ ������Ѵ� �̸�.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("driver ��ġ(�ε�) �Ϸ�");
			/* java.sql.Connection�� (��)sun���� ������ DB���� API
			 * interface �� ���� �Ϻ��ϰ� �����Ȱ� �ƴ϶� �����϶�� ��ɵ�θ� ä����.
			 * ���� ������ �� ȸ�簡 ���� �ϴ� ��.
			 * �̷��� ������ ���� ojdbc6.jar�� �����ؼ� ���� (db���� �ٸ�)
			 * ���� ���� ��ȯ���� Connection�� �Ϻ��� �ڽ� ��ü�̰�
			 * �������� �ݿ��� �θ�Ÿ������ upcasting
			 */
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","SCOTT", "TIGER"); //������ ���� Ÿ�� ���� �����ϱ� Ÿ���� ����
			//http:// ó�� ��� �Ծ��� �ִ�.
		//	System.out.println(con);
			stmt =con.createStatement(); //sql���� ���ఴü. stmt�� �ٵ� �̷��� ���� ������
			rs = stmt.executeQuery("select * from dept"); //dept�� deptno, dname, loc �� �̷����
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //finally������ ���ܰ� ������ ����� �־(���⼭�� �������� null�� ��� ���ǹ��� �ִµ�,
			//���⼭�� try catch��... �ϳ��ϳ� ���� �� ��ƾ���.
		}
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) { //else if�� �ȵ�
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
