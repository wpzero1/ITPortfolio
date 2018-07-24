package step01;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println(1);
		try { //예외 나올 문장을 try, catch 써줌
		System.out.println(10/0);
		}catch(ArithmeticException e) {
		e.printStackTrace();
		}//예외 발생 상세 정보를 콘솔창에 띄워주기
		System.out.println(2);
		
		/*
		 * 다른 일반 class의 byte code를 메모리에 로딩하는 기능의 API 메소드
		 * 		Class.forName("Step01.A"); //문법 오류는 없는데 실행이 안돼
		 *1. parameter 클래스를 메모리에 로딩
		 *2. 이 로직 실행 발생 가능한 경우의 수
		 *		1) 정상 : 로딩(저장) 성공
		 *		2) 비정상 : 비정상 상황을 이 메소드 호출한 곳에 알려줘야함
		 *3. 경우의 수 모두 다 적용한 처리 기수
		 *	1) 이 메소드를 사용할 경우 무조건 발생 가능한 불안정 할수도 있는 상황을 처리 하곘음 지시
		 *	-> 예외 처리. try and catch
		 */

		/*try {
			Class.forName("step01.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();*/
		}
	}


class A {
	static {
		System.out.println("A의 byte code가 로딩 되었습니다.");
	}
}