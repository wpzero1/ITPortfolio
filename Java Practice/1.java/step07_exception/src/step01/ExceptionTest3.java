package step01;

public class ExceptionTest3 {
	// id값의 검증 - tester
	// if 조건식으로
	static void idCheck1(String id) {
		if("tester".equals(id)) {
			System.out.println("회원");
		}else {
			System.out.println("비회원");
		}
	}
	
	//exception 처리
	//상황에 맞게 개발자가 직접 예외를 발생 -> 처리
	
	static void idCheck2(String id) throws Exception { //밑에서 throw new를 줬다면, 앞에서도 예외 상황이 있을거다 라고 말해야함
		if(!"tester".equals(id)) {
			throw new Exception("비회원임");
		}
		System.out.println("회원"); //문제 발생시 이 라인은 지나침
	}
	
	public static void main(String[] args) {
		idCheck1("tester");
		try {
		idCheck2("test");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()); //예외 문구를 내보내는 것
		}
	}

}
