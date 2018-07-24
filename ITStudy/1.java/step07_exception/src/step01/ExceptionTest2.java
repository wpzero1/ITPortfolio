/*학습내용
 * 1. 예외 처리 문법 익숙해지기
 * 2. 처리 문법
 * 		1) try ~ catch
 * 			예외 발생될 수도 있는 가능성 있는 로직 자체에 직접 처리
 * 		2) throws
 * 			예외 발생시 예외 처리를 호출한 곳으로 위임
 * 		3) 예외 발생 여부와 무관하게 100% 실행 보장 블록
 * 			자원 반환 로직 등에 권장
 * 			DB접촉 자원 해제, 입출력(IO) 자원들 반환에 주로 사용
 * 			try~catch~finally
 */
package step01;

public class ExceptionTest2 {

	//step01 - 
	static void m1() {
		try {//예외 발생 가능성 있는 코드들 영역
			Class.forName("step01.A");
		} catch (ClassNotFoundException e) { //해당 예외가 발생시 처리블록
			e.printStackTrace(); //예외 발생시 상세 상황 파악 가능한 메소드
		}
	}
	//step02- 예외 처리를 호출한 곳으로 위임 : 문제가 생겨도 호출한 쪽에서 해결하도록
	static void m2() throws ClassNotFoundException { //결국엔 try catch 해야함
		
			Class.forName("step01.A");
		
		}
	
	//step03-
	static void m3() {
		try {
			Class.forName("step01.Aaaaafdfa"); //오타났을때 과연 출력 될까?
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		} finally {
			System.out.println("예외 발생 여부와 무관하게 100% 실행 보장");
		}
	}
	//step04-
	static String m4() {
			try {
				Class.forName("step01.Aee"); //역시 오타
			} catch (ClassNotFoundException e) {
				e.printStackTrace(); 
				System.out.println("미 존재하는 byte code입니다");
			} finally { //문제가 있건 없건 무조건 실행됨
				System.out.println("예외 발생 여부와 무관하게 100% 실행 보장");
	}	
			return "데이터 반환?"; //이것도 무조건 반환됨
	}
	public static void main(String[] args) {
		m1();
		try { //호출한 쪽에서는 결국엔 try catch를 해야함
		m2();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		m3();
		System.out.println(m4());
	}
}
