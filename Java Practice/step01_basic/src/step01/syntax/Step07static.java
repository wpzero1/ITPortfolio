package step01.syntax;

public class Step07static {
	static int no; //객체 생성 이전에 사용 가능
	
	int getNo() { //no를 얻는 메소드 만들기. 객체 생성 이후에만 사용 가능
		return no;
	}
	/* 애시당초 오류인 문법
	int no2; //객체 생성 이후에 사용 가능
	static int getNo2() { //객체 생성 이전에 사용 가능
		return no2; //객체가 없는데? no2 존재 여부?
		
	}
	*/
	
	
	public static void main(String[] args) {

	}

}
