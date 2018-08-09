/* oracle driver를 로딩 -> Connection -> Statement -> sql문장 실행
 * -> ResultSet or int -> 결과값 활용 -> 자원반환
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
		//try catch문 밖에서도 써야하니까 변수 선언을 해줘야한다 미리.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("driver 설치(로딩) 완료");
			/* java.sql.Connection은 (구)sun에서 제시한 DB접속 API
			 * interface 즉 실제 완벽하게 구현된게 아니라 구현하라고 명령들로만 채워짐.
			 * 실제 구현은 각 회사가 직접 하는 것.
			 * 이렇게 구현된 것은 ojdbc6.jar로 압축해서 제공 (db마다 다름)
			 * 따라서 실제 반환받은 Connection은 완벽한 자식 객체이고
			 * 다형성이 반영된 부모타입으로 upcasting
			 */
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","SCOTT", "TIGER"); //위에서 변수 타입 선언 했으니까 타입은 뺀다
			//http:// 처럼 통신 규약이 있다.
		//	System.out.println(con);
			stmt =con.createStatement(); //sql문장 실행객체. stmt는 다들 이렇게 쓰는 변수명
			rs = stmt.executeQuery("select * from dept"); //dept는 deptno, dname, loc 로 이루어짐
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //finally에서도 예외가 존재할 우려가 있어서(여기서는 변수들이 null인 경우 조건문을 넣는데,
			//여기서도 try catch문... 하나하나 예외 다 잡아야함.
		}
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) { //else if는 안됨
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
