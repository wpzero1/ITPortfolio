package step02.hasa; //has a 해즈어 패키지

public class Car {
	Engine engine = new Engine(); //Car의 멤버로 호출. car객체
	
	//engine 이름이 출력되는 메소드 개발
	void printEngineName() {
		System.out.println(engine.getEngineName());
	}
	//engine의 기본 cc
	void printCC() {
		System.out.println(engine.getCc());
	}
	
}
